package firstcup.sql.util;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.sql.*;
import java.util.logging.Logger;

/**
 * Tool to run database scripts
 */
public class ScriptRunner {

    private static final String DEFAULT_DELIMITER = ";";

    private boolean stopOnError;
    private boolean autoCommit;

   private final static Logger LOGGER = Logger.getLogger(ScriptRunner.class.getName());

    private String delimiter = DEFAULT_DELIMITER;
    private boolean fullLineDelimiter = false;

    /**
     * Default constructor
     */
    public ScriptRunner(boolean autoCommit,
                        boolean stopOnError) {
        this.autoCommit = autoCommit;
        this.stopOnError = stopOnError;
    }

    public void setDelimiter(String delimiter, boolean fullLineDelimiter) {
        this.delimiter = delimiter;
        this.fullLineDelimiter = fullLineDelimiter;
    }

    /**
     * Runs an SQL script (read in using the Reader parameter)
     *
     * @param reader
     *            - the source of the script
     */
    public void runScript(Connection connection, Reader reader) throws IOException, SQLException {
        try {
            boolean originalAutoCommit = connection.getAutoCommit();
            try {
                if (originalAutoCommit != this.autoCommit) {
                    connection.setAutoCommit(this.autoCommit);
                }
                executeScript(connection, reader);
            } finally {
                connection.setAutoCommit(originalAutoCommit);
            }
        } catch (IOException | SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error running script.  Cause: " + e, e);
        }
    }

    /**
     * Runs an SQL script (read in using the Reader parameter) using the
     * connection passed in
     *
     * @param conn
     *            - the connection to use for the script
     * @param reader
     *            - the source of the script
     * @throws java.sql.SQLException
     *             if any SQL errors occur
     * @throws java.io.IOException
     *             if there is an error reading from the Reader
     */
    private void executeScript(Connection conn, Reader reader) throws IOException,
            SQLException {
        StringBuffer command = null;
        try {
            LineNumberReader lineReader = new LineNumberReader(reader);
            String line = null;
            while ((line = lineReader.readLine()) != null) {
                if (command == null) {
                    command = new StringBuffer();
                }
                String trimmedLine = line.trim();
                if (trimmedLine.startsWith("--")) {
                    println(trimmedLine);
                } else if (trimmedLine.length() < 1
                        || trimmedLine.startsWith("//")) {
                    // Do nothing
                } else if (trimmedLine.length() < 1
                        || trimmedLine.startsWith("--")) {
                    // Do nothing
                } else if (!fullLineDelimiter
                        && trimmedLine.endsWith(getDelimiter())
                        || fullLineDelimiter
                        && trimmedLine.equals(getDelimiter())) {
                    command.append(line.substring(0, line
                            .lastIndexOf(getDelimiter())));
                    command.append(" ");
                    Statement statement = conn.createStatement();

                    println(command.toString());

                    boolean hasResults = false;
                    if (stopOnError) {
                        hasResults = statement.execute(command.toString());
                    } else {
                        try {
                            statement.execute(command.toString());
                        } catch (SQLException e) {
                            e.fillInStackTrace();
                            printlnError("Error executing: " + command);
                            printlnError(e.getMessage());
                        }
                    }

                    if (autoCommit && !conn.getAutoCommit()) {
                        conn.commit();
                    }

                    ResultSet rs = statement.getResultSet();
                    if (hasResults && rs != null) {
                        ResultSetMetaData md = rs.getMetaData();
                        int cols = md.getColumnCount();
                        for (int i = 0; i < cols; i++) {
                            String name = md.getColumnLabel(i);
                            print(name + "\t");
                        }
                        println("");
                        while (rs.next()) {
                            for (int i = 0; i < cols; i++) {
                                String value = rs.getString(i);
                                print(value + "\t");
                            }
                            println("");
                        }
                    }

                    command = null;
                    try {
                        statement.close();
                    } catch (Exception e) {
                        // Ignore to workaround a bug in Jakarta DBCP
                    }
                    Thread.yield();
                } else {
                    command.append(line);
                    command.append(" ");
                }
            }
            if (!autoCommit) {
                conn.commit();
            }
        } catch (SQLException | IOException e) {
            e.fillInStackTrace();
            printlnError("Error executing: " + command);
            printlnError(e.getMessage());
            throw e;
        } finally {
            conn.rollback();
        }
    }

    private String getDelimiter() {
        return delimiter;
    }

    private void print(String msg) {
        LOGGER.info(msg);
    }

    private void println(String msg) {
        LOGGER.info(msg);
    }

    private void printlnError(String msg) {
        LOGGER.severe(msg);
    }
}
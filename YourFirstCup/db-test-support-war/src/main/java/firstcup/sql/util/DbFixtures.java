package firstcup.sql.util;

import firstcup.constants.JndiConstants;
import firstcup.sql.runner.ScriptRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;

public class DbFixtures {
    
    private static final String DELETE_SQL_FILE = "/db_scripts/delete.sql";
    private static final String CREATE_SQL_FILE = "/db_scripts/create.sql";
    private static final String INSERT_SQL_FILE = "/db_scripts/insert.sql";
    private final ScriptRunner scriptRunner = new ScriptRunner(false, true);

    @Resource(lookup = JndiConstants.FIRSTCUPDS)
    private DataSource dataSource;

    public void createDbFixtures() throws Exception {
        createDbObjects();
        insertDbFixtures();
    }
    
    public void resetDbFixtures() throws Exception {
        clearDbFixtures();
        createDbObjects();
        insertDbFixtures();
    }
    
    public void clearDbFixtures() throws Exception {
        runSqlScript(DELETE_SQL_FILE);
    }

    public void createDbObjects() throws Exception {
        runSqlScript(CREATE_SQL_FILE);
        
    }
    
    public void insertDbFixtures() throws Exception {
        runSqlScript(INSERT_SQL_FILE);
        
    }

    private void runSqlScript(String sqlFile) throws Exception {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(sqlFile);
        Reader reader = new BufferedReader(new InputStreamReader(inputStream));
        try(Connection connection = dataSource.getConnection()) {
            scriptRunner.runScript(connection, reader);
        }

    }
}

package firstcup.sql.util;

import javax.inject.Inject;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;

public class DbFixtures {
    
    private static final String DELETE_SQL_FILE = "db_scripts/delete.sql";
    private static final String DROP_SQL_FILE = "db_scripts/drop.sql";
    private static final String CREATE_SQL_FILE = "db_scripts/create.sql";
    private static final String INSERT_SQL_FILE = "db_scripts/insert.sql";
    private final ScriptRunner scriptRunner = new ScriptRunner(false, true);

    @Inject
    @DbFixturesDataSource
    private DataSource dataSource;

    public void createDbFixtures() throws Exception {
        createDbObjects();
        insertDbFixtures();
    }
    
    public void resetDbFixtures() throws Exception {
        clearDbFixtures();
        insertDbFixtures();
    }

    public void resetDatabase() throws Exception {
        clearDbFixtures();
        clearDbObjects();
        createDbObjects();
        insertDbFixtures();
    }
    
    public void clearDbFixtures() throws Exception {
        runSqlScript(DELETE_SQL_FILE);
    }
    
    public void clearDbObjects() throws Exception {
        runSqlScript(DELETE_SQL_FILE);
        runSqlScript(DROP_SQL_FILE);
        
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

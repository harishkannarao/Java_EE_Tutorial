package firstcup.sql.util;

import firstcup.sql.runner.ScriptRunner;

import java.io.*;
import java.sql.Connection;

public class DbFixtures {
    
    private static final String DELETE_SQL_FILE = "db_scripts/delete.sql";
    private static final String CREATE_SQL_FILE = "db_scripts/create.sql";
    private static final String INSERT_SQL_FILE = "db_scripts/insert.sql";
    private final ScriptRunner scriptRunner;
    
    public DbFixtures(Connection connection) {
        scriptRunner = new ScriptRunner(connection, true, true);
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
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(sqlFile).getFile());
        Reader reader = new BufferedReader(new FileReader(file));
        scriptRunner.runScript(reader);
        
    }
}

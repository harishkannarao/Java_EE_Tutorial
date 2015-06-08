package firstcup.entity;

import firstcup.runner.WeldContext;
import firstcup.sql.util.DbFixtures;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class DbFixturesSupport {
    
    @BeforeSuite
    public static void createDbFixtures() throws Exception {
        DbFixtures dbFixtures = WeldContext.INSTANCE.getBean(DbFixtures.class);
        dbFixtures.createDbFixtures();
    }
    
    @AfterSuite
    public static void clearDbObjects() throws Exception {
        DbFixtures dbFixtures = WeldContext.INSTANCE.getBean(DbFixtures.class);
        dbFixtures.clearDbObjects();
        
    }
}

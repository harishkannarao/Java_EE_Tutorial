package firstcup.entity;

import firstcup.runner.WeldContext;
import firstcup.runner.WeldJUnit4Runner;
import firstcup.sql.util.DbFixtures;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(WeldJUnit4Runner.class)
public abstract class DbFixturesSupport {
    
    @BeforeClass
    public static void createDbFixtures() throws Exception {
        DbFixtures dbFixtures = WeldContext.INSTANCE.getBean(DbFixtures.class);
        dbFixtures.createDbFixtures();
    }
    
    @AfterClass
    public static void clearDbObjects() throws Exception {
        DbFixtures dbFixtures = WeldContext.INSTANCE.getBean(DbFixtures.class);
        dbFixtures.clearDbObjects();
        
    }
}

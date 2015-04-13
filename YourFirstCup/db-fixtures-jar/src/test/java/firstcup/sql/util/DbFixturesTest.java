package firstcup.sql.util;

import firstcup.runner.WeldContext;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.Test;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

public class DbFixturesTest {

    private final JdbcDataSource dataSource;

    public DbFixturesTest() {
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:someTestSchema;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUser("sa");
    }

    @Test
    public void fixtures_shouldBeAbleToRunRepeatedly() throws Exception {
        DbFixtures dbFixtures = WeldContext.INSTANCE.getBean(DbFixtures.class);
        dbFixtures.createDbFixtures();
        dbFixtures.clearDbObjects();
        dbFixtures.createDbFixtures();
        dbFixtures.clearDbObjects();
    }

    @Produces
    @Default
    @DbFixturesDataSource
    public DataSource getH2DataSource() {
        return dataSource;

    }
}

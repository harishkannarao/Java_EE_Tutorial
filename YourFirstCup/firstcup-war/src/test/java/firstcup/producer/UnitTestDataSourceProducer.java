package firstcup.producer;


import firstcup.sql.util.DbFixturesDataSource;
import org.h2.jdbcx.JdbcDataSource;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

public class UnitTestDataSourceProducer {
    
    private final JdbcDataSource dataSource;

    public UnitTestDataSourceProducer() {
        dataSource = new JdbcDataSource();
        dataSource.setURL("jdbc:h2:mem:firstcupTest;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
        dataSource.setUser("sa");
    }

    @Produces
    @Default
    @DbFixturesDataSource
    public DataSource getH2DataSource() {
        return dataSource;
        
    }
}

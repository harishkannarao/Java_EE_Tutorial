package firstcup.sql.producer;

import firstcup.constants.JndiConstants;
import firstcup.sql.util.DbFixturesDataSource;

import javax.annotation.Resource;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

public class JndiDataSourceProducer {

    @Produces
    @Default
    @DbFixturesDataSource
    @Resource(lookup = JndiConstants.FIRSTCUPDS)
    private DataSource dataSource;
}

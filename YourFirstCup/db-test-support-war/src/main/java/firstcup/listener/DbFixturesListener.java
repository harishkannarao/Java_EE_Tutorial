package firstcup.listener;

import firstcup.sql.util.DbFixtures;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class DbFixturesListener implements ServletContextListener {
    private final static Logger LOGGER = Logger.getLogger(DbFixturesListener.class.getName());
    @Inject
    private DbFixtures dbFixtures;
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
//            dbFixtures.createDbFixtures();
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

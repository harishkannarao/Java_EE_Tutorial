package firstcup.service;

import firstcup.dao.DbSupportDao;
import firstcup.sql.util.DbFixtures;

import javax.inject.Inject;

public class DbFixturesService {
    @Inject
    DbFixtures dbFixtures;
    @Inject
    private DbSupportDao dbSupportDao;


    public void resetDbFixtures() throws Exception {
        dbFixtures.resetDbFixtures();
        dbSupportDao.deleteFirstcupEntries();
    }
    
    public void clearDbFixtures() throws Exception {
        dbFixtures.clearDbFixtures();
        dbSupportDao.deleteFirstcupEntries();
    }
}

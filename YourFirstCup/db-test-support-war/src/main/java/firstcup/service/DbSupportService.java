package firstcup.service;

import firstcup.dao.DbSupportDao;
import firstcup.model.AgeDifferenceInfo;

import javax.inject.Inject;

public class DbSupportService {
    
    @Inject
    private DbSupportDao dbSupportDao;
    
    public AgeDifferenceInfo getAgeDifferenceInfo() throws Exception{
        return dbSupportDao.getAgeDifferenceInfo();
    }
}

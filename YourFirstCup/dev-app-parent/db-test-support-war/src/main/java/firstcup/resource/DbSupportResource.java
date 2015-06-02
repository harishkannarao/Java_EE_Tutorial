package firstcup.resource;

import firstcup.model.AgeDifferenceInfo;
import firstcup.service.DbSupportService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dbSupport")
public class DbSupportResource {
    

    private DbSupportService dbSupportService;

    @Inject
    public void setDbSupportService(DbSupportService dbSupportService) {
        this.dbSupportService = dbSupportService;
    }

    @GET
    @Path("getAgeDifferenceInfo")
    @Produces("application/json")
    public AgeDifferenceInfo getAgeDifferenceInfo() throws Exception {
       return dbSupportService.getAgeDifferenceInfo();
        
    }
}

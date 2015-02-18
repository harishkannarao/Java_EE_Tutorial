package firstcup.resource;

import firstcup.model.AgeDifferenceInfo;
import firstcup.service.DbSupportService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dbSupport")
public class DbSupportResource {
    
    @Inject
    private DbSupportService dbSupportService;
    
    @GET
    @Path("getAgeDifferenceInfo")
    @Produces("application/json")
    public AgeDifferenceInfo getAgeDifferenceInfo() throws Exception {
       return dbSupportService.getAgeDifferenceInfo();
        
    }
}

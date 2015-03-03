package firstcup.resource;

import firstcup.service.DbFixturesService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dbFixtures")
public class DbFixturesResource {
    
    @Inject
    DbFixturesService dbFixturesService;

    @GET
    @Path("reset")
    @Produces("text/plain")
    public String reset() throws Exception {
        dbFixturesService.resetDbFixtures();
        return "Success!!!";
    }

    @GET
    @Path("clear")
    @Produces("text/plain")
    public String clear() throws Exception {
        dbFixturesService.clearDbFixtures();
        return "Success!!!";
    }
}

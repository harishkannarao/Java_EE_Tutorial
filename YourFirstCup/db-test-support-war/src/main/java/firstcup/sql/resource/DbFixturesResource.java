package firstcup.sql.resource;

import firstcup.sql.util.DbFixtures;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("dbFixtures")
public class DbFixturesResource {
    
    @Inject
    DbFixtures dbFixtures;

    @GET
    @Path("reset")
    @Produces("text/plain")
    public String reset() throws Exception {
        dbFixtures.resetDbFixtures();
        return "Success!!!";
    }
}

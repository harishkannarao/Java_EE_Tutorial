package firstcup.dukesage.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Path("jsonTest")
public class JsonTestResource {

    private Map<Long, User> user = new HashMap<>();

    public JsonTestResource() {
        User user1 = new User(
                1L,
                "user name",
                new Name("first name", "last name"),
                new Address("some street", "some city", "some post code"),
                Arrays.asList(new Contact("123456", "office"), new Contact("654321", "home")),
                (String [])Arrays.asList("java", "java ee").toArray()
        );

        User user2 = new User(
                2L,
                null,
                null,
                null,
                null,
                null
        );

        User user3 = new User(
                3L,
                "",
                new Name(null, " "),
                new Address(null, null, null),
                Arrays.asList(),
                new String[0]
        );

        User user4 = new User(
                4L,
                "user name",
                new Name("first name", "last name"),
                new Address("some street", "some city", "some post code"),
                Arrays.asList(new Contact("123456", "office")),
                (String [])Arrays.asList("java").toArray()
        );


        user.put(user1.getId(), user1);
        user.put(user2.getId(), user2);
        user.put(user3.getId(), user3);
        user.put(user4.getId(), user4);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("id") Long id) {
        return user.get(id);
    }
}

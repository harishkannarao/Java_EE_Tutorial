package firstcup.dukesage.resource;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DukesAgeResourceTest {

    @Test
    public void resource_shouldReturnDukesAge() {
        int dukesAgeFromService = getAgeFromService();
        int expectedAge = calculateExpectedAge();

        assertEquals("Incorrect age", expectedAge, dukesAgeFromService);
    }


    private int getAgeFromService() {
        Client client = ClientBuilder.newClient();
        WebTarget target
                = client.target("http://localhost:8080/dukes-age/webapi/dukesAge");
        String response = target.request().get(String.class);
        return Integer.parseInt(response);
    }

    private int calculateExpectedAge() {
        // same logic as in DukesAgeResource
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
        Calendar now = GregorianCalendar.getInstance();
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
        return dukesAge;
    }
}

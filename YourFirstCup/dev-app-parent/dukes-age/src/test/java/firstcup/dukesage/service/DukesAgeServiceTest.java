package firstcup.dukesage.service;


import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DukesAgeServiceTest {

    DukesAgeService service = new DukesAgeService();

    @Test
    public void getAge_shouldReturnDukesAge() {
        String actualAge = service.getAge();
        String expectedAge = calculateExpectedAge();

        assertEquals("Incorrect age", expectedAge, actualAge);
    }

    private String calculateExpectedAge() {
        // same logic as in DukesAgeService
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
        Calendar now = GregorianCalendar.getInstance();
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
        return "" + dukesAge;
    }


}

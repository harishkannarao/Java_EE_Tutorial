package firstcup.dukesage.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DukesAgeService {

    public int getAge() {
        // Create a new Calendar for Duke's birthday
        Calendar dukesBirthday = new GregorianCalendar(1995, Calendar.MAY, 23);
// Create a new Calendar for today
        Calendar now = GregorianCalendar.getInstance();

// Subtract today's year from Duke's birth year, 1995
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);

// If today's date is before May 23, subtract a year from Duke's age
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
// Return Duke's age
        return dukesAge;
    }
}

package firstcup.bdd.util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarUtil {
    public int calculateAgeDifference(Calendar calendar1, Calendar calendar2) {
        int age = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);
        calendar1.add(Calendar.YEAR, age);
        if (calendar2.before(calendar1)) {
            age--;
        }
        return age;
    }

    public int calculateAge(Calendar dateOfBirth) {
        Calendar now = GregorianCalendar.getInstance();
        int dukesAge = now.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        dateOfBirth.add(Calendar.YEAR, dukesAge);
        if (now.before(dateOfBirth)) {
            dukesAge--;
        }
        return dukesAge;
    }

    public Calendar getDukesBirthday() {
        return new GregorianCalendar(1995, Calendar.MAY, 23);
    }
}

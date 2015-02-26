package firstcup.bdd;

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

    public Calendar getDukesBirthday() {
        return new GregorianCalendar(1995, Calendar.MAY, 23);
    }
}

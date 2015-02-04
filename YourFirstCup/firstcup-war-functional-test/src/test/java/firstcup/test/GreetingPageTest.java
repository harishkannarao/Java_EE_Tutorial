package firstcup.test;

import firstcup.page.GreetingPage;
import firstcup.page.ResponsePage;
import firstcup.runner.WeldJUnit4Runner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(WeldJUnit4Runner.class)
public class GreetingPageTest {

    @Inject
    GreetingPage greetingPage;
    @Inject
    private ResponsePage responsePage;

    @Test
    public void shouldDisplay_dukesAge() {
        // given
        greetingPage.navigate();
        
        // when
        
        // then
        assertEquals(expectedDukesAge(),greetingPage.getDukesAge());
    }

    @Test
    public void shouldDisplay_olderMessage_givenDateIsTwoYearsBeforeDukeBirthday() {
        // given
        greetingPage.navigate();
        
        // when
        greetingPage.setBirthday("05/23/1993");
        greetingPage.clickSubmit();
        
        //then
        assertEquals("You are 2 years older than Duke!", responsePage.getAgeDifferenceMessage());
    }

    @Test
    public void shouldDisplay_olderMessage_givenDateIsOneYearBeforeDukeBirthday() {
        // given
        greetingPage.navigate();

        // when
        greetingPage.setBirthday("05/23/1994");
        greetingPage.clickSubmit();

        //then
        assertEquals("You are 1 year older than Duke!", responsePage.getAgeDifferenceMessage());

    }

    @Test
    public void shouldDisplay_sameYearMessage_givenDateIsOneDayBeforeDukeBirthday() {
        // given
        greetingPage.navigate();

        // when
        greetingPage.setBirthday("05/22/1995");
        greetingPage.clickSubmit();

        //then
        assertEquals("You are the same age as Duke!", responsePage.getAgeDifferenceMessage());

    }

    @Test
    public void shouldDisplay_sameYearMessage_givenDateIsSameDayAsDukeBirthday() {
        // given
        greetingPage.navigate();

        // when
        greetingPage.setBirthday("05/23/1995");
        greetingPage.clickSubmit();

        //then
        assertEquals("You are the same age as Duke!", responsePage.getAgeDifferenceMessage());

    }

    @Test
    public void shouldDisplay_sameYearMessage_givenDateIsOneDayAfterDukeBirthday() {
        // given
        greetingPage.navigate();

        // when
        greetingPage.setBirthday("05/24/1995");
        greetingPage.clickSubmit();

        //then
        assertEquals("You are the same age as Duke!", responsePage.getAgeDifferenceMessage());

    }

    @Test
    public void shouldDisplay_youngerMessage_givenDateIsOneYearAfterDukeBirthday() {
        // given
        greetingPage.navigate();

        // when
        greetingPage.setBirthday("05/23/1996");
        greetingPage.clickSubmit();

        //then
        assertEquals("You are 1 year younger than Duke!", responsePage.getAgeDifferenceMessage());

    }

    @Test
    public void shouldDisplay_youngerMessage_givenDateIsTwoYearsAfterDukeBirthday() {
        // given
        greetingPage.navigate();

        // when
        greetingPage.setBirthday("05/23/1997");
        greetingPage.clickSubmit();

        //then
        assertEquals("You are 2 years younger than Duke!", responsePage.getAgeDifferenceMessage());

    }

    private int expectedDukesAge() {
        // same logic as in Application
        Calendar dukesBirthday = getDukesBirthday();
        Calendar now = GregorianCalendar.getInstance();
        int dukesAge = now.get(Calendar.YEAR) - dukesBirthday.get(Calendar.YEAR);
        dukesBirthday.add(Calendar.YEAR, dukesAge);
        if (now.before(dukesBirthday)) {
            dukesAge--;
        }
        return dukesAge;
    }
    
    private Calendar getDukesBirthday() {
        return new GregorianCalendar(1995, Calendar.MAY, 23);
    }


}

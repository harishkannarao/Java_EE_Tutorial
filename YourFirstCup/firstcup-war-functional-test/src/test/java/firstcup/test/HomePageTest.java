package firstcup.test;

import firstcup.page.HomePage;
import firstcup.runner.WeldJUnit4Runner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertTrue;

@RunWith(WeldJUnit4Runner.class)
public class HomePageTest {

    @Inject
    HomePage homePage;

    @Test
    public void shouldLoad_greetingPage_asHomePage() {
        // given

        // when
        homePage.navigate();

        // then
        assertTrue(homePage.isOnValidPage());
    }
}

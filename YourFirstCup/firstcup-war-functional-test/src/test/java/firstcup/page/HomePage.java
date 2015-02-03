package firstcup.page;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{

    private static final String PAGE_URL = "";

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }
}

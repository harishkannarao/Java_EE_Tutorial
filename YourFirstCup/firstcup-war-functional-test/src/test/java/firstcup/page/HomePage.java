package firstcup.page;

public class HomePage extends PageBase{

    private static final String PAGE_URL = "";
    private static final String PAGE_ID = "qa-greeting";

    @Override
    protected String getPageUrl() {
        return PAGE_URL;
    }

    @Override
    protected String getPageId() {
        return PAGE_ID;
    }
}

package firstcup.dukesage;

public class TestBase {

    protected String getAppServerUrl() {
        return System.getProperty("appServerUrl", "http://localhost:8080");
    }
}

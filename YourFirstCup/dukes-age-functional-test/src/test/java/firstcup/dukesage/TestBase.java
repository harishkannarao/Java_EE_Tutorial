package firstcup.dukesage;

public abstract class TestBase {

    protected String getAppServerUrl() {
        return System.getProperty("appServerUrl", "http://localhost:8080");
    }
}

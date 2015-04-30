package firstcup.dukesage;

public abstract class CommonBase {

    protected String getAppServerUrl() {
        return System.getProperty("appServerUrl", "http://localhost:8080");
    }
}

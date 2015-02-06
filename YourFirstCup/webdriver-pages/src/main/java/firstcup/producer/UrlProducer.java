package firstcup.producer;

import firstcup.producer.qualifier.AppContext;
import firstcup.producer.qualifier.AppUrl;

import javax.enterprise.inject.Produces;

public class UrlProducer {

    private static final String APP_SERVER_KEY = "appServerUrl";
    private static final String DEFAULT_APP_SERVER_VALUE = "http://localhost:8080";
    private static final String DEFAULT_APP_CONTEXT_VALUE = "firstcup-war";

    @Produces
    @AppUrl
    public String getAppUrl() {
        return System.getProperty(APP_SERVER_KEY, DEFAULT_APP_SERVER_VALUE);
    }

    @Produces
    @AppContext
    public String getAppContext() {
        return DEFAULT_APP_CONTEXT_VALUE;
    }
}

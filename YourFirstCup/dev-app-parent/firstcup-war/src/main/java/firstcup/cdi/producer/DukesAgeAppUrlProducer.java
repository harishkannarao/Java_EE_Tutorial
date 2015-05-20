package firstcup.cdi.producer;

import firstcup.cdi.producer.qualifier.DukesAgeAppUrl;

import javax.enterprise.inject.Produces;

public class DukesAgeAppUrlProducer {

    private static final String DUKE_AGE_APP_URL_KEY = "firstcup.dukeAgeAppUrl";

    @Produces
    @DukesAgeAppUrl
    public String getDukesAgeAppUrl() {
        return System.getProperty(DUKE_AGE_APP_URL_KEY);
    }
}

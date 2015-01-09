package firstcup.dukesage.resource;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertTrue;

public class SampleTest {

    @Test
    public void testServerStartup() {
        boolean serverRunning = ping("http://localhost:8080", 1000);

        assertTrue(serverRunning);

    }

    public static boolean ping(String url, int timeoutInMillis) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeoutInMillis);
            connection.setReadTimeout(timeoutInMillis);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            return (200 == responseCode);
        } catch (IOException exception) {
            return false;
        }
    }
}

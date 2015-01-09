package firstcup.dukesage.resource;

import org.apache.maven.shared.invoker.*;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

import static org.junit.Assert.assertTrue;

public class SampleTest {

    @Test
    public void testServerStartup() throws Exception {
        boolean serverRunning = ping("http://localhost:8080", 1000);

        if(!serverRunning) {
            deployApps();
//            startServer();

            assertTrue(ping("http://localhost:8080", 5000));
        }
    }

    @Test
    public void simpleTest() {
        System.out.print(new File("../pom.xml").getAbsolutePath());
    }

    public boolean ping(String url, int timeoutInMillis) {
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

    public void startServer() throws Exception {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                InvocationRequest request = new DefaultInvocationRequest();
                request.setPomFile(new File("../wildfly-setup/pom.xml"));
                request.setGoals(Collections.singletonList("cargo:run"));

                Invoker invoker = new DefaultInvoker();
                try {
                    invoker.execute( request );
                } catch (MavenInvocationException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

    }

    public void deployApps() throws Exception {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "../pom.xml" ) );
        request.setGoals( Collections.singletonList("install") );
        request.setProfiles(Collections.singletonList("deploy-apps"));

        Invoker invoker = new DefaultInvoker();
        InvocationResult result = invoker.execute( request );

        if ( result.getExitCode() != 0 ) {
            throw new IllegalStateException( "Build failed. Please run 'mvn clean install -P deploy-apps' to know the reason" );
        }
    }
}

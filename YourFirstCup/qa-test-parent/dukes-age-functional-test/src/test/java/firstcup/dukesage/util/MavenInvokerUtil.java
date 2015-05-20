package firstcup.dukesage.util;

import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Collections;

public class MavenInvokerUtil {
    public void deployApps() throws Exception {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "../pom.xml" ) );
        request.setGoals( Collections.singletonList("install") );
        request.setProfiles(Collections.singletonList("deploy-apps"));

        Invoker invoker = new DefaultInvoker();
        InvocationResult result = invoker.execute( request );

        if ( result.getExitCode() != 0 ) {
            throw new IllegalStateException( "Build failed. Please run 'mvn clean install -P deploy-apps' on the root pom.xml to know the reason" );
        }
    }
}

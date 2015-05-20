package firstcup.dukesage.util;

import org.codehaus.cargo.container.InstalledLocalContainer;
import org.codehaus.cargo.container.configuration.LocalConfiguration;
import org.codehaus.cargo.container.wildfly.WildFly8xExistingLocalConfiguration;
import org.codehaus.cargo.container.wildfly.WildFly8xInstalledLocalContainer;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CargoWildflyUtil {

    InstalledLocalContainer container;

    public CargoWildflyUtil() {
        Path currentRelativePath = Paths.get("");

        String currentRelativePathStr = currentRelativePath.toAbsolutePath().toString();

        LocalConfiguration configuration = new WildFly8xExistingLocalConfiguration(currentRelativePathStr + "/../wildfly-setup/target/wildfly-8.1.0.Final/standalone");
        this.container = new WildFly8xInstalledLocalContainer(configuration);
        this.container.setHome(currentRelativePathStr + "/../wildfly-setup/target/wildfly-8.1.0.Final");
    }

    public void startWildfly() {
        container.start();
    }

    public void stopWildfly() {
        container.stop();
    }
}

package firstcup.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("firstcupPUTest");
    
    @Produces
    @ApplicationScoped
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
        
    }
    
    public void closeEntityManager(@Disposes EntityManager entityManager) {
        entityManager.close();
        
    }
}

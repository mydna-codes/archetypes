package ${package}.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PersistenceProducer {

    @PersistenceContext(unitName = "${artifactId}-jpa-unit")
    private EntityManager em;

    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return em;
    }

    public void disposeEntityManager(@Disposes EntityManager em){
        if (em.isOpen())
            em.close();
    }
}
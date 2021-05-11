package projectplayground.core;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class H2Controller {

    private static H2Controller instance;
    private final EntityManagerFactory factory;

    public static H2Controller getManager(){
        if(Objects.isNull(instance)){
            instance = new H2Controller(Persistence.createEntityManagerFactory("projectplayground"));
        }
    return instance;
    }
public EntityManager getEntityManager(){
        return factory.createEntityManager();
}
}

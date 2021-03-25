package ru.romankuznetsov.oldRepo;

import org.springframework.stereotype.Repository;
import ru.romankuznetsov.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class PersonRepo {
//    @PersistenceUnit
//    private EntityManagerFactory factory;

    @PersistenceContext
    private EntityManager em;
//    @PostConstruct
//    public void init(){
//        this.em = factory.createEntityManager();
//    }

    public Optional<Person> findPersonById(long id){
        return Optional.ofNullable(em.find(Person.class, id));
    }
}

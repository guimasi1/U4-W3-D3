package org.example.dao;

import org.example.entities.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class PersonsDAO {
    private final EntityManager em;

    public PersonsDAO(EntityManager em) {
        this.em = em;
    }

    public List<Person> findByQuery (String title) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        Root<Person> root = criteria.from(Person.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("title"), title));
        List<Person> events = em.createQuery(criteria).getResultList();
        return events;


    }
    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(person);

        transaction.commit();

        System.out.println("Congratulazioni, hai inserito una nuova persona con successo.");
    }

    public Person getById(long id) {

        Person found =em.find(Person.class, id);
        if(found != null) return found;
        else {
            System.out.println("Spiacenti. La persona con id " + id + " non trovato.");
            return null;
        }
    }
    public void deleteById(long id) {
        Person personFound = this.getById(id);
        if(personFound != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(personFound);
            transaction.commit();
            System.out.println("La persona con id " + id + "è stata eliminata.");
        } else {
            System.out.println("La persona con ID -" + id + "- non è presente.");
        }
    }



}

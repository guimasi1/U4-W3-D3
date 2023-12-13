package org.example.dao;

import org.example.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LocationsDAO {
    private final EntityManager em;

    public LocationsDAO(EntityManager em) {
        this.em = em;
    }

    public List<Location> findByQuery (String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();

        CriteriaQuery<Location> criteria = builder.createQuery(Location.class);
        Root<Location> root = criteria.from(Location.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("name"), name));
        List<Location> locations = em.createQuery(criteria).getResultList();
        return locations;


    }
    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(location);

        transaction.commit();

        System.out.println("Congratulazioni, hai creato la tuoa location con successo.");
    }

    public Location getById(long id) {

        Location found =em.find(Location.class, id);
        if(found != null) return found;
        else {
            System.out.println("Spiacenti. Location con id " + id + " non trovata.");
            return null;
        }
    }
    public void deleteById(long id) {
        Location eventFound = this.getById(id);
        if(eventFound != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(eventFound);
            transaction.commit();
            System.out.println("Location con id " + id + " eliminata.");
        } else {
            System.out.println("La location con ID -" + id + "- non è presente.");
        }
    }



}

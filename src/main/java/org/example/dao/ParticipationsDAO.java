package org.example.dao;

import org.example.entities.Participation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ParticipationsDAO {
    private final EntityManager em;

    public ParticipationsDAO(EntityManager em) {
        this.em = em;
    }
    public void save(Participation participation) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(participation);

        transaction.commit();

        System.out.println("Congratulazioni, hai creato la partecipazione con successo.");
    }

    public Participation getById(long id) {

        Participation found =em.find(Participation.class, id);
        if(found != null) return found;
        else {
            System.out.println("Spiacenti. Partecipazione con id " + id + " non trovata.");
            return null;
        }
    }
    public void deleteById(long id) {
        Participation participationFound = this.getById(id);
        if(participationFound != null) {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(participationFound);
            transaction.commit();
            System.out.println("Partecipazione con id " + id + " eliminata.");
        } else {
            System.out.println("La partecipazione con ID -" + id + "- non è presente.");
        }
    }



}

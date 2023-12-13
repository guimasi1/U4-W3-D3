package org.example;

import org.example.dao.EventsDAO;
import org.example.dao.LocationsDAO;
import org.example.dao.ParticipationsDAO;
import org.example.dao.PersonsDAO;
import org.example.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D3");
    public static void main(String[] args) {
        // ENTITY MANAGER E DAO
        EntityManager em = emf.createEntityManager();
        Scanner scanner = new Scanner(System.in);
        LocalDate date1 = LocalDate.parse("2024-01-01");
        LocalDate birthday1 = LocalDate.parse("1998-02-02");
        EventsDAO ed = new EventsDAO(em);
        PersonsDAO pd = new PersonsDAO(em);
        ParticipationsDAO pd2 = new ParticipationsDAO(em);
        LocationsDAO ld = new LocationsDAO(em);

        // CREAZIONE PERSONA
        Person person1 = new Person("giorgio", "nannini", "bella@bella.com",birthday1, GenderType.MALE);

        // CREAZIONE LOCATION
        Location location1 = new Location("capannelle", "Roma");

        // CREAZIONE EVENTO
        Event event1 = new Event("prova prova",date1,"descrizione", EventType.PUBLIC,10,location1);

        // CREAZIONE PARTECIPAZIONE
        Participation participation1 = new Participation(person1 , event1, StateType.TO_BE_CONFIRMED);



        // SALVATAGGIO NEL DATABASE
        // pd.save(person1);
        // pd2.save(participation1);
        // pd.deleteById(1);
        // System.out.println(pd.getById(1).getParticipationList());
        // System.out.println(pd2.getById(4));

        em.close();
        emf.close();
        scanner.close();
    }

    /*public static void eventHandler(Scanner scanner,EventsDAO ed) {
        String answer = null;
        boolean firstTimeSave = true;
        do {
            if (firstTimeSave) {
                System.out.println("Vuoi inserire un evento? Rispondi con si o no.");
                answer = scanner.nextLine();
            }
            if (answer.equals("si")) {
                String title;
                LocalDate date;
                String description;
                EventType typeOfEvent = null;
                int maxnumberOfParticipants;
                System.out.println("Qual è il nome dell'evento?");
                title = scanner.nextLine();
                System.out.println("Che giorno sarà l'evento? Inserisci il formato yyyy-mm-dd");
                date = LocalDate.parse(scanner.nextLine());
                System.out.println("Inserisci una descrizione dell'evento");
                description = scanner.nextLine();
                System.out.println("L'evento è pubblico o privato?");
                String publicOrPrivate = scanner.nextLine();
                if (publicOrPrivate.equals("privato")) typeOfEvent = EventType.PRIVATE;
                if (publicOrPrivate.equals("pubblico")) typeOfEvent = EventType.PUBLIC;
                System.out.println("Qual è il massimo di partecipanti?");
                maxnumberOfParticipants = Integer.parseInt(scanner.nextLine());
                Event newEvent = new Event(title, date, description, typeOfEvent, maxnumberOfParticipants);
                ed.save(newEvent);
                System.out.println("Vuoi aggiungere un altro evento? Rispondi si o no.");
                answer = scanner.nextLine();
                firstTimeSave = false;
            }
        } while(answer.equals("si"));
        String answerDelete = null;
        boolean firstTimeDelete = true;
        do {
            if (firstTimeDelete) {
                System.out.println("Vuoi eliminare un evento? Rispondi si o no.");
                answerDelete = scanner.nextLine();
            }
            if (answerDelete.equals("si")) {
                System.out.println("Inserisci il numero Id dell'evento da eliminare.");
                long idToDelete = Long.parseLong(scanner.nextLine());
                ed.deleteById(idToDelete);
                System.out.println("Vuoi eliminare un altro evento? Rispondi si o no.");
                answerDelete = scanner.nextLine();
                firstTimeDelete = false;
            }
        } while(answerDelete.equals("si"));
        String readEvent = null;
        boolean firstTimeGet = true;
        do {
            if(firstTimeGet) {
                System.out.println("Vuoi leggere tutte le informazioni di un evento? Rispondi si o no.");
                readEvent = scanner.nextLine();
            }
            if (readEvent.equals("si")) {
                System.out.println("Inserisci il numero id dell'evento da visualizzare");
                long idToRead = Long.parseLong(scanner.nextLine());
                System.out.println(ed.getById(idToRead));
                System.out.println("Vuoi visualizzare un altro evento? Rispondi si o no.");
                readEvent = scanner.nextLine();
                firstTimeGet = false;
            }
        } while(readEvent.equals("si"));

        System.out.println("Event handler - quit");
    }*/

}

package org.example.project;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ServizioBiblioteca {
    private final EntityManagerFactory emf;
    private final EntityManager em;

    public ServizioBiblioteca() {
        emf = Persistence.createEntityManagerFactory("persistence-unit"); // Nome dell'unità di persistenza nel persistence.xml
        em = emf.createEntityManager();
    }

    public void closeEntityManager() {
        em.close();
        emf.close();


    }

    public void aggiungiElementoCatalogo(ElementoCatalogo elemento) {
        em.getTransaction().begin();
        em.persist(elemento);
        em.getTransaction().commit();
    }

    public void rimuoviElementoCatalogo(String codiceISBN) {
        em.getTransaction().begin();
        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, codiceISBN);
        if (elemento != null) {
            em.remove(elemento);
        }
        em.getTransaction().commit();
    }

    public ElementoCatalogo ricercaPerISBN(String codiceISBN) {
        return em.find(ElementoCatalogo.class, codiceISBN);
    }

    public void ricercaPerAnnoPubblicazione(int annoPubblicazione) {

        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, annoPubblicazione);
        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento.getTitolo());
        } else {
            System.out.println("Elemento non trovato.");

        }

    }

    public void ricercaPerAutore(String autore) {
        Query query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.autore = :autore");
        query.setParameter("autore", autore);
        List<ElementoCatalogo> elementi = query.getResultList();
        if (elementi != null) {
            System.out.println("Elementi trovati: "
                    + elementi.stream().map(ElementoCatalogo::getTitolo).reduce("", (a, b) -> a + b + ", "));
        } else {
            System.out.println("Elemento non trovato.");
        }


    }

    public void ricercaPerTitoloParziale(String titolo) {
        Query query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE %" + titolo + "%");
        List<ElementoCatalogo> elementi = query.getResultList();
        if (elementi != null) {
            System.out.println("Elementi trovati: "
                    + elementi.stream().map(ElementoCatalogo::getTitolo).reduce("", (a, b) -> a + b + ", "));
        } else {
            System.out.println("Elemento non trovato.");
        }

    }

    public void ricercaPerNumeroTessera(int numeroTessera) {
        Utente utente = em.find(Utente.class, numeroTessera);
        if (utente == null) {
            System.out.println("Elemento non trovato.");
            return;

        }
        Long userId = Long.valueOf(utente.getId());

        // Query query = em.createQuery("SELECT e FROM Prestito e WHERE e.utente = :userId");
        Query query = em.createQuery("SELECT e FROM Prestito e WHERE e.utente.id = :userId AND e.dataRestituzione IS NULL");
        query.setParameter("userId", userId);
        List<Prestito> prestitiInCorso = query.getResultList();

        if (!prestitiInCorso.isEmpty()) {
            System.out.println("Libri attualmente in prestito:");
            for (Prestito prestito : prestitiInCorso) {
                System.out.println("- Titolo: " + prestito.getElementoCatalogo().getTitolo());
            }
        } else {
            System.out.println("Nessun libro attualmente in prestito per l'utente.");
        }
    }

    public void ricercaPrestitiScadutiNonRestituiti() {
        Query query = em.createQuery("SELECT e FROM Prestito e WHERE e.dataRestituzione IS NULL AND e.dataScadenza < CURRENT_DATE");
        List<Prestito> prestitiScaduti = query.getResultList();

        if (!prestitiScaduti.isEmpty()) {
            System.out.println("Libri con prestito scaduto e non ancora restituiti:");
            for (Prestito prestito : prestitiScaduti) {
                System.out.println("- Titolo: " + prestito.getElementoCatalogo().getTitolo());
            }
        } else {
            System.out.println("Nessun libro con prestito scaduto e non ancora restituito.");
        }
    }


}







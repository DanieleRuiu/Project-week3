package org.example.project;


public class Archivio {
    public static void main(String[] args) {
        ServizioBiblioteca servizio = new ServizioBiblioteca();

        // Aggiungi un elemento al catalogo
        ElementoCatalogo nuovoElemento = new ElementoCatalogo();
        nuovoElemento.setCodiceISBN("123456789");
        nuovoElemento.setTitolo("Il Libro Magico");
        nuovoElemento.setAutore("John Doe");
        nuovoElemento.setAnnoPubblicazione(2022);

        servizio.aggiungiElementoCatalogo(nuovoElemento);

        // Ricerca per ISBN
        ElementoCatalogo risultatoRicercaISBN = servizio.ricercaPerISBN("123456789");
        if (risultatoRicercaISBN != null) {
            System.out.println("Ricerca per ISBN: " + risultatoRicercaISBN.getTitolo());
        } else {
            System.out.println("Elemento non trovato.");
        }

        // Ricerca per autore
        servizio.ricercaPerAutore("John Doe");

        // Ricerca per titolo parziale
        servizio.ricercaPerTitoloParziale("Libro");

        // Ricerca per numero tessera e prestiti scaduti/non restituiti
        Utente utente = new Utente();
        utente.setId(123);
        servizio.ricercaPerNumeroTessera(utente.getId());
        servizio.ricercaPrestitiScadutiNonRestituiti();

        // Rimuovi un elemento dal catalogo
        servizio.rimuoviElementoCatalogo("123456789");


        servizio.closeEntityManager();
    }
}

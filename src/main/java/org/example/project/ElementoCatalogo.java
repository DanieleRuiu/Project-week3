package org.example.project;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ElementoCatalogo")


public class ElementoCatalogo {


@Id
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;
    private String autore;



    @ManyToMany(mappedBy = "elementiCatalogo")
    private List<Utente> utenti;


    public String getTitolo() {
        return titolo;
    }

    public void setCodiceISBN(String number) {
        this.codiceISBN = number;
    }

    public void setTitolo(String ilLibroMagico) {
        this.titolo = ilLibroMagico;
    }

    public void setAutore(String johnDoe) {
        this.autore = johnDoe;
    }

    public void setAnnoPubblicazione(int i) {
        this.annoPubblicazione = i;
    }


}






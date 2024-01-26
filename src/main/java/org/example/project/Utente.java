package org.example.project;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

   private int id;
    private String nome;
    private String cognome;
    private int dataNascita;
    private String numeroTessera;
@ManyToMany
@JoinTable(
        name = "Prestito",
        joinColumns = @JoinColumn(name = "utente_id"),
        inverseJoinColumns = @JoinColumn(name = "elemento_id"))
    private List<ElementoCatalogo>  elementiCatalogo;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getDataNascita() {
        return dataNascita;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(int dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public void setId(int id) {
        this.id = id;
    }




}


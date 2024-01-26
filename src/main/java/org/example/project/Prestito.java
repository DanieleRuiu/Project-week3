package org.example.project;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "prestito")
class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "elemento_id")
    private ElementoCatalogo elementoPrestato;

    @Temporal(TemporalType.DATE)
    private Date dataInizioPrestito;

    @Temporal(TemporalType.DATE)
    private Date dataRestituzionePrevista;

    @Temporal(TemporalType.DATE)
    private Date dataRestituzioneEffettiva;

    public ElementoCatalogo getElementoCatalogo() {
        return elementoPrestato;
    }

    public Utente getUtente() {
        return utente;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }



public Date getDataRestituzionePrevista() {
        Date dataRestituzionePrevista = new Date();
        dataRestituzionePrevista.setTime(dataInizioPrestito.getTime() + (30 * 24 * 60 * 60 * 1000));
        return dataRestituzionePrevista;
    }


    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setElementoCatalogo(ElementoCatalogo elementoCatalogo) {
        this.elementoPrestato = elementoCatalogo;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}


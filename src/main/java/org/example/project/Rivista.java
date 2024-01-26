package org.example.project;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rivista")
public class  Rivista extends ElementoCatalogo{
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }


}

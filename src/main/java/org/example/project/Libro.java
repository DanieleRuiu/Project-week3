package org.example.project;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Libro")
public class Libro extends ElementoCatalogo{
        private String autore;
        private String genere;

        public String getAutore() {
            return autore;
        }

        public String getGenere() {
            return genere;
        }

        public void setAutore(String autore) {
            this.autore = autore;
        }

        public void setGenere(String genere) {
            this.genere = genere;
        }


}

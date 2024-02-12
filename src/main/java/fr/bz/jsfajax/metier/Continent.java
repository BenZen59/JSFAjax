package fr.bz.jsfajax.metier;

import java.io.Serializable;

public class Continent implements Serializable {
    private int id;
    public String nomContinent;

    public Continent() {
    }

    public Continent(int id, String nomContinent) {
        this.id = id;
        this.nomContinent = nomContinent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomContinent() {
        return nomContinent;
    }

    public void setNomContinent(String nomContinent) {
        this.nomContinent = nomContinent;
    }

    @Override
    public String toString() {
        return nomContinent;
    }
}



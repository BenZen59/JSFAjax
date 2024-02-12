package fr.bz.jsfajax.metier;


import java.io.Serializable;


public class Pays implements Serializable {
    private int id;
    private String nomPays;
    private Continent continent;

    public Pays() {

    }

    public Pays(int id, String nomPays) {
        this.id = id;
        this.nomPays = nomPays;
        this.continent = new Continent();
    }

    public Pays(int id, String nomPays, Continent continent) {
        this.id = id;
        this.nomPays = nomPays;
        this.continent = continent;
    }

    public Pays(String nomPays) {
        this.nomPays = nomPays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return nomPays;
    }
}
package fr.bz.jsfajax.metier;

import java.io.Serializable;

public class Marque implements Serializable {
    private int id;
    public String nomMarque;
    private Pays pays;
    private Fabriquant fabriquant;
    public Marque() {

    }

    public Marque(int id, String nomMarque) {
        this.id = id;
        this.nomMarque = nomMarque;
        this.pays = new Pays();
        this.fabriquant = new Fabriquant();
    }

    public Marque(int id, String nomMarque,Pays pays, Fabriquant fabriquant) {
        this.id = id;
        this.nomMarque = nomMarque;
        this.pays = pays;
        this.fabriquant = fabriquant;
    }

    public Marque(int anInt, String string, Fabriquant fabriquant) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Fabriquant getFabriquant() {
        return fabriquant;
    }

    public void setFabriquant(Fabriquant fabriquant) {
        this.fabriquant = fabriquant;
    }

    @Override
    public String toString() {
        return nomMarque;
    }
}


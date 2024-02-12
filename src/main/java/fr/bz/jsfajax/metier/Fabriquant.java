package fr.bz.jsfajax.metier;

import java.io.Serializable;

public class Fabriquant implements Serializable {
    private int id;
    private String nomFabricant;

    public Fabriquant() {

    }

    public Fabriquant(int id, String nomFabricant) {
        this.id = id;
        this.nomFabricant = nomFabricant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomFabricant() {
        return nomFabricant;
    }

    public void setNomFabricant(String nomFabricant) {
        this.nomFabricant = nomFabricant;
    }

    @Override
    public String toString() {
        return nomFabricant;
    }
}

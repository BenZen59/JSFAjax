package fr.bz.jsfajax.metier;

public class ArticleSearch {
    private int id;
    private String nomArticle;
    private int volume;
    private float titrage;
    private Marque marque;
    private Pays pays;
    private Continent continent;
    private Fabriquant fabriquant;
    private Couleur couleur;
    private TypeBiere typeBiere;
    private int stock;

    public ArticleSearch(){
        this.marque = new Marque();
        this.fabriquant = new Fabriquant();
        this.couleur = new Couleur();
        this.typeBiere = new TypeBiere();
        this.pays = new Pays();
        this.continent = new Continent();
    }
}

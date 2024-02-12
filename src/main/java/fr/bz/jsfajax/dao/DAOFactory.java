package fr.bz.jsfajax.dao;

public class DAOFactory {
    public static CouleurDAO getCouleurDAO() {
        return new CouleurDAO();
    }

    public static TypeBiereDAO getTypeDAO() {
        return new TypeBiereDAO();
    }

    public static FabricantDAO getFabricantDAO() {
        return new FabricantDAO();
    }

    public static MarqueDAO getMarqueDAO() {
        return new MarqueDAO();
    }

    public static ContinentDAO getContinentDAO() {
        return new ContinentDAO();
    }

    public static PaysDAO getPaysDAO() {
        return new PaysDAO();
    }

    public static ArticleDAO getArticleDAO() {
        return new ArticleDAO();
    }
}
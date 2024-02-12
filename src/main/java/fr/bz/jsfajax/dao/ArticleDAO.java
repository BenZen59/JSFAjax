package fr.bz.jsfajax.dao;


import fr.bz.jsfajax.metier.*;

import java.sql.*;
import java.util.ArrayList;

import static fr.bz.jsfajax.dao.ConnectDtb.connexion;


public class ArticleDAO extends DAO<Article, ArticleSearch, Integer> {
    @Override
    public Article getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Article> getAll() {
        ArrayList<Article> liste = new ArrayList<>();
        try (PreparedStatement callableStatement = connexion.prepareCall("{call PS_QBE_Vue_Article}")) {
            ResultSet rs = callableStatement.executeQuery();
            while(rs.next()) {
                Fabriquant fabriquant = new Fabriquant(rs.getInt(8), rs.getString(9));
                Continent continent = new Continent(rs.getInt(12), rs.getString(13));
                Pays pays = new Pays(rs.getInt(10), rs.getString(11), continent);
                Marque marque = new Marque(rs.getInt(6), rs.getString(7), pays,fabriquant);
                liste.add(new Article(rs.getInt(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getFloat(5),
                        marque,
                        continent,
                        pays,
                        new Couleur(rs.getInt(14), rs.getString(15)),
                        new TypeBiere(rs.getInt(16), rs.getString(17))
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Integer> getVolume() {
        ArrayList<Integer> liste = new ArrayList<>();
        String sqlRequest = "SELECT DISTINCT VOLUME FROM ARTICLE";

        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Pays> getPaysByContinent(Continent continent) {
        ArrayList<Pays> liste = new ArrayList<>();
        String sqlRequest = "SELECT NOM_PAYS FROM PAYS P " +
                "JOIN CONTINENT C ON P.ID_CONTINENT = C.ID_CONTINENT " +
                "WHERE NOM_CONTINENT = ?";

        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
            preparedStatement.setString(1, continent.getNomContinent());

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nomPays = rs.getString("NOM_PAYS");
                Pays pays = new Pays(nomPays);
                liste.add(pays);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }


    @Override
    public ArrayList<Article> getLike(ArticleSearch object) {
        return null;
    }

    @Override
    public boolean insert(Article object) {
        return false;
    }

    @Override
    public boolean update(Article object) {
        return false;
    }

    @Override
    public boolean delete(Article object) {
        return false;
    }
}

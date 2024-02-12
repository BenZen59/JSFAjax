package fr.bz.jsfajax.dao;

import fr.bz.jsfajax.metier.Continent;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.jsfajax.dao.ConnectDtb.connexion;


public class ContinentDAO extends DAO<Continent, Continent, Integer> {
    @Override
    public Continent getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Continent> getAll() {
        ArrayList<Continent> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_CONTINENT, NOM_CONTINENT FROM CONTINENT";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new Continent(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }



    @Override
    public ArrayList<Continent> getLike(Continent object) {
        return null;
    }

    @Override
    public boolean insert(Continent object) {
        return false;
    }

    @Override
    public boolean update(Continent object) {
        return false;
    }

    @Override
    public boolean delete(Continent object) {
        return false;
    }
}

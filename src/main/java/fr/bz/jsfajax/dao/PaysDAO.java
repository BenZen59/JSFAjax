package fr.bz.jsfajax.dao;


import fr.bz.jsfajax.metier.Pays;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.jsfajax.dao.ConnectDtb.connexion;

public class PaysDAO extends DAO<Pays, Pays, Integer> {
    @Override
    public Pays getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Pays> getAll() {
        ArrayList<Pays> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_PAYS, NOM_PAYS FROM PAYS";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new Pays(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<Pays> getLike(Pays object) {
        return null;
    }

    @Override
    public boolean insert(Pays object) {
        return false;
    }

    @Override
    public boolean update(Pays object) {
        return false;
    }

    @Override
    public boolean delete(Pays object) {
        return false;
    }
}

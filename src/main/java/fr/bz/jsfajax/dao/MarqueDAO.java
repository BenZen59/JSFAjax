package fr.bz.jsfajax.dao;

import fr.bz.jsfajax.metier.Marque;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.jsfajax.dao.ConnectDtb.connexion;


public class MarqueDAO extends DAO<Marque, Marque, Integer> {

    @Override
    public Marque getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<Marque> getAll() {
        ArrayList<Marque> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_MARQUE, NOM_MARQUE from MARQUE";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new Marque(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public ArrayList<Marque> getLike(Marque object) {
        return null;
    }

    @Override
    public boolean insert(Marque object) {
        return false;
    }

    @Override
    public boolean update(Marque object) {
        return false;
    }

    @Override
    public boolean delete(Marque object) {
        return false;
    }
}

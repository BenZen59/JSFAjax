package fr.bz.jsfajax.dao;

import fr.bz.jsfajax.metier.TypeBiere;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.jsfajax.dao.ConnectDtb.connexion;

public class TypeBiereDAO extends DAO<TypeBiere, TypeBiere, Integer> {
    @Override
    public TypeBiere getByID(Integer integer) {
        return null;
    }

    @Override
    public ArrayList<TypeBiere> getAll() {
        ArrayList<TypeBiere> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_COULEUR,NOM_COULEUR from COULEUR";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new TypeBiere(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < liste.size() - 1; i++) {
            System.out.println(liste.get(i));
        }
        return liste;
    }

    @Override
    public ArrayList<TypeBiere> getLike(TypeBiere object) {
        return null;
    }

    @Override
    public boolean insert(TypeBiere object) {
        return false;
    }

    @Override
    public boolean update(TypeBiere object) {
        return false;
    }

    @Override
    public boolean delete(TypeBiere object) {
        return false;
    }
}

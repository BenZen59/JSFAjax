package fr.bz.jsfajax.dao;

import fr.bz.jsfajax.metier.Couleur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.bz.jsfajax.dao.SDBMConnect.connexion;
public class CouleurDAO extends DAO<Couleur, Couleur, Integer> {
    @Override
    public Couleur getByID(Integer id) {
        String sqlRequest = "SELECT id_couleur ,nom_couleur from couleur where id_couleur = " + id;
        Couleur couleur;
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            if (rs.next()) return new Couleur(rs.getInt(1), rs.getString(2));
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Couleur> getAll() {
        ArrayList<Couleur> liste = new ArrayList<>();
        String sqlRequest = "SELECT ID_COULEUR,NOM_COULEUR from COULEUR";
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlRequest);
            while (rs.next()) {
                liste.add(new Couleur(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    public ArrayList<Integer> getVolume() {
        return null;
    }

    @Override
    public ArrayList<Couleur> getLike(Couleur object) {
        String sqlCommand = "SELECT ID_COULEUR,NOM_COULEUR from COULEUR where ID_COULEUR like '%" + object.getNomCouleur() + "%'";
        ArrayList<Couleur> liste = new ArrayList<>();
        try (Statement statement = connexion.createStatement()) {
            ResultSet rs = statement.executeQuery(sqlCommand);
            while (rs.next()) {
                liste.add(new Couleur(rs.getInt(1), rs.getString(2)));
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }

    @Override
    public boolean insert(Couleur couleur) {
        String sqlRequest = "insert into Couleur values " + couleur.getNomCouleur();
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlRequest);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean update(Couleur couleur) {
        String sqlRequest = "update Couleur set nom_couleur = ? where id_couleur = ?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, couleur.getNomCouleur());
            preparedStatement.setInt(2, couleur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Couleur couleur) {
        String sqlRequest = "delete FROM couleur where ID_COULEUR=?";
        try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlRequest)) {
            preparedStatement.setInt(1, couleur.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

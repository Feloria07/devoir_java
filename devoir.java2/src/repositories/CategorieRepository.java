package repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Categorie;

public class CategorieRepository extends Database{

        private final  String SQL_SELECT_ALL="select * from categorie" ;
        private final  String SQL_INSERT="INSERT INTO categorie (nomCat) VALUES (?)";

    public void insertCategorie(Categorie categorie) {
        openConnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                statement.setString(1, categorie.getNomCat());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
    }

    public List<Categorie> getAllCategories() {
        List<Categorie> categories=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                  Categorie categorie=new Categorie();
                   categorie.setId(rs.getInt("id_cat"));
                   categorie.setNomCat(rs.getString("nomCat"));
                   categories.add(categorie);
             }
             rs.close();
           closeConnexion();
        }
         catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
        }
        return  categories;
       }
    
    
}

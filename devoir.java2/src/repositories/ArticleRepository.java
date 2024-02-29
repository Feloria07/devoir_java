package repositories;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Article;
import entities.Categorie;

public class ArticleRepository {

    private final  String SQL_SELECT_ALL="select * from article a, categorie c where a.id_article=c.id_article" ;
    private final  String SQL_INSERT="INSERT INTO `article` (`titre`, `contenu`, `dateCreation`,`etat`, `id_cat`) VALUES (?,?,?,?,?)";

    public void insertArticle(Article article) {
       
        openconnexion();
            try {
                initPreparedStatement(SQL_INSERT);
                Object statement;
                statement.setString(1, article.getTitre());
                statement.setString(2, article.getContenu());
                statement.setDate(3, new java.sql.Date(new Date().getTime()));
                statement.setString(4, article.getEtat());
                statement.setInt(5, article.getCategorie().getId());
                int nbreLigne=executeUpdate();
            closeConnexion();
            } catch (SQLException e) {
            e.printStackTrace();
            }
    }

     public List<Article> getAllArticles(){
            List<Article> articles=new ArrayList<>();
       try {
           openConnexion();
           initPreparedStatement(SQL_SELECT_ALL);
           ResultSet rs= executeSelect();
             while (rs.next()) {
                     Categorie categorie=new Categorie();
                     categorie.setId(rs.getInt("id_cat"));
                     categorie.setNomCat(rs.getString("nomCat"));
                     
                     Article article=new Article();
                     article.setId(rs.getInt("id_article"));
                     article.setTitre(rs.getString("titre"));
                     article.setDateCreation(rs.getDate("dateCreation"));
                     article.setEtat(rs.getString("etat"));
                     article.setCategorie(categorie);

                     articles.add(article);
             }
             rs.close();
            closeConnexion();
          }
          catch (SQLException e) {
              System.out.println("Erreur de Connexion a la BD");
         }
         return  articles;
       }

    
}

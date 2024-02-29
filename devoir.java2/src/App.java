
import java.util.List;
import java.util.Scanner;

import entities.Article;
import entities.Categorie;
import service.ArticleService;
import service.CategorieService;

public class App {
    public static void main(String[] args) throws Exception {
        int choix;
        Scanner sc=new Scanner(System.in);
        ArticleService articleService=new ArticleService();
        CategorieService categorieService=new CategorieService();

       
        do {
            System.out.println("1-Créer une Categorie");
            System.out.println("2-Lister les Catégorie"); 
            System.out.println("3-Ajouter Article et  l’ associée à une catégorie" ); 
            System.out.println("4-Lister les articles ainsi que la catégorie associée");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer le nom de la categorie");
                     String nomCat=sc.nextLine(); 
                     Categorie categorie=new Categorie();
                     categorie.setNomCat(nomCat);
                     categorieService.ajouterCategorie(categorie);
                    break;
                case 2:
                    List<Categorie> categories= categorieService.listerCategorie();
                    for (Categorie cat : categories) {
                        System.out.println("id : "+cat.getId() ); 
                        System.out.println("NomCat : "+cat.getNomCat() );     
                    }
                  
                    break; 
                    
              case 3:
                     System.out.println("Entrer le titre de article");
                     String titre=sc.nextLine(); 
                     System.out.println("Entrer le contenu de l'article");
                     String contenu=sc.nextLine();
                     System.out.println("Entrer l'etat de l'article");
                     String etat=sc.nextLine();
                     categories= categorieService.listerCategorie(); 
                        for (Categorie cat : categories) {
                            System.out.println(cat.getId()+"-"+cat.getNomCat());   
                        }
                       System.out.println("Entrer Id d'une categorie");
                       int idCat=sc.nextInt();
                       categorie=new Categorie();
                       categorie.setId(idCat);
                       Article article=new Article();
                       article.setTitre(titre);
                       article.setContenu(contenu);
                       article.setEtat(etat);
                       articleService.ajouterArticle(article);
                   break;

                   case 4:
                   List<Article> articles= articleService.listerArticle();
                   for (Article art : articles) {
                       System.out.println("id : "+art.getId() ); 
                       System.out.println("titre : "+art.getTitre() ); 
                       System.out.println("contenu : "+art.getContenu() ); 
                       System.out.println("Date Creation : "+art.getDateCreation()); 
                       System.out.println("etat : "+art.getEtat() );   
                       System.out.println("Categorie : "+art.getCategorie().getNomCat() ); 
                       System.out.println("------------------------------------");      
                   }
                 
                   break; 
                    
            }
          } while (choix!=5);
    }
    
}

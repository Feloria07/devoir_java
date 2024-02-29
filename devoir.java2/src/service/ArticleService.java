package service;

import java.util.List;

import entities.Article;
import repositories.ArticleRepository;

public class ArticleService {
    private ArticleRepository articleRepository=new ArticleRepository();

    public void ajouterArticle(Article article) {
        articleRepository.insertArticle(article);
        
    }

    public List<Article> listerArticle() {
        return   articleRepository.getAllArticles();
    }
   
}

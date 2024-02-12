package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.dao.DAOFactory;
import fr.bz.jsfajax.metier.*;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("articleBean")
@SessionScoped
public class ArticleBean implements Serializable {
    private List<Article> allArticles;
    private List<Article> filteredArticles = allArticles;

    @PostConstruct
    private void init(){
        allArticles = DAOFactory.getArticleDAO().getAll();
        if(allArticles == null){
            allArticles = new ArrayList<>(DAOFactory.getArticleDAO().getAll());
        }
    }

    public List<Article> getAllArticles(){
        return allArticles;
    }

    public void setAllArticles(List<Article> allArticles){
        this.allArticles = allArticles;
    }

    public List<Article> getArticles(){
        return allArticles;
    }

    public List<Article> getFilteredArticles() {
        return filteredArticles;
    }

    public void setFilteredArticles(List<Article> filteredArticles) {
        this.filteredArticles = filteredArticles;
    }
}



package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.metier.Article;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import java.io.Serializable;
import java.util.List;

@Named("deLazyView")
@ViewScoped
public class LazyView implements Serializable {
    private LazyDataModel<Article> lazyDataModel;
    private List<Article> filteredArticles;

    @Inject
    private ArticleBean articleBean;

    @PostConstruct
    public void init(){
        lazyDataModel = new LazyArticleDataModel(articleBean.getArticles(200));
    }

    public LazyDataModel<Article> getLazyDataModel() {
        return lazyDataModel;
    }

    public void setLazyDataModel(LazyDataModel<Article> lazyDataModel) {
        this.lazyDataModel = lazyDataModel;
    }

    public List<Article> getFilteredArticles() {
        return filteredArticles;
    }

    public void setFilteredArticles(List<Article> filteredArticles) {
        this.filteredArticles = filteredArticles;
    }

    public ArticleBean getArticleBean() {
        return articleBean;
    }

    public void setArticleBean(ArticleBean articleBean) {
        this.articleBean = articleBean;
    }

    public void onRowSelect(SelectEvent<Article> event) {
        FacesMessage msg = new FacesMessage("Customer Selected", String.valueOf(event.getObject().getId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}

package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.metier.Article;
import org.primefaces.model.SortOrder;

import java.util.Comparator;

public class LazySorter implements Comparator<Article> {

    private String sortField;
    private SortOrder sortOrder;

    public LazySorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(Article article1, Article article2) {
        try {
            Object ShowcaseUtil = null;
            Object value1 = ShowcaseUtil.getClass();
            Object value2 = ShowcaseUtil.getClass();

            int value = ((Comparable) value1).compareTo(value2);

            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
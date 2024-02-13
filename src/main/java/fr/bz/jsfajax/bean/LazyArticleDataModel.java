package fr.bz.jsfajax.bean;

import fr.bz.jsfajax.metier.Article;
import jakarta.faces.context.FacesContext;
import org.apache.commons.collections4.ComparatorUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.filter.FilterConstraint;
import org.primefaces.util.LocaleUtils;

import java.beans.IntrospectionException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LazyArticleDataModel extends LazyDataModel<Article> {
    private static final long serialVersionUID = 1L;
    private List<Article> datasource;

    LazyArticleDataModel(List<Article> datasource) {
        this.datasource = datasource;
    }

    @Override
    public Article getRowData(String rowKey) {
        for (Article article : datasource) {
            if (article.getId() == Integer.parseInt(rowKey)) {
                return article;
            }
        }
        return null;
    }

    @Override
    public String getRowKey(Article article) {
        return String.valueOf(article.getId());
    }

    @Override
    public int count(Map<String, FilterMeta> filterBy) {
        return (int) datasource.stream()
                .filter(o -> {
                    try {
                        return filter(FacesContext.getCurrentInstance(), filterBy.values(), o);
                    } catch (ReflectiveOperationException e) {
                        throw new RuntimeException(e);
                    } catch (IntrospectionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .count();
    }

    @Override
    public List<Article> load(int offset, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
        // apply offset & filters
        List<Article> customers = datasource.stream()
                .skip(offset)
                .filter(o -> {
                    try {
                        return filter(FacesContext.getCurrentInstance(), filterBy.values(), o);
                    } catch (ReflectiveOperationException | IntrospectionException e) {
                        throw new RuntimeException(e);
                    }
                })
                .limit(pageSize)
                .collect(Collectors.toList());

        // sort
        if (!sortBy.isEmpty()) {
            List<Comparator<Article>> comparators = sortBy.values().stream()
                    .map(o -> new LazySorter(o.getField(), o.getOrder()))
                    .collect(Collectors.toList());
            Comparator<Article> cp = ComparatorUtils.chainedComparator(comparators); // from apache
            customers.sort(cp);
        }

        return customers;
    }

    private boolean filter(FacesContext context, Collection<FilterMeta> filterBy, Object o) throws ReflectiveOperationException, IntrospectionException {
        boolean matching = true;

        for (FilterMeta filter : filterBy) {
            FilterConstraint constraint = filter.getConstraint();
            Object filterValue = filter.getFilterValue();

            Object ShowcaseUtil = null;
            Object columnValue = String.valueOf(ShowcaseUtil.getClass());
            matching = constraint.isMatching(context, columnValue, filterValue, LocaleUtils.getCurrentLocale());

            if (!matching) {
                break;
            }
        }

        return matching;
    }


}

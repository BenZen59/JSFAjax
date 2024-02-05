package fr.bz.jsfajax.converter;

import fr.bz.jsfajax.bean.CouleurBean;
import fr.bz.jsfajax.metier.Couleur;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;

@FacesConverter(value = "couleurConverter", managed = true)
public class CouleurConverter implements Converter {
    @Inject
    private CouleurBean couleurBean;

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            for (Couleur couleur : couleurBean.getCouleurs()) {
                if (couleur.getIdCouleur() == Integer.parseInt(value)) {
                    return couleur;
                }
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object object) {
        Couleur couleur = (Couleur) object;
        return String.valueOf(couleur.getIdCouleur());
    }
}

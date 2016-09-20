package org.oc2.qmis.view.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.oc2.qmis.model.entity.WorkSystem;
import org.oc2.qmis.view.managedbean.WorkSystemManagedBean;

@FacesConverter("workSystemConverter")
public class WorkSystemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        if(arg2 != null && arg2.trim().length() > 0) {
            try {
            	System.out.println("WorkSystemId:"+arg2);
            	WorkSystemManagedBean workSystemManagedBean = (WorkSystemManagedBean) arg0.getExternalContext().getSessionMap().get("workSystemManagedBean");
            	WorkSystem workSystem = workSystemManagedBean.getWorkSystemList().get(Integer.parseInt(arg2)-1);
            	System.out.println(workSystem.getName());
            	return workSystem;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid TasbBase object."));
            }
        }
        else {
            return null;
        }
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
        if(arg2 != null) {
            return String.valueOf(((WorkSystem) arg2).getId());
        }
        else {
            return null;
        }
	}

}

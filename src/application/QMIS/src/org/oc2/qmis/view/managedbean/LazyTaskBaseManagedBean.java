package org.oc2.qmis.view.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskBase;
import org.oc2.qmis.model.service.TaskBaseLazyDataModel;
import org.oc2.qmis.model.service.TaskBaseService;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "lazyTaskListManagedBean")
@SessionScoped
public class LazyTaskBaseManagedBean {

	@ManagedProperty(value = "#{taskBaseLazyDataModel}")
	private TaskBaseLazyDataModel taskBaseLazyDataModel;
	
	@ManagedProperty(value = "#{taskBaseService}")
	private TaskBaseService service;
	
	private TaskBase selected;

	public TaskBaseLazyDataModel getTaskBaseLazyDataModel() {
		return taskBaseLazyDataModel;
	}

	public void setTaskBaseLazyDataModel(TaskBaseLazyDataModel taskBaseLazyDataModel) {
		this.taskBaseLazyDataModel = taskBaseLazyDataModel;
	}

	public TaskBase getSelected() {
		return selected;
	}

	public void setSelected(TaskBase selected) {
		this.selected = selected;
	}
	
    public TaskBaseService getService() {
		return service;
	}

	public void setService(TaskBaseService service) {
		this.service = service;
	}

	public void select() {
        System.out.println("selected: " + selected);
    }

    public void delete() {
        service.getTaskBasePagingAndSortingRepositotory().delete(selected);
    }

    public void update() {
        service.getTaskBasePagingAndSortingRepositotory().save(selected);
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Task Selected", ((TaskBase) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage("Select", msg);
    }
	
}

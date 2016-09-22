package org.oc2.qmis.view.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskPhaseControl;
import org.oc2.qmis.model.service.TaskPhaseControlLazyDataModel;
//import org.oc2.qmis.model.service.TaskPhaseControlService;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "lazyTaskPhaseControlManagedBean")
@SessionScoped
public class LazyTaskPhaseControlManagedBean implements Serializable {

	private static final long serialVersionUID = 8321952892120434088L;

	@ManagedProperty(value = "#{taskPhaseControlLazyDataModel}")
	private TaskPhaseControlLazyDataModel taskPhaseControlLazyDataModel;
	
//	@ManagedProperty(value = "#{taskPhaseControlService}")
//	private TaskPhaseControlService service;
	
	/**
	 * 
	 */
	
	private TaskPhaseControl selected;
	
	private TaskPhaseControl taskPhaseControl = new TaskPhaseControl();

	public TaskPhaseControl getTaskPhaseControl() {
		return taskPhaseControl;
	}

	public void setTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		this.taskPhaseControl = taskPhaseControl;
	}

	public TaskPhaseControlLazyDataModel getTaskPhaseControlLazyDataModel() {
		return taskPhaseControlLazyDataModel;
	}

	public void setTaskPhaseControlLazyDataModel(TaskPhaseControlLazyDataModel taskPhaseControlLazyDataModel) {
		this.taskPhaseControlLazyDataModel = taskPhaseControlLazyDataModel;
	}

	public TaskPhaseControl getSelected() {
		return selected;
	}

	public void setSelected(TaskPhaseControl selected) {
		this.selected = selected;
	}
	
//	public TaskPhaseControlService getService() {
//		return service;
//	}

//	public void setService(TaskPhaseControlService service) {
//		this.service = service;
//	}

	public void select() {
        System.out.println("selected: " + selected);
    }

    public void delete() {
//        service.getTaskPhaseControlPagingAndSortingRepository().delete(selected);
    	taskPhaseControlLazyDataModel.getTaskPhaseControlPagingAndSortingRepository().delete(selected);
    }

    public void update() {
//        service.getTaskPhaseControlPagingAndSortingRepository().save(selected);
    	taskPhaseControlLazyDataModel.getTaskPhaseControlPagingAndSortingRepository().save(selected);
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Task Phase Control Selected", String.valueOf(((TaskPhaseControl) event.getObject()).getId()));
        FacesContext.getCurrentInstance().addMessage("Select", msg);
    }
    
    public String createTaskPhaseControl() {
    	System.out.println("Save new task phase control entry:");
    	System.out.println(this.taskPhaseControl.getWorkSystem().getName());
    	System.out.println(this.taskPhaseControl.getTaskBase().getName());
    	System.out.println(this.taskPhaseControl.getTaskPhase().getName());
//        this.service.getTaskPhaseControlPagingAndSortingRepository().save(this.taskPhaseControl);
        this.taskPhaseControlLazyDataModel.getTaskPhaseControlPagingAndSortingRepository().save(this.taskPhaseControl);
        this.taskPhaseControl = new TaskPhaseControl();
        addMessage("Created new task phase control.", "Created new task phase control.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}

package org.oc2.qmis.view.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskPhaseControl;
import org.oc2.qmis.model.service.DynamicTaskPhaseControlLazyDataModel;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "dynamicLazyTaskPhaseControlManagedBean")
@SessionScoped
public class DynamicLazyTaskPhaseControlManagedBean implements Serializable {

	private static final long serialVersionUID = 8321952892120434088L;

	@ManagedProperty(value = "#{dynamicTaskPhaseControlLazyDataModel}")
	private DynamicTaskPhaseControlLazyDataModel dynamicTaskPhaseControlLazyDataModel;
	
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

	public DynamicTaskPhaseControlLazyDataModel getDynamicTaskPhaseControlLazyDataModel() {
		return dynamicTaskPhaseControlLazyDataModel;
	}

	public void setDynamicTaskPhaseControlLazyDataModel(DynamicTaskPhaseControlLazyDataModel dynamicTaskPhaseControlLazyDataModel) {
		this.dynamicTaskPhaseControlLazyDataModel = dynamicTaskPhaseControlLazyDataModel;
	}

	public TaskPhaseControl getSelected() {
		return selected;
	}

	public void setSelected(TaskPhaseControl selected) {
		this.selected = selected;
	}

	public void select() {
        System.out.println("selected: " + selected);
    }

    public void delete() {
    	dynamicTaskPhaseControlLazyDataModel.getTaskPhaseControlPagingAndSortingRepository().delete(selected);
    }

    public void update() {
    	dynamicTaskPhaseControlLazyDataModel.getTaskPhaseControlPagingAndSortingRepository().save(selected);
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
        this.dynamicTaskPhaseControlLazyDataModel.getTaskPhaseControlPagingAndSortingRepository().save(this.taskPhaseControl);
        this.taskPhaseControl = new TaskPhaseControl();
        addMessage("Created new task phase control.", "Created new task phase control.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}

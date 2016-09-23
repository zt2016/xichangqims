package org.oc2.qmis.view.managedbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskBase;
import org.oc2.qmis.model.service.TaskBaseLazyDataModel;
//import org.oc2.qmis.model.service.TaskBaseService;
import org.primefaces.event.SelectEvent;

@ManagedBean(name = "lazyTaskBaseManagedBean")
@SessionScoped
public class LazyTaskBaseManagedBean implements Serializable {

	private static final long serialVersionUID = 3426852318387950166L;

	@ManagedProperty(value = "#{taskBaseLazyDataModel}")
	private TaskBaseLazyDataModel taskBaseLazyDataModel;
	
	@ManagedProperty(value = "#{dynamicLazyTaskPhaseControlManagedBean}")
	private DynamicLazyTaskPhaseControlManagedBean dynamicLazyTaskPhaseControlManagedBean;
	
	public DynamicLazyTaskPhaseControlManagedBean getDynamicLazyTaskPhaseControlManagedBean() {
		return dynamicLazyTaskPhaseControlManagedBean;
	}

	public void setDynamicLazyTaskPhaseControlManagedBean(
			DynamicLazyTaskPhaseControlManagedBean dynamicLazyTaskPhaseControlManagedBean) {
		this.dynamicLazyTaskPhaseControlManagedBean = dynamicLazyTaskPhaseControlManagedBean;
	}
	
	private TaskBase selected;
	
	private TaskBase taskBase = new TaskBase();

	public TaskBase getTaskBase() {
		return taskBase;
	}

	public void setTaskBase(TaskBase taskBase) {
		this.taskBase = taskBase;
	}

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
	
	public void select() {
        System.out.println("selected: " + selected);
    }

    public void delete() {
    	taskBaseLazyDataModel.getTaskBasePagingAndSortingRepositotory().delete(selected);
    }

    public void update() {
        taskBaseLazyDataModel.getTaskBasePagingAndSortingRepositotory().save(selected);
    }
    
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Task Selected", ((TaskBase) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage("Select", msg);
        this.dynamicLazyTaskPhaseControlManagedBean.getDynamicTaskPhaseControlLazyDataModel().setOwner(selected);
    }
    
    public String createTask() {
    	this.taskBaseLazyDataModel.getTaskBasePagingAndSortingRepositotory().save(this.taskBase);
        this.taskBase = new TaskBase();
        addMessage("Created new task.", "Created new task.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}

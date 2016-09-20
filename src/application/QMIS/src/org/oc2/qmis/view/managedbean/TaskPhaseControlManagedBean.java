package org.oc2.qmis.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskPhaseControl;
import org.oc2.qmis.model.service.TaskPhaseControlService;

import com.google.common.collect.Lists;

@ManagedBean(name = "taskPhaseControlManagedBean")
@SessionScoped
public class TaskPhaseControlManagedBean {
	
	private TaskPhaseControl taskPhaseControl = new TaskPhaseControl();

	private List<TaskPhaseControl> taskPhaseControlList = new ArrayList<TaskPhaseControl>();
	
    @ManagedProperty(value = "#{taskPhaseControlService}")
    private TaskPhaseControlService service;
    
    @PostConstruct
    public void init() {
    	this.taskPhaseControlList = Lists.newArrayList(service.getTaskPhaseControlPagingAndSortingRepository().findAll());
    }
    
	public List<TaskPhaseControl> getTaskPhaseControlList() {
		return taskPhaseControlList;
	}

	public void setTaskPhaseControlList(List<TaskPhaseControl> taskPhaseControlList) {
		this.taskPhaseControlList = taskPhaseControlList;
	}

	public TaskPhaseControlService getService() {
		return service;
	}

	public void setService(TaskPhaseControlService service) {
		this.service = service;
	}

	public TaskPhaseControl getTaskPhaseControl() {
		return taskPhaseControl;
	}

	public void setTaskPhaseControl(TaskPhaseControl taskPhaseControl) {
		this.taskPhaseControl = taskPhaseControl;
	}
    
    public String createTaskPhaseControl() {
        this.service.getTaskPhaseControlPagingAndSortingRepository().save(this.taskPhaseControl);
        this.taskPhaseControl = new TaskPhaseControl();
        addMessage("Created new task phase control.", "Created new task phase control.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}

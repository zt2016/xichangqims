package org.oc2.qmis.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskPhase;
import org.oc2.qmis.model.service.TaskPhaseService;

import com.google.common.collect.Lists;

@ManagedBean(name = "taskPhaseManagedBean")
@SessionScoped
public class TaskPhaseManagedBean {

	private List<TaskPhase> taskPhaseList = new ArrayList<TaskPhase>();
	
	private TaskPhase taskPhase = new TaskPhase();
	
	@ManagedProperty(value = "#{taskPhaseService}")
	private TaskPhaseService service;

	public List<TaskPhase> getTaskPhaseList() {
		this.taskPhaseList = Lists.newArrayList(this.service.getTaskPhaseRepository().findAll());
		return taskPhaseList;
	}

	public void setTaskPhaseList(List<TaskPhase> taskPhaseList) {
		this.taskPhaseList = taskPhaseList;
	}

	public TaskPhase getTaskPhase() {
		return taskPhase;
	}

	public void setTaskPhase(TaskPhase taskPhase) {
		this.taskPhase = taskPhase;
	}

	public TaskPhaseService getService() {
		return service;
	}

	public void setService(TaskPhaseService service) {
		this.service = service;
	}
	
    public String createTaskPhase() {
        this.service.getTaskPhaseRepository().save(this.taskPhase);
        this.taskPhase = new TaskPhase();
        addMessage("Created new task phase.", "Created new task phase.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}

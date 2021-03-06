package org.oc2.qmis.view.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskBase;
import org.oc2.qmis.model.service.TaskBaseService;

import com.google.common.collect.Lists;

@ManagedBean(name = "taskBaseManagedBean")
@SessionScoped
public class TaskBaseManagedBean implements Serializable {

	private static final long serialVersionUID = -9194982171340894348L;

	private TaskBase taskBase = new TaskBase();

	private List<TaskBase> taskList = new ArrayList<TaskBase>();
	
    @ManagedProperty(value = "#{taskBaseService}")
    private TaskBaseService service;
    
    @PostConstruct
    public void init() {
    	this.taskList = Lists.newArrayList(service.getTaskBasePagingAndSortingRepositotory().findAll());
    }
    
	public List<TaskBase> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskBase> taskList) {
		this.taskList = taskList;
	}

	public TaskBaseService getService() {
		return service;
	}

	public void setService(TaskBaseService service) {
		this.service = service;
	}

	public TaskBase getTaskBase() {
		return taskBase;
	}

	public void setTaskBase(TaskBase taskBase) {
		this.taskBase = taskBase;
	}
    
    public String createTask() {
        this.service.getTaskBasePagingAndSortingRepositotory().save(this.taskBase);
        this.taskBase = new TaskBase();
        addMessage("Created new task.", "Created new task.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
}

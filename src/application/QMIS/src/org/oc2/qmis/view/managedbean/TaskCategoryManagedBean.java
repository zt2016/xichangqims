package org.oc2.qmis.view.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.oc2.qmis.model.entity.TaskCategory;
import org.oc2.qmis.model.service.TaskCategoryService;

import com.google.common.collect.Lists;

@ManagedBean(name = "taskCategoryManagedBean")
@SessionScoped
public class TaskCategoryManagedBean {
	
	private List<TaskCategory> taskCategoryList = new ArrayList<TaskCategory>();
	
	private TaskCategory taskCategory = new TaskCategory();
	
	@ManagedProperty(value = "#{taskCategoryService}")
	private TaskCategoryService service;

	public List<TaskCategory> getTaskCategoryList() {
		this.taskCategoryList = Lists.newArrayList(this.service.getTaskCategoryRepository().findAll());
		return taskCategoryList;
	}

	public void setTaskCategoryList(List<TaskCategory> taskCategoryList) {
		this.taskCategoryList = taskCategoryList;
	}

	public TaskCategory getTaskCategory() {
		return taskCategory;
	}

	public void setTaskCategory(TaskCategory taskCategory) {
		this.taskCategory = taskCategory;
	}

	public TaskCategoryService getService() {
		return service;
	}

	public void setService(TaskCategoryService service) {
		this.service = service;
	}
	
    public String createTaskCategory() {
        this.service.getTaskCategoryRepository().save(this.taskCategory);
        this.taskCategory = new TaskCategory();
        addMessage("Created new task category.", "Created new task category.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}

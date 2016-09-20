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

import org.oc2.qmis.model.entity.WorkSystem;
import org.oc2.qmis.model.service.WorkSystemService;

import com.google.common.collect.Lists;

@ManagedBean(name = "workSystemManagedBean")
@SessionScoped
public class WorkSystemManagedBean implements Serializable {

	private static final long serialVersionUID = -3090447989509153557L;

	private List<WorkSystem> workSystemList = new ArrayList<WorkSystem>();
	
	private WorkSystem workSystem = new WorkSystem();
	
	@ManagedProperty(value = "#{workSystemService}")
	private WorkSystemService service;
	
    @PostConstruct
    public void init() {
    	this.workSystemList = Lists.newArrayList(this.service.getWorkSystemRepository().findAll());
    }

	public List<WorkSystem> getWorkSystemList() {
		return workSystemList;
	}

	public void setWorkSystemList(List<WorkSystem> workSystemList) {
		this.workSystemList = workSystemList;
	}

	public WorkSystem getWorkSystem() {
		return workSystem;
	}

	public void setWorkSystem(WorkSystem workSystem) {
		this.workSystem = workSystem;
	}

	public WorkSystemService getService() {
		return service;
	}

	public void setService(WorkSystemService service) {
		this.service = service;
	}
	
    public String createWorkSystem() {
        this.service.getWorkSystemRepository().save(this.workSystem);
        this.workSystem = new WorkSystem();
        addMessage("Created new work system.", "Created new work system.");
        return "";
    }
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}

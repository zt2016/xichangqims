package org.oc2.qmis.view.control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.oc2.qmis.model.entity.TaskBase;
import org.oc2.qmis.model.service.TaskBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@ManagedBean(name = "taskBaseManagedBean")
@SessionScoped
public class TaskBaseManagedBean {
	
	private TaskBase taskBase = new TaskBase();

	private List<TaskBase> taskList = new ArrayList<TaskBase>();
	
    @ManagedProperty(value = "#{taskBaseService}")
    private TaskBaseService service;
    
    private Page<TaskBase> page;
    
    @PostConstruct
    public void postInit() {
        Sort sort = new Sort(Direction.ASC, "name");
        page = service.getTaskBasePagingAndSortingRepositotory().findAll(new PageRequest(0, 5, sort));
        this.taskList = page.getContent();
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

	public Page<TaskBase> getPage() {
		return page;
	}

	public void setPage(Page<TaskBase> page) {
		this.page = page;
	}

	public TaskBase getTaskBase() {
		return taskBase;
	}

	public void setTaskBase(TaskBase taskBase) {
		this.taskBase = taskBase;
	}
    
    public String nextPage() {
        if (page.hasNext()) {
            this.page = this.service.getTaskBasePagingAndSortingRepositotory().findAll(page.nextPageable());
            this.taskList = page.getContent();
        }
        return "";
    }

    public String previousPage() {
        if (page.hasPrevious()) {
            this.page = this.service.getTaskBasePagingAndSortingRepositotory().findAll(page.previousPageable());
            this.taskList = page.getContent();
        }
        return "";
    }
    
    public String sortByTaskName() {
        if (page != null) {
            if (page.getSort() != null) {
                Sort sort = new Sort(Direction.ASC, "name");
                this.page =
                        this.service.getTaskBasePagingAndSortingRepositotory().findAll(
                                new PageRequest(this.page.getNumber(), this.page.getSize(), sort));
                this.taskList = this.page.getContent();
            }
        }
        return "";
    }
    
    public String createTask() {
        this.service.getTaskBasePagingAndSortingRepositotory().save(this.taskBase);
        this.taskBase = new TaskBase();
        return "";
    }
	
}

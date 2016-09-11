package org.oc2.qmis.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.oc2.qmis.model.dao.TaskBasePagingAndSortingRepository;
import org.oc2.qmis.model.entity.TaskBase;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("taskBaseService")
public class TaskBaseService extends LazyDataModel<TaskBase>{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 103349750896145942L;

	public TaskBaseService() {
        super();
    }
	
	@Autowired
	private TaskBasePagingAndSortingRepository taskBasePagingAndSortingRepositotory;

	public TaskBasePagingAndSortingRepository getTaskBasePagingAndSortingRepositotory() {
		return taskBasePagingAndSortingRepositotory;
	}

	public void setTaskBasePagingAndSortingRepositotory(
			TaskBasePagingAndSortingRepository taskBasePagingAndSortingRepositotory) {
		this.taskBasePagingAndSortingRepositotory = taskBasePagingAndSortingRepositotory;
	}
	
	private List<TaskBase> taskList = new ArrayList<TaskBase>();

	public List<TaskBase> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TaskBase> taskList) {
		this.taskList = taskList;
	}
	
    @Override
    public Object getRowKey(TaskBase taskBase) {
        return taskBase.getId();
    }
    
    @Override
    public TaskBase getRowData(String taskBaseId) {
        for (TaskBase taskBase : taskList) {
            if (String.valueOf(taskBase.getId()).equals(taskBaseId)) {
                return taskBase;
            }
        }
        return null;
    }
    
    @Override
    public List<TaskBase> load(int first, int pageSize, String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {
        Page<TaskBase> page = taskBasePagingAndSortingRepositotory.findAll(new PageRequest(first / pageSize, pageSize, Sort.Direction.ASC, sortField));
        this.taskList = page.getContent();
        setRowCount((int) taskBasePagingAndSortingRepositotory.count());
        return taskList;
    }
		
}

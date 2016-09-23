package org.oc2.qmis.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.oc2.qmis.model.dao.TaskPhaseControlPagingAndSortingRepository;
import org.oc2.qmis.model.entity.TaskBase;
import org.oc2.qmis.model.entity.TaskPhaseControl;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("dynamicTaskPhaseControlLazyDataModel")
public class DynamicTaskPhaseControlLazyDataModel extends LazyDataModel<TaskPhaseControl> {
	
	private static final long serialVersionUID = 4500435811197597041L;
	
	private TaskBase owner;
	
	public TaskBase getOwner() {
		return owner;
	}

	public void setOwner(TaskBase owner) {
		this.owner = owner;
	}
	
	@Autowired
	private TaskPhaseControlPagingAndSortingRepository taskPhaseControlPagingAndSortingRepository;

	public TaskPhaseControlPagingAndSortingRepository getTaskPhaseControlPagingAndSortingRepository() {
		return taskPhaseControlPagingAndSortingRepository;
	}

	public void setTaskPhaseControlPagingAndSortingRepository(
			TaskPhaseControlPagingAndSortingRepository taskPhaseControlPagingAndSortingRepository) {
		this.taskPhaseControlPagingAndSortingRepository = taskPhaseControlPagingAndSortingRepository;
	}
	
	public DynamicTaskPhaseControlLazyDataModel(){
		super();
	}
	
	private List<TaskPhaseControl> taskPhaseControlList = new ArrayList<TaskPhaseControl>();

    @Override
    public List<TaskPhaseControl> load(int first, int pageSize, String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {
        Page<TaskPhaseControl> page =
        		taskPhaseControlPagingAndSortingRepository.findByTaskBase(owner, new PageRequest(first / pageSize, pageSize, Sort.Direction.ASC, sortField));
        this.taskPhaseControlList = page.getContent();
        setRowCount((int) taskPhaseControlPagingAndSortingRepository.count());
        return taskPhaseControlList;
    }

    @Override
    public Object getRowKey(TaskPhaseControl taskPhaseControl) {
        return taskPhaseControl.getId();
    }

    @Override
    public TaskPhaseControl getRowData(String taskId) {
        for (TaskPhaseControl taskPhaseControl : taskPhaseControlList) {
            if (String.valueOf(taskPhaseControl.getId()).equals(taskId)) {
                return taskPhaseControl;
            }
        }
        return null;
    }
	
	public List<TaskPhaseControl> getTaskPhaseControlList() {
		return taskPhaseControlList;
	}

	public void setTaskPhaseControlList(List<TaskPhaseControl> taskPhaseControlList) {
		this.taskPhaseControlList = taskPhaseControlList;
	}
	
}

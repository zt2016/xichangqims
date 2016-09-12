package org.oc2.qmis.model.service;

import org.oc2.qmis.model.dao.TaskBasePagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskBaseService")
public class TaskBaseService {
	
	@Autowired
	private TaskBasePagingAndSortingRepository taskBasePagingAndSortingRepositotory;

	public TaskBasePagingAndSortingRepository getTaskBasePagingAndSortingRepositotory() {
		return taskBasePagingAndSortingRepositotory;
	}

	public void setTaskBasePagingAndSortingRepositotory(
			TaskBasePagingAndSortingRepository taskBasePagingAndSortingRepositotory) {
		this.taskBasePagingAndSortingRepositotory = taskBasePagingAndSortingRepositotory;
	}
		
}

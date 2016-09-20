package org.oc2.qmis.model.service;

import org.oc2.qmis.model.dao.TaskPhaseControlPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskPhaseControlService")
public class TaskPhaseControlService {

	@Autowired
	private TaskPhaseControlPagingAndSortingRepository taskPhaseControlPagingAndSortingRepository;

	public TaskPhaseControlPagingAndSortingRepository getTaskPhaseControlPagingAndSortingRepository() {
		return taskPhaseControlPagingAndSortingRepository;
	}

	public void setTaskPhaseControlPagingAndSortingRepository(
			TaskPhaseControlPagingAndSortingRepository taskPhaseControlPagingAndSortingRepository) {
		this.taskPhaseControlPagingAndSortingRepository = taskPhaseControlPagingAndSortingRepository;
	}
	
}

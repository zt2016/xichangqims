package org.oc2.qmis.model.service;

import org.oc2.qmis.model.dao.TaskPhaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskPhaseService")
public class TaskPhaseService {
	
	@Autowired
	private TaskPhaseRepository taskPhaseRepository;

	public TaskPhaseRepository getTaskPhaseRepository() {
		return taskPhaseRepository;
	}

	public void setTaskPhaseRepository(TaskPhaseRepository taskPhaseRepository) {
		this.taskPhaseRepository = taskPhaseRepository;
	}

}

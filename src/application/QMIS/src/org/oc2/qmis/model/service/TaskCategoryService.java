package org.oc2.qmis.model.service;

import org.oc2.qmis.model.dao.TaskCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskCategoryService")
public class TaskCategoryService {
	
	@Autowired
	private TaskCategoryRepository taskCategoryRepository;

	public TaskCategoryRepository getTaskCategoryRepository() {
		return taskCategoryRepository;
	}

	public void setTaskCategoryRepository(TaskCategoryRepository taskCategoryRepository) {
		this.taskCategoryRepository = taskCategoryRepository;
	}

}

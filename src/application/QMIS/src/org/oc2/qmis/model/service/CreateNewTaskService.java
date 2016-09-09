package org.oc2.qmis.model.service;

import org.oc2.qmis.model.entity.TaskBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateNewTaskService {

	@Autowired
	private TaskBase taskBase;
	
	public TaskBase getTaskBase(){
		return taskBase;
	}
	
	public void setTaskBase(TaskBase taskBase){
		this.taskBase=taskBase;
	}
	
}

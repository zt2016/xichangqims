package org.oc2.qmis.model.service;

import org.oc2.qmis.model.dao.WorkSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("workSystemService")
public class WorkSystemService {

	@Autowired
	private WorkSystemRepository workSystemRepository;

	public WorkSystemRepository getWorkSystemRepository() {
		return workSystemRepository;
	}

	public void setWorkSystemRepository(WorkSystemRepository workSystemRepository) {
		this.workSystemRepository = workSystemRepository;
	}
	
}

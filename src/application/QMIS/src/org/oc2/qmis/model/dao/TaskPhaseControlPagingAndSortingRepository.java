package org.oc2.qmis.model.dao;

import java.util.List;

import org.oc2.qmis.model.entity.TaskBase;
import org.oc2.qmis.model.entity.TaskPhaseControl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPhaseControlPagingAndSortingRepository extends PagingAndSortingRepository<TaskPhaseControl, Integer> {
	public List<TaskPhaseControl> findByTaskBase(TaskBase taskBase);
	public Iterable<TaskPhaseControl> findByTaskBase(TaskBase taskBase,Sort sort);
	public Page<TaskPhaseControl> findByTaskBase(TaskBase taskBase,Pageable pageable);
}

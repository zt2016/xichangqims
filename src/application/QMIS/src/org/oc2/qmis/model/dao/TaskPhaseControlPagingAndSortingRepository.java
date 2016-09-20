package org.oc2.qmis.model.dao;

import org.oc2.qmis.model.entity.TaskPhaseControl;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPhaseControlPagingAndSortingRepository extends PagingAndSortingRepository<TaskPhaseControl, Integer> {

}

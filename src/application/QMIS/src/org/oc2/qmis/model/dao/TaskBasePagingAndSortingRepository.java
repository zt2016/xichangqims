package org.oc2.qmis.model.dao;

import org.oc2.qmis.model.entity.TaskBase;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskBasePagingAndSortingRepository extends PagingAndSortingRepository<TaskBase, Integer> {

}

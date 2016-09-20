package org.oc2.qmis.model.dao;

import org.oc2.qmis.model.entity.TaskBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskBaseRepository extends CrudRepository<TaskBase, Integer> {

}

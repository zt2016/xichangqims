package org.oc2.qmis.model.dao;

import org.oc2.qmis.model.entity.TaskCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskCategoryRepository extends CrudRepository<TaskCategory, Integer> {

}

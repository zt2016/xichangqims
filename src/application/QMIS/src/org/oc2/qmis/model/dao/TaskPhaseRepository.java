package org.oc2.qmis.model.dao;

import org.oc2.qmis.model.entity.TaskPhase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskPhaseRepository extends CrudRepository<TaskPhase, Integer> {

}

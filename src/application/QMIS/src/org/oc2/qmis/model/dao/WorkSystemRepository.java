package org.oc2.qmis.model.dao;

import org.oc2.qmis.model.entity.WorkSystem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkSystemRepository extends CrudRepository<WorkSystem, Integer> {

}

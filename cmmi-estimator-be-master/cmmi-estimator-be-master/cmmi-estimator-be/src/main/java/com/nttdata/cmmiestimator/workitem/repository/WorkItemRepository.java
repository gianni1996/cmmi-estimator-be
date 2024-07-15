package com.nttdata.cmmiestimator.workitem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.workitem.model.WorkItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */

@Repository
public interface WorkItemRepository extends CrudRepository<WorkItemEntity, Integer> {
	
	List<WorkItemEntity> findAll();

	WorkItemEntity findByNome(String nome);

	WorkItemEntity save(WorkItemEntity cmp);
	
	void delete(WorkItemEntity cmp);

}

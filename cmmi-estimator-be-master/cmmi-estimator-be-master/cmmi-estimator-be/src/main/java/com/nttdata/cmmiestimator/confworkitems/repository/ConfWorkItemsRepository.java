package com.nttdata.cmmiestimator.confworkitems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.confworkitems.model.ConfWorkItemsEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ConfWorkItemsRepository extends CrudRepository<ConfWorkItemsEntity, Integer> {
	
	List<ConfWorkItemsEntity> findAll();

	List<ConfWorkItemsEntity> findByEffortUniSviluppo(float effortUniSviluppo);

	ConfWorkItemsEntity save(ConfWorkItemsEntity cwi);
	
	void delete(ConfWorkItemsEntity cwi);
	
	@Query(value="select * from conf_workitems where (conf_workitems.id_work_item=:idWorkitem)and(conf_workitems.id_complexity=:idComplexity)", nativeQuery=true)
	ConfWorkItemsEntity findByWorkCompl(Long idWorkitem,Long idComplexity);
}

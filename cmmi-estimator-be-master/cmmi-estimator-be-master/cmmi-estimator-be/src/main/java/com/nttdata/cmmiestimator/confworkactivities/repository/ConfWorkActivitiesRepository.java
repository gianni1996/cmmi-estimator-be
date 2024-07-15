package com.nttdata.cmmiestimator.confworkactivities.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.confworkactivities.model.ConfWorkActivitiesEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ConfWorkActivitiesRepository extends CrudRepository<ConfWorkActivitiesEntity, Integer> {
	
	List<ConfWorkActivitiesEntity> findAll();

	ConfWorkActivitiesEntity findByAttivita(String attivita);

	ConfWorkActivitiesEntity save(ConfWorkActivitiesEntity cwa);
	
	void delete(ConfWorkActivitiesEntity cmp);

}

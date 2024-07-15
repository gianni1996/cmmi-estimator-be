package com.nttdata.cmmiestimator.estimationtype.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.estimationtype.model.EstimationTypeEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface EstimationTypeRepository extends CrudRepository<EstimationTypeEntity, Integer> {
	
	List<EstimationTypeEntity> findAll();

	EstimationTypeEntity findByNome(String nome);

	EstimationTypeEntity save(EstimationTypeEntity et);
	
	void delete(EstimationTypeEntity et);

}

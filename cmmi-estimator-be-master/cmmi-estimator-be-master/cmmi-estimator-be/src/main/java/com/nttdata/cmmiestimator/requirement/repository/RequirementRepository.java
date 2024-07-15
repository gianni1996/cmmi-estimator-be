package com.nttdata.cmmiestimator.requirement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.requirement.model.RequirementEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface RequirementRepository extends CrudRepository<RequirementEntity, Integer> {

	List<RequirementEntity> findAll();

	RequirementEntity findByNome(String nome);

	RequirementEntity save(RequirementEntity rqr);

	void delete(RequirementEntity rqr);
}

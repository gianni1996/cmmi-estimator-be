package com.nttdata.cmmiestimator.phase.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.phase.model.PhaseEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface PhaseRepository extends CrudRepository<PhaseEntity, Integer> {

	List<PhaseEntity> findAll();

	PhaseEntity findByNome(String nome);

	PhaseEntity save(PhaseEntity phs);

	void delete(PhaseEntity phs);
}

package com.nttdata.cmmiestimator.stima.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.stima.model.StimaEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface StimaRepository extends CrudRepository<StimaEntity, Integer> {

	List<StimaEntity> findAll();

	StimaEntity findById(Long id);

	StimaEntity save(StimaEntity stm);

	void delete(StimaEntity stm);

}

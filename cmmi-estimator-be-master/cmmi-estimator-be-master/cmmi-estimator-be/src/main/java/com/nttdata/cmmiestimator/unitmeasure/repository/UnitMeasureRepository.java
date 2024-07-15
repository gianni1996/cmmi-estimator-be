package com.nttdata.cmmiestimator.unitmeasure.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.unitmeasure.model.UnitMeasureEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */

@Repository
public interface UnitMeasureRepository extends CrudRepository<UnitMeasureEntity, Integer> {

	List<UnitMeasureEntity> findAll();

	UnitMeasureEntity findByNome(String nome);

	UnitMeasureEntity save(UnitMeasureEntity unm);

	void delete(UnitMeasureEntity unm);
}

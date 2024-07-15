package com.nttdata.cmmiestimator.costitem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.costitem.model.CostItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface CostItemRepository extends CrudRepository<CostItemEntity, Integer> {

	List<CostItemEntity> findAll();

	CostItemEntity findByNome(String nome);

	CostItemEntity save(CostItemEntity ci);
	
	void delete(CostItemEntity ci);

}

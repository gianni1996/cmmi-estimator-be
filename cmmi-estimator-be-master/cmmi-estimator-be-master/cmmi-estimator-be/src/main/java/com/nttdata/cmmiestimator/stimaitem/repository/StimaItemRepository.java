package com.nttdata.cmmiestimator.stimaitem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */

@Repository
public interface StimaItemRepository extends CrudRepository<StimaItemEntity, Integer> {

	List<StimaItemEntity> findAll();

	StimaItemEntity findById(Long id);

	StimaItemEntity save(StimaItemEntity stmi);
	
	/**
	 * Restituisce tutte le righe che hanno un certo valore di id_stima (foreign key) presa in ingresso
	 * 
	 * @param id
	 * @return
	 */
	@Query(value="select * from stima_item where (id_stima= :id)", nativeQuery=true)
	List<StimaItemEntity>findByStima(Long id);

	void delete(StimaItemEntity stmi);

}

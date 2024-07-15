package com.nttdata.cmmiestimator.confskillmix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.confskillmix.model.ConfSkillMixEntity;


/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ConfSkillMixRepository extends CrudRepository<ConfSkillMixEntity, Integer> {

	List<ConfSkillMixEntity> findAll();

	ConfSkillMixEntity findByProfilo(String profilo);
	
	/**
	 * Restituisce tutte le righe che hanno un certo valore di id_cost_item (foreign key) presa in ingresso
	 * 
	 * @param id
	 * @return
	 */
	@Query(value="select * from conf_skillmix where (id_cost_item= :id)", nativeQuery=true)
	List<ConfSkillMixEntity>findByCostitem(Long id);
	

	ConfSkillMixEntity save(ConfSkillMixEntity csm);

	void delete(ConfSkillMixEntity cmp);
}

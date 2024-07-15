package com.nttdata.cmmiestimator.release.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.release.model.ReleaseEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ReleaseRepository extends CrudRepository<ReleaseEntity, Integer> {

	List<ReleaseEntity> findAll();

	ReleaseEntity findByNome(String nome);

	ReleaseEntity save(ReleaseEntity rls);

	void delete(ReleaseEntity rls);
}

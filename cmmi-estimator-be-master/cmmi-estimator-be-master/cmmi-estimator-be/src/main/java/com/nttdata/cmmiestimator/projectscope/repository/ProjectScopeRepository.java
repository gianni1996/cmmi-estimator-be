package com.nttdata.cmmiestimator.projectscope.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.projectscope.model.ProjectScopeEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ProjectScopeRepository extends CrudRepository<ProjectScopeEntity, Integer> {

	List<ProjectScopeEntity> findAll();

	ProjectScopeEntity findByNome(String nome);

	ProjectScopeEntity save(ProjectScopeEntity prs);

	void delete(ProjectScopeEntity prs);

}

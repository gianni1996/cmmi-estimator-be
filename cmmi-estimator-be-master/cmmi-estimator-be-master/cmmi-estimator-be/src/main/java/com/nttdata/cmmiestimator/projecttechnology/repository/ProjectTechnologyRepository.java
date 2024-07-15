package com.nttdata.cmmiestimator.projecttechnology.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.projecttechnology.model.ProjectTechnologyEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ProjectTechnologyRepository extends CrudRepository<ProjectTechnologyEntity, Integer> {

	List<ProjectTechnologyEntity> findAll();

	ProjectTechnologyEntity findByNome(String nome);

	ProjectTechnologyEntity save(ProjectTechnologyEntity prt);

	void delete(ProjectTechnologyEntity prt);
}

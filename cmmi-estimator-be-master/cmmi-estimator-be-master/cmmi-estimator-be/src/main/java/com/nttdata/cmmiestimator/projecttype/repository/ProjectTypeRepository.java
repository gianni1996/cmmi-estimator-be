package com.nttdata.cmmiestimator.projecttype.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.projecttype.model.ProjectTypeEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ProjectTypeRepository extends CrudRepository<ProjectTypeEntity, Integer> {

	List<ProjectTypeEntity> findAll();

	ProjectTypeEntity findByNome(String nome);

	ProjectTypeEntity save(ProjectTypeEntity prt);

	void delete(ProjectTypeEntity prt);
}

package com.nttdata.cmmiestimator.projecttechnology.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.projecttechnology.model.ProjectTechnologyEntity;
import com.nttdata.cmmiestimator.projecttechnology.repository.ProjectTechnologyRepository;
import com.nttdata.cmmiestimator.projecttechnology.to.ProjectTechnologyCto;
import com.nttdata.cmmiestimator.projecttechnology.to.ProjectTechnologyEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ProjectTechnologyService {

	public static final Logger logger = LoggerFactory.getLogger(ProjectTechnologyService.class);

	@Autowired
	private ProjectTechnologyRepository projecttechnologyRepository;

	private Type listProjectTechnologyCto = new TypeToken<List<ProjectTechnologyCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ProjectTechnologyCto> getProjectTechnology() {

		logger.info("findAll ProjectTechnology.");

		List<ProjectTechnologyCto> projecttechnology;

		ModelMapper mapper = new ModelMapper();

		List<ProjectTechnologyEntity> ris = projecttechnologyRepository.findAll();

		try {
			projecttechnology = mapper.map(ris, listProjectTechnologyCto);
			logger.info("ProjectTechnology mostrata correttamente ({})", projecttechnology);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del  projecttechnology, ({})", e.getMessage());
			projecttechnology = null;
		}

		return projecttechnology;
	}

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProjectTechnologyCto getNomeProjectTechnology(String nome) {

		logger.info("findByNome ProjectTechnology.");

		ProjectTechnologyCto projecttechnology;

		ModelMapper mapper = new ModelMapper();

		ProjectTechnologyEntity ris = projecttechnologyRepository.findByNome(nome);

		try {
			projecttechnology = mapper.map(ris, ProjectTechnologyCto.class);
			logger.info("ProjectTechnology mostrata correttamente ({})", projecttechnology);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del  projecttechnology, ({})", e.getMessage());
			projecttechnology = null;
		}

		return projecttechnology;
	}

	/**
	 * 
	 * @param prt
	 * @return
	 */
	public ProjectTechnologyEto saveProjectTechnology(ProjectTechnologyEto prt) {

		logger.info("save ProjectTechnology.");

		ProjectTechnologyEto projecttechnology;

		ModelMapper mapper = new ModelMapper();

		try {
			projecttechnology = mapper.map(
					projecttechnologyRepository.save(mapper.map(prt, ProjectTechnologyEntity.class)),
					ProjectTechnologyEto.class);
			logger.info("ProjectTechnology salvata correttamente ({})", projecttechnology);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del  projecttechnology, ({})", e.getMessage());
			projecttechnology = null;
		}

		return projecttechnology;
	}

	/**
	 * 
	 * @param prt
	 * @return
	 */
	public boolean deleteProjectTechnologyEntity(ProjectTechnologyEto prt) {

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			projecttechnologyRepository.delete(mapper.map(prt, ProjectTechnologyEntity.class));
			result = true;
			logger.info("Elemento ProjectTechnology eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel ProjectTechnology, ({})", e.getMessage());
		}

		return result;
	}

}

package com.nttdata.cmmiestimator.projectscope.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.projectscope.model.ProjectScopeEntity;
import com.nttdata.cmmiestimator.projectscope.repository.ProjectScopeRepository;
import com.nttdata.cmmiestimator.projectscope.to.ProjectScopeCto;
import com.nttdata.cmmiestimator.projectscope.to.ProjectScopeEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ProjectScopeService {

	public static final Logger logger = LoggerFactory.getLogger(ProjectScopeService.class);

	@Autowired
	private ProjectScopeRepository projectscopeRepository;

	private Type listProjectScopeCto = new TypeToken<List<ProjectScopeCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ProjectScopeCto> getProjectScope() {

		logger.info("findAll ProjectScope.");

		List<ProjectScopeCto> projectscope;

		ModelMapper mapper = new ModelMapper();

		List<ProjectScopeEntity> ris = projectscopeRepository.findAll();

		try {
			projectscope = mapper.map(ris, listProjectScopeCto);
			logger.info("ProjectScope mostrata correttamente ({})", projectscope);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del projectscope, ({})", e.getMessage());
			projectscope = null;
		}

		return projectscope;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProjectScopeCto getNomeProjectScope(String nome) {

		logger.info("findByNome ProjectScope.");

		ProjectScopeCto projectscope;

		ModelMapper mapper = new ModelMapper();

		ProjectScopeEntity ris = projectscopeRepository.findByNome(nome);

		try {
			projectscope = mapper.map(ris, ProjectScopeCto.class);
			logger.info("ProjectScope mostrata correttamente ({})", projectscope);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del projectscope, ({})", e.getMessage());
			projectscope = null;
		}
		return projectscope;
	}

	/**
	 * 
	 * @param prs
	 * @return
	 */
	public ProjectScopeEto saveProjectScope(ProjectScopeEto prs) {

		logger.info("save ProjectScope.");

		ProjectScopeEto projectscope;

		ModelMapper mapper = new ModelMapper();

		try {
			projectscope = mapper.map(projectscopeRepository.save(mapper.map(prs, ProjectScopeEntity.class)),
					ProjectScopeEto.class);
			logger.info("ProjectScope salvata correttamente ({})", projectscope);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del Projectscope, ({})", e.getMessage());
			projectscope = null;
		}

		return projectscope;
	}

	/**
	 * 
	 * @param prs
	 * @return
	 */
	public boolean deleteProjectScopeEntity(ProjectScopeEto prs) {

		logger.info("delete ProjectScope.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			projectscopeRepository.delete(mapper.map(prs, ProjectScopeEntity.class));
			result = true;
			logger.info("Elemento ProjectScope eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel ProjectScope, ({})", e.getMessage());
		}

		return result;
	}

}

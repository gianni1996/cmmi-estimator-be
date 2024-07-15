package com.nttdata.cmmiestimator.projecttype.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.projecttype.model.ProjectTypeEntity;
import com.nttdata.cmmiestimator.projecttype.repository.ProjectTypeRepository;
import com.nttdata.cmmiestimator.projecttype.to.ProjectTypeCto;
import com.nttdata.cmmiestimator.projecttype.to.ProjectTypeEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ProjectTypeService {

	public static final Logger logger = LoggerFactory.getLogger(ProjectTypeService.class);

	@Autowired
	private ProjectTypeRepository projecttypeRepository;

	private Type listProjectTypeCto = new TypeToken<List<ProjectTypeCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ProjectTypeCto> getProjectType() {

		logger.info("findAll ProjectType.");

		List<ProjectTypeCto> projecttype;

		ModelMapper mapper = new ModelMapper();

		List<ProjectTypeEntity> ris = projecttypeRepository.findAll();

		try {
			projecttype = mapper.map(ris, listProjectTypeCto);
			logger.info("ProjectType mostrata correttamente ({})", projecttype);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del projecttype, ({})", e.getMessage());
			projecttype = null;
		}
		return projecttype;

	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ProjectTypeCto getNomeProjectType(String nome) {

		logger.info("findByNomeProjectType.");

		ProjectTypeCto projecttype;

		ModelMapper mapper = new ModelMapper();

		ProjectTypeEntity ris = projecttypeRepository.findByNome(nome);

		try {
			projecttype = mapper.map(ris, ProjectTypeCto.class);
			logger.info("ProjectType mostrata correttamente ({})", projecttype);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del projecttype, ({})", e.getMessage());
			projecttype = null;
		}
		return projecttype;
	}

	/**
	 * 
	 * @param prt
	 * @return
	 */
	public ProjectTypeEto saveProjectType(ProjectTypeEto prt) {

		logger.info("save ProjectType.");

		ProjectTypeEto projecttype;

		ModelMapper mapper = new ModelMapper();

		try {
			projecttype = mapper.map(projecttypeRepository.save(mapper.map(prt, ProjectTypeEntity.class)),
					ProjectTypeEto.class);
			logger.info("ProjectType salvata correttamente ({})", projecttype);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del ProjectType, ({})", e.getMessage());
			projecttype = null;
		}

		return projecttype;
	}

	/**
	 * 
	 * @param prt
	 * @return
	 */
	public boolean deleteProjectTypeEntity(ProjectTypeEto prt) {

		logger.info("delete ProjectType.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			projecttypeRepository.delete(mapper.map(prt, ProjectTypeEntity.class));
			result = true;
			logger.info("Elemento ProjectType eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel ProjectType, ({})", e.getMessage());
		}

		return result;
	}
}

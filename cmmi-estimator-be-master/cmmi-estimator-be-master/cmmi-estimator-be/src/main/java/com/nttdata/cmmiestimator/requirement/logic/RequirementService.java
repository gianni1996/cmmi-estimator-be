package com.nttdata.cmmiestimator.requirement.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.requirement.model.RequirementEntity;
import com.nttdata.cmmiestimator.requirement.repository.RequirementRepository;
import com.nttdata.cmmiestimator.requirement.to.RequirementCto;
import com.nttdata.cmmiestimator.requirement.to.RequirementEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class RequirementService {

	public static final Logger logger = LoggerFactory.getLogger(RequirementService.class);

	@Autowired
	private RequirementRepository requirementRepository;

	private Type listRequirementCto = new TypeToken<List<RequirementCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<RequirementCto> getRequirement() {

		logger.info("findAll Requirement.");

		List<RequirementCto> requirement;

		ModelMapper mapper = new ModelMapper();

		List<RequirementEntity> ris = requirementRepository.findAll();

		try {
			requirement = mapper.map(ris, listRequirementCto);
			logger.info("Requirement mostrata correttamente ({})", requirement);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del requirement, ({})", e.getMessage());
			requirement = null;
		}

		return requirement;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public RequirementCto getNomeRequirement(String nome) {

		logger.info("findByNome Requirement.");

		RequirementCto requirement;

		ModelMapper mapper = new ModelMapper();

		RequirementEntity ris = requirementRepository.findByNome(nome);

		try {
			requirement = mapper.map(ris, RequirementCto.class);
			logger.info("Requirement mostrata correttamente ({})", requirement);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del requirement, ({})", e.getMessage());
			requirement = null;
		}

		return requirement;
	}

	/**
	 * 
	 * @param rpr
	 * @return
	 */
	public RequirementEto saveRequirement(RequirementEto rpr) {

		logger.info("save Requirement.");

		RequirementEto requirement;

		ModelMapper mapper = new ModelMapper();

		try {
			requirement = mapper.map(requirementRepository.save(mapper.map(rpr, RequirementEntity.class)),
					RequirementEto.class);
			logger.info("Requirement salvata correttamente ({})", requirement);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del Requirement, ({})", e.getMessage());
			requirement = null;
		}

		return requirement;
	}

	/**
	 * 
	 * @param rpr
	 * @return
	 */
	public boolean deleteRequirementEntity(RequirementEto rpr) {

		logger.info("delete Requirement.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			requirementRepository.delete(mapper.map(rpr, RequirementEntity.class));
			result = true;
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel Requirement, ({})", e.getMessage());

		}

		return result;
	}

}

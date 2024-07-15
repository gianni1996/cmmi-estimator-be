package com.nttdata.cmmiestimator.confskillmix.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.confskillmix.model.ConfSkillMixEntity;
import com.nttdata.cmmiestimator.confskillmix.repository.ConfSkillMixRepository;
import com.nttdata.cmmiestimator.confskillmix.to.ConfSkillMixCto;
import com.nttdata.cmmiestimator.confskillmix.to.ConfSkillMixEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ConfSkillMixService {

	public static final Logger logger = LoggerFactory.getLogger(ConfSkillMixService.class);

	@Autowired
	private ConfSkillMixRepository confskillmixRepository;

	private Type listConfSkillMixCto = new TypeToken<List<ConfSkillMixCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ConfSkillMixCto> getConfSkillMix() {

		logger.info("findAll ConfSkillMix.");

		List<ConfSkillMixCto> confskillmix;

		ModelMapper mapper = new ModelMapper();

		List<ConfSkillMixEntity> ris = confskillmixRepository.findAll();

		try {
			confskillmix = mapper.map(ris, listConfSkillMixCto);
			logger.info("ConfSkillMix mostrata correttamente ({})", confskillmix);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del confskillmix, ({})", e.getMessage());
			confskillmix = null;
		}

		return confskillmix;
	}

	/**
	 * 
	 * @param profilo
	 * @return
	 */
	public ConfSkillMixCto getProfiloConfSkillMix(String profilo) {

		logger.info("findByProfilo ConfSkillMix.");

		ConfSkillMixCto confskillmix;

		ModelMapper mapper = new ModelMapper();

		ConfSkillMixEntity ris = confskillmixRepository.findByProfilo(profilo);

		try {
			confskillmix = mapper.map(ris, ConfSkillMixCto.class);
			logger.info("ConfSkillMix mostrata correttamente ({})", confskillmix);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del confskillmix, ({})", e.getMessage());
			confskillmix = null;
		}

		return confskillmix;
	}
	
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<ConfSkillMixCto> getCostitemConfSkillMix(Long id) {

		logger.info("findByProfilo ConfSkillMix.");

		 List<ConfSkillMixCto> confskillmix;

		ModelMapper mapper = new ModelMapper();

		List<ConfSkillMixEntity> ris = confskillmixRepository.findByCostitem(id);

		try {
			confskillmix = mapper.map(ris, listConfSkillMixCto);
			logger.info("ConfSkillMix mostrata correttamente ({})", confskillmix);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del confskillmix, ({})", e.getMessage());
			confskillmix = null;
		}

		return confskillmix;
	}

	/**
	 * 
	 * @param csm
	 * @return
	 */
	public ConfSkillMixEto saveConfSkillMix(ConfSkillMixCto csm) {

		logger.info("save ConfSkillMix.");

		ConfSkillMixEto confskillmix;

		ModelMapper mapper = new ModelMapper();

		try {
			confskillmix = mapper.map(confskillmixRepository.save(mapper.map(csm, ConfSkillMixEntity.class)),
					ConfSkillMixEto.class);
			logger.info("ConfSkillMix salvata correttamente ({})", confskillmix);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del ConfSkillMix, ({})", e.getMessage());
			confskillmix = null;
		}

		return confskillmix;
	}

	/**
	 * 
	 * @param csm
	 * @return
	 */
	public boolean deleteConfSkillMixEntity(ConfSkillMixCto csm) {

		logger.info("delete ConfSkillMix.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			confskillmixRepository.delete(mapper.map(csm, ConfSkillMixEntity.class));
			result = true;
			logger.info("Elemento ConfSkillMix eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel ConfSkillMix, ({})", e.getMessage());
		}

		return result;
	}

}

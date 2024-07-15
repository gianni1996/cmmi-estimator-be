package com.nttdata.cmmiestimator.confworkactivities.logic;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.confworkactivities.model.ConfWorkActivitiesEntity;
import com.nttdata.cmmiestimator.confworkactivities.repository.ConfWorkActivitiesRepository;
import com.nttdata.cmmiestimator.confworkactivities.to.ConfWorkActivitiesCto;
import com.nttdata.cmmiestimator.confworkactivities.to.ConfWorkActivitiesEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
public class ConfWorkActivitiesService {

	public static final Logger logger = LoggerFactory.getLogger(ConfWorkActivitiesService.class);

	@Autowired
	private ConfWorkActivitiesRepository confWorkActivitiesRepository;

	private Type listConfWorkActivitiesCto = new TypeToken<List<ConfWorkActivitiesCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ConfWorkActivitiesCto> getConfWorkActivities() {

		logger.info("findAll ConfWorkActivities.");

		List<ConfWorkActivitiesCto> confworkactivities;

		ModelMapper mapper = new ModelMapper();

		List<ConfWorkActivitiesEntity> ris = confWorkActivitiesRepository.findAll();

		try {
			confworkactivities = mapper.map(ris, listConfWorkActivitiesCto);
			logger.info("ConfWorkActivities mostrata correttamente ({})", confworkactivities);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del ConfWorkActivities, ({})", e.getMessage());
			confworkactivities = null;
		}

		return confworkactivities;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ConfWorkActivitiesCto getAttivitaConfWorkActivities(String attivita) {

		logger.info("findByAttivita ConfWorkActivities.");

		ConfWorkActivitiesCto confworkactivities;

		ModelMapper mapper = new ModelMapper();

		ConfWorkActivitiesEntity ris = confWorkActivitiesRepository.findByAttivita(attivita);

		try {
			confworkactivities = mapper.map(ris, ConfWorkActivitiesCto.class);
			logger.info("ConfWorkActivities mostrata correttamente ({})", confworkactivities);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del ConfWorkActivities, ({})", e.getMessage());
			confworkactivities = null;
		}

		return confworkactivities;
	}

	/**
	 * 
	 * @param cwa
	 * @return
	 */
	public ConfWorkActivitiesEto saveConfWorkActivities(ConfWorkActivitiesEto cwa) {

		logger.info("save ConfWorkActivities.");

		ConfWorkActivitiesEto confworkactivities;

		ModelMapper mapper = new ModelMapper();

		try {
			confworkactivities = mapper.map(
					confWorkActivitiesRepository.save(mapper.map(cwa, ConfWorkActivitiesEntity.class)),
					ConfWorkActivitiesEto.class);
			logger.info("ConfWorkActivities salvata correttamente ({})", confworkactivities);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del ConfWorkActivities, ({})", e.getMessage());
			confworkactivities = null;
		}

		return confworkactivities;
	}

	public boolean deleteConfWorkActivitiesEntity(ConfWorkActivitiesEto cwa) {

		logger.info("delete ConfWorkActivities.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			confWorkActivitiesRepository.delete(mapper.map(cwa, ConfWorkActivitiesEntity.class));
			result = true;
			logger.info("Elemento ConfWorkActivities eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel ConfWorkActivities, ({})", e.getMessage());
		}

		return result;
	}

}

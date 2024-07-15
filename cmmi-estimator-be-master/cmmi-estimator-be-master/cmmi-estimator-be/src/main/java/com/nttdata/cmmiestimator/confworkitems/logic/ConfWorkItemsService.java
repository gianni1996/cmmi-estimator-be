package com.nttdata.cmmiestimator.confworkitems.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.confworkitems.model.ConfWorkItemsEntity;
import com.nttdata.cmmiestimator.confworkitems.repository.ConfWorkItemsRepository;
import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsCto;
import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsEto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemCto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ConfWorkItemsService {

	public static final Logger logger = LoggerFactory.getLogger(ConfWorkItemsService.class);

	@Autowired
	private ConfWorkItemsRepository confworkitemsRepository;

	private Type listConfWorkItemsCto = new TypeToken<List<ConfWorkItemsCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ConfWorkItemsCto> getConfWorkItems() {

		logger.info("findAll ConfWorkItems.");

		List<ConfWorkItemsCto> confworkitems;

		ModelMapper mapper = new ModelMapper();

		List<ConfWorkItemsEntity> ris = confworkitemsRepository.findAll();

		try {
			confworkitems = mapper.map(ris, listConfWorkItemsCto);
			logger.info("ConfWorkItems mostrata correttamente ({})", confworkitems);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del confworkitems, ({})", e.getMessage());
			confworkitems = null;
		}

		return confworkitems;
	}

	/**
	 * 
	 * @param effortUniSviluppo
	 * @return
	 */
	public List<ConfWorkItemsCto> getEffortUniSviluppoConfWorkItems(float effortUniSviluppo) {

		logger.info("findByEffortUniSviluppo ConfWorkItems.");

		List<ConfWorkItemsCto> confworkitems;

		ModelMapper mapper = new ModelMapper();

		List<ConfWorkItemsEntity> ris = confworkitemsRepository.findByEffortUniSviluppo(effortUniSviluppo);

		try {
			confworkitems = mapper.map(ris, listConfWorkItemsCto);
			logger.info("ConfWorkItems mostrata correttamente ({})", confworkitems);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del confworkitems, ({})", e.getMessage());
			confworkitems = null;
		}

		return confworkitems;
	}
	
	/**
	 * 
	 * @param effortUniSviluppo
	 * @return
	 */
	public ConfWorkItemsCto getWorkCopl(Long idWorkitem, Long idComplexity) {

		logger.info("findByWorkCompl ConfWorkItems.");

		ConfWorkItemsCto confworkitems;

		ModelMapper mapper = new ModelMapper();

		ConfWorkItemsEntity ris = confworkitemsRepository.findByWorkCompl(idWorkitem,idComplexity);

		try {
			confworkitems = mapper.map(ris, ConfWorkItemsCto.class);
			logger.info("ConfWorkItems mostrata correttamente ({})", confworkitems);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del confworkitems, ({})", e.getMessage());
			confworkitems = null;
		}

		return confworkitems;
	}
	
	/**
	 * 
	 * @param cwi
	 * @return
	 */
	public ConfWorkItemsEto saveConfWorkItems(ConfWorkItemsCto cwi) {

		logger.info("save ConfWorkItems.");

		ConfWorkItemsEto confworkitems;

		ModelMapper mapper = new ModelMapper();

		try {
			confworkitems = mapper.map(confworkitemsRepository.save(mapper.map(cwi, ConfWorkItemsEntity.class)),
					ConfWorkItemsEto.class);
			logger.info("ConfWorkItems salvata correttamente ({})", confworkitems);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del ConfWorkItems, ({})", e.getMessage());
			confworkitems = null;
		}

		return confworkitems;

	}

	/**
	 * 
	 * @param cwi
	 * @return
	 */
	public boolean deleteConfWorkItemsEntity(ConfWorkItemsEto cwi) {

			logger.info("delete ConfWorkItems.");

			boolean result = false;

			ModelMapper mapper = new ModelMapper();

			try {
				confworkitemsRepository.delete(mapper.map(cwi, ConfWorkItemsEntity.class));
				result = true;
				logger.info("Elemento Complexity eliminato correttamente ({})", result);
			} catch (Exception e) {
				logger.error("Errore durante l'eliminazione dell'elemento nel ConfWorkItems, ({})", e.getMessage());
			}

			return result;
		}

}

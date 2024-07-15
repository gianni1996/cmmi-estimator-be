package com.nttdata.cmmiestimator.stimaitem.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;
import com.nttdata.cmmiestimator.stimaitem.repository.StimaItemRepository;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemCto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class StimaItemService {

	public static final Logger logger = LoggerFactory.getLogger(StimaItemService.class);
	@Autowired
	private StimaItemRepository stimaItemRepository;

	private Type listStimaItemCto = new TypeToken<List<StimaItemCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<StimaItemCto> getStimaItem() {

		logger.info("findAll Stima.");

		List<StimaItemCto> stimaitem;

		ModelMapper mapper = new ModelMapper();

		List<StimaItemEntity> ris = stimaItemRepository.findAll();

		try {
			stimaitem = mapper.map(ris, listStimaItemCto);
			logger.info("StimaItem mostrata correttamente ({})", stimaitem);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento della stimaItem, ({})", e.getMessage());
			stimaitem = null;
		}

		return stimaitem;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public StimaItemCto getIdStimaItem(Long id) {

		logger.info("findById StimaItem.");

		StimaItemCto stimaitem;

		ModelMapper mapper = new ModelMapper();

		StimaItemEntity ris = stimaItemRepository.findById(id);

		try {
			stimaitem = mapper.map(ris, StimaItemCto.class);
			logger.info("StimaItem mostrata correttamente ({})", stimaitem);

		} catch (Exception e) {
			logger.error("Errore durante il caricamento della stimaitem, ({})", e.getMessage());
			stimaitem = null;
		}

		return stimaitem;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<StimaItemCto> getStimaItemByStima(Long id) {

		logger.info("findByStima StimaItem.");

		List<StimaItemCto> stimaitem;

		ModelMapper mapper = new ModelMapper();

		List<StimaItemEntity> ris = stimaItemRepository.findByStima(id);

		try {
			stimaitem = mapper.map(ris, listStimaItemCto);
			logger.info("ConfSkillMix mostrata correttamente ({})", stimaitem);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento della stimaitem, ({})", e.getMessage());
			stimaitem = null;
		}

		return stimaitem;
	}

	/**
	 * 
	 * @param stmi
	 * @return
	 */
	public StimaItemEto saveStimaItem(StimaItemCto stmi) {

		logger.info("Save Stima.");

		StimaItemEto stimaitem;

		ModelMapper mapper = new ModelMapper();

		try {
			stimaitem = mapper.map(stimaItemRepository.save(mapper.map(stmi, StimaItemEntity.class)),
					StimaItemEto.class);
			logger.info("StimaItem salvata correttamente ({})", stimaitem);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio della stimaItem, ({})", e.getMessage());
			stimaitem = null;
		}
		return stimaitem;

	}

	/**
	 * 
	 * @param stmi
	 * @return
	 */
	public boolean deleteStimaItemEntity(StimaItemCto stmi) {

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			stimaItemRepository.delete(mapper.map(stmi, StimaItemEntity.class));
			result = true;
		} catch (Exception e) {
			System.err.println("Ops! There is a Exception, delete failed.");

		}

		return result;
	}
}

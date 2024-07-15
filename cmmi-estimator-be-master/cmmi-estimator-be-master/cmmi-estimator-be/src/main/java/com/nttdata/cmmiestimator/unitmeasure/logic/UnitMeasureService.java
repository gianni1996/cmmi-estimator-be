package com.nttdata.cmmiestimator.unitmeasure.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.unitmeasure.model.UnitMeasureEntity;
import com.nttdata.cmmiestimator.unitmeasure.repository.UnitMeasureRepository;
import com.nttdata.cmmiestimator.unitmeasure.to.UnitMeasureCto;
import com.nttdata.cmmiestimator.unitmeasure.to.UnitMeasureEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class UnitMeasureService {

	public static final Logger logger = LoggerFactory.getLogger(UnitMeasureService.class);

	@Autowired
	private UnitMeasureRepository unitmeasureRepository;

	private Type listUnitMeasureCto = new TypeToken<List<UnitMeasureCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<UnitMeasureCto> getUnitMeasure() {

		logger.info("findAll UnitMeasure.");

		List<UnitMeasureCto> unitmeasure;

		ModelMapper mapper = new ModelMapper();

		List<UnitMeasureEntity> ris = unitmeasureRepository.findAll();

		try {
			unitmeasure = mapper.map(ris, listUnitMeasureCto);
			logger.info("UnitMeasure mostrata correttamente ({})", unitmeasure);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del unitmesure, ({})", e.getMessage());
			unitmeasure = null;
		}

		return unitmeasure;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public UnitMeasureCto getNomeUnitMeasure(String nome) {

		logger.info("findByNome UnitMeasure.");

		UnitMeasureCto unitmeasure;

		ModelMapper mapper = new ModelMapper();

		UnitMeasureEntity ris = unitmeasureRepository.findByNome(nome);

		try {
			unitmeasure = mapper.map(ris, UnitMeasureCto.class);
			logger.info("UnitMeasure mostrata correttamente ({})", unitmeasure);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del unitmeasure, ({})", e.getMessage());
			unitmeasure = null;
		}

		return unitmeasure;
	}

	/**
	 * 
	 * @param unm
	 * @return
	 */
	public UnitMeasureEto saveUnitMeasure(UnitMeasureEto unm) {

		logger.info("save UnitMeasure.");

		UnitMeasureEto unitmeasure;

		ModelMapper mapper = new ModelMapper();

		try {
			unitmeasure = mapper.map(unitmeasureRepository.save(mapper.map(unm, UnitMeasureEntity.class)),
					UnitMeasureEto.class);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del UnitMeasure, ({})", e.getMessage());
			unitmeasure = null;
		}

		return unitmeasure;
	}

	/**
	 * 
	 * @param cmp
	 * @return
	 */
	public boolean deleteUnitMeasureEntity(UnitMeasureEto cmp) {

		logger.info("delete UnitMeasure.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			unitmeasureRepository.delete(mapper.map(cmp, UnitMeasureEntity.class));
			result = true;
			logger.info("Elemento UnitMeasure eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel UnitMeasure, ({})", e.getMessage());
		}

		return result;
	}
}
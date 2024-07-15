package com.nttdata.cmmiestimator.stima.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.stima.model.StimaEntity;
import com.nttdata.cmmiestimator.stima.repository.StimaRepository;
import com.nttdata.cmmiestimator.stima.to.StimaCto;
import com.nttdata.cmmiestimator.stima.to.StimaEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class StimaService {

	public static final Logger logger = LoggerFactory.getLogger(StimaService.class);

	@Autowired
	private StimaRepository stimaRepository;

	private Type listStimaCto = new TypeToken<List<StimaCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<StimaCto> getStima() {

		logger.info("findAll Stima.");

		List<StimaCto> stima;

		ModelMapper mapper = new ModelMapper();

		List<StimaEntity> ris = stimaRepository.findAll();

		try {
			stima = mapper.map(ris, listStimaCto);
			logger.info("Stima mostrata correttamente ({})", stima);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento della stima, ({})", e.getMessage());
			stima = null;
		}

		return stima;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public StimaCto getIdStima(Long id) {

		logger.info("findById Stima.");

		StimaCto stima;

		ModelMapper mapper = new ModelMapper();

		StimaEntity ris = stimaRepository.findById(id);

		try {
			stima = mapper.map(ris, StimaCto.class);
			logger.info("Stima mostrata correttamente ({})", stima);

		} catch (Exception e) {
			logger.error("Errore durante il caricamento della stima, ({})", e.getMessage());
			stima = null;
		}

		return stima;
	}

	/**
	 * 
	 * @param stm
	 * @return
	 */
	public StimaEto saveStima(StimaCto stm) {

		logger.info("Save Stima.");

		StimaEto stima;

		ModelMapper mapper = new ModelMapper();

		try {
			stima = mapper.map(stimaRepository.save(mapper.map(stm, StimaEntity.class)), StimaEto.class);
			logger.info("Stima salvata correttamente ({})", stima);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio della stima, ({})", e.getMessage());
			stima = null;
		}
		return stima;

	}

	/**
	 * 
	 * @param cmp
	 * @return
	 */
	public boolean deleteStimaEntity(StimaEto cmp) {

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			stimaRepository.delete(mapper.map(cmp, StimaEntity.class));
			result = true;
		} catch (Exception e) {
			System.err.println("Ops! There is a Exception, delete failed.");

		}

		return result;
	}

}

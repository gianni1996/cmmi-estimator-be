package com.nttdata.cmmiestimator.phase.logic;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.phase.model.PhaseEntity;
import com.nttdata.cmmiestimator.phase.repository.PhaseRepository;
import com.nttdata.cmmiestimator.phase.to.PhaseCto;
import com.nttdata.cmmiestimator.phase.to.PhaseEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
public class PhaseService {

	public static final Logger logger = LoggerFactory.getLogger(PhaseService.class);

	@Autowired
	private PhaseRepository phaseRepository;

	private Type listPhaseCto = new TypeToken<List<PhaseCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<PhaseCto> getPhase() {

		logger.info("findAll Phase.");

		List<PhaseCto> phase;

		ModelMapper mapper = new ModelMapper();

		List<PhaseEntity> ris = phaseRepository.findAll();

		try {
			phase = mapper.map(ris, listPhaseCto);
			logger.info("Phase mostrata correttamente ({})", phase);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del phase, ({})", e.getMessage());
			phase = null;
		}
		return phase;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PhaseCto getNomePhase(String nome) {

		logger.info("findByNome Phase.");

		PhaseCto phase;

		ModelMapper mapper = new ModelMapper();

		PhaseEntity ris = phaseRepository.findByNome(nome);

		try {
			phase = mapper.map(ris, PhaseCto.class);
			logger.info("Phase mostrata correttamente ({})", phase);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del phase, ({})", e.getMessage());
			phase = null;
		}
		return phase;
	}

	/**
	 * 
	 * @param phs
	 * @return
	 */
	public PhaseEto savePhase(PhaseEto phs) {

		logger.info("save Phase.");

		PhaseEto phase;

		ModelMapper mapper = new ModelMapper();

		try {
			phase = mapper.map(phaseRepository.save(mapper.map(phs, PhaseEntity.class)), PhaseEto.class);
			logger.info("Phase salvata correttamente ({})", phase);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del Phase, ({})", e.getMessage());
			phase = null;
		}
		return phase;
	}

	/**
	 * 
	 * @param phs
	 * @return
	 */
	public boolean deletePhaseEntity(PhaseEto phs) {

		logger.info("delete Phase.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			phaseRepository.delete(mapper.map(phs, PhaseEntity.class));
			result = true;
			logger.info("Elemento Phase eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel Phase, ({})", e.getMessage());
		}

		return result;
	}

}

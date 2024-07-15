package com.nttdata.cmmiestimator.release.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.release.model.ReleaseEntity;
import com.nttdata.cmmiestimator.release.repository.ReleaseRepository;
import com.nttdata.cmmiestimator.release.to.ReleaseCto;
import com.nttdata.cmmiestimator.release.to.ReleaseEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ReleaseService {

	public static final Logger logger = LoggerFactory.getLogger(ReleaseService.class);

	@Autowired
	private ReleaseRepository releaseRepository;

	private Type listReleaseCto = new TypeToken<List<ReleaseCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<ReleaseCto> getRelease() {

		logger.info("findAll Release.");

		List<ReleaseCto> release;

		ModelMapper mapper = new ModelMapper();

		List<ReleaseEntity> ris = releaseRepository.findAll();

		try {
			release = mapper.map(ris, listReleaseCto);
			logger.info("Releasemostrata correttamente ({})", release);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del release, ({})", e.getMessage());
			release = null;
		}

		return release;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public ReleaseCto getNomeRelease(String nome) {

		logger.info("findByNome Release.");

		ReleaseCto release;

		ModelMapper mapper = new ModelMapper();

		ReleaseEntity ris = releaseRepository.findByNome(nome);

		try {
			release = mapper.map(ris, ReleaseCto.class);
			logger.info("Release mostrata correttamente ({})", release);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del release, ({})", e.getMessage());
			release = null;
		}

		return release;
	}

	/**
	 * 
	 * @param rls
	 * @return
	 */
	public ReleaseEto saveRelease(ReleaseEto rls) {

		logger.info("save Release.");

		ReleaseEto release;

		ModelMapper mapper = new ModelMapper();

		try {
			release = mapper.map(releaseRepository.save(mapper.map(rls, ReleaseEntity.class)), ReleaseEto.class);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del Release, ({})", e.getMessage());
			release = null;
		}

		return release;
	}

	/**
	 * 
	 * @param rls
	 * @return
	 */
	public boolean deleteReleaseEntity(ReleaseEto rls) {

		logger.info("delete Release.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			releaseRepository.delete(mapper.map(rls, ReleaseEntity.class));
			result = true;
			logger.info("Elemento Release eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel Release, ({})", e.getMessage());

		}

		return result;
	}

}

package com.nttdata.cmmiestimator.estimationtype.logic;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.estimationtype.model.EstimationTypeEntity;
import com.nttdata.cmmiestimator.estimationtype.repository.EstimationTypeRepository;
import com.nttdata.cmmiestimator.estimationtype.to.EstimationTypeCto;
import com.nttdata.cmmiestimator.estimationtype.to.EstimationTypeEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
public class EstimationTypeService {

	public static final Logger logger = LoggerFactory.getLogger(EstimationTypeService.class);

	@Autowired
	private EstimationTypeRepository estimationtypeRepository;

	private Type listEstimationTypeCto = new TypeToken<List<EstimationTypeCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<EstimationTypeCto> getEstimationType() {

		logger.info("findAll EstimationType.");

		List<EstimationTypeCto> estimationtype;

		ModelMapper mapper = new ModelMapper();

		List<EstimationTypeEntity> ris = estimationtypeRepository.findAll();

		try {
			estimationtype = mapper.map(ris, listEstimationTypeCto);
			logger.info("EstimationType mostrata correttamente ({})", estimationtype);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del  estimationtype, ({})", e.getMessage());
			estimationtype = null;
		}
		return estimationtype;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public EstimationTypeCto getNomeEstimationType(String nome) {

		logger.info("findByNome EstimationType.");

		EstimationTypeCto estimationtype;

		ModelMapper mapper = new ModelMapper();

		EstimationTypeEntity ris = estimationtypeRepository.findByNome(nome);

		try {
			estimationtype = mapper.map(ris, EstimationTypeCto.class);
			logger.info("EstimationType mostrata correttamente ({})", estimationtype);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del estimationtype, ({})", e.getMessage());
			estimationtype = null;
		}
		return estimationtype;
	}

	/**
	 * 
	 * @param et
	 * @return
	 */
	public EstimationTypeEto saveEstimationType(EstimationTypeEto et) {

		logger.info("save EstimationType.");

		EstimationTypeEto estimationtype;

		ModelMapper mapper = new ModelMapper();

		try {
			estimationtype = mapper.map(estimationtypeRepository.save(mapper.map(et, EstimationTypeEntity.class)),
					EstimationTypeEto.class);

			logger.info("EstimationType salvata correttamente ({})", estimationtype);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del EstimationType, ({})", e.getMessage());
			estimationtype = null;
		}

		return estimationtype;
	}

	/**
	 * 
	 * @param et
	 * @return
	 */
	public boolean deleteEstimationTypeEntity(EstimationTypeEto et) {

		logger.info("delete EstimationType.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			estimationtypeRepository.delete(mapper.map(et, EstimationTypeEntity.class));
			result = true;
			logger.info("Elemento EstimationType eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel EstimationType, ({})", e.getMessage());
		}

		return result;
	}

}

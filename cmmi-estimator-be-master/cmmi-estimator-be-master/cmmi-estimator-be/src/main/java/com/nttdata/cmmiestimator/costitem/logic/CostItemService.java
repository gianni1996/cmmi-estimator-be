package com.nttdata.cmmiestimator.costitem.logic;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.complexity.model.ComplexityEntity;
import com.nttdata.cmmiestimator.complexity.to.ComplexityCto;
import com.nttdata.cmmiestimator.costitem.model.CostItemEntity;
import com.nttdata.cmmiestimator.costitem.repository.CostItemRepository;
import com.nttdata.cmmiestimator.costitem.to.CostItemCto;
import com.nttdata.cmmiestimator.costitem.to.CostItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
public class CostItemService {

	public static final Logger logger = LoggerFactory.getLogger(CostItemService.class);

	@Autowired
	private CostItemRepository costitemRepository;

	private Type listCostItemCto = new TypeToken<List<CostItemCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<CostItemCto> getCostItem() {

		logger.info("findAll CostItem.");

		List<CostItemCto> costitem;

		ModelMapper mapper = new ModelMapper();

		List<CostItemEntity> ris = costitemRepository.findAll();

		try {
			costitem = mapper.map(ris, listCostItemCto);
			logger.info("CostItem mostrata correttamente ({})", costitem);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del costitem, ({})", e.getMessage());
			costitem = null;
		}

		return costitem;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public CostItemCto getNomeCostItem(String nome) {

		logger.info("findByNome CostItem.");

		CostItemCto costitem;

		ModelMapper mapper = new ModelMapper();

		CostItemEntity ris = costitemRepository.findByNome(nome);

		try {
			costitem = mapper.map(ris, CostItemCto.class);
			logger.info("Complexity mostrata correttamente ({})", costitem);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del costitem, ({})", e.getMessage());
			costitem = null;
		}

		return costitem;
	}

	/**
	 * 
	 * @param ci
	 * @return
	 */
	public CostItemEto saveCostItem(CostItemEto ci) {

		logger.info("save CostItem.");

		CostItemEto costitem;

		ModelMapper mapper = new ModelMapper();

		try {
			costitem = mapper.map(costitemRepository.save(mapper.map(ci, CostItemEntity.class)), CostItemEto.class);
			logger.info("CostItem salvata correttamente ({})", costitem);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del CostItem, ({})", e.getMessage());
			costitem = null;
		}

		return costitem;
	}

	/**
	 * 
	 * @param ci
	 * @return
	 */
	public boolean deleteCostItemEntity(CostItemEto ci) {

		logger.info("delete CostItem.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			costitemRepository.delete(mapper.map(ci, CostItemEntity.class));
			result = true;
			logger.info("Elemento CostItem eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel CostItem, ({})", e.getMessage());
		}

		return result;
	}

}

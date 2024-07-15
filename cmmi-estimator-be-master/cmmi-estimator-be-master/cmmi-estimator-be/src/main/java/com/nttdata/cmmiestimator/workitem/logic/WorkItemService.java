package com.nttdata.cmmiestimator.workitem.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.workitem.model.WorkItemEntity;
import com.nttdata.cmmiestimator.workitem.repository.WorkItemRepository;
import com.nttdata.cmmiestimator.workitem.to.WorkItemCto;
import com.nttdata.cmmiestimator.workitem.to.WorkItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */

@Service
@Transactional
public class WorkItemService {

	public static final Logger logger = LoggerFactory.getLogger(WorkItemService.class);

	@Autowired
	private WorkItemRepository workitemRepository;

	private Type listWorkItemCto = new TypeToken<List<WorkItemCto>>() {
	}.getType();

	/**
	 * 
	 * @return
	 */
	public List<WorkItemCto> getWorkItem() {

		logger.info("findAll WorkItem.");

		List<WorkItemCto> workitem;

		ModelMapper mapper = new ModelMapper();

		List<WorkItemEntity> ris = workitemRepository.findAll();

		try {
			workitem = mapper.map(ris, listWorkItemCto);
			logger.info("WorkItemmostrata correttamente ({})", workitem);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del workitem, ({})", e.getMessage());
			workitem = null;
		}

		return workitem;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public WorkItemCto getNomeWorkItem(String nome) {

		logger.info("findByNome WorkItem.");

		WorkItemCto workitem;

		ModelMapper mapper = new ModelMapper();

		WorkItemEntity ris = workitemRepository.findByNome(nome);

		try {
			workitem = mapper.map(ris, WorkItemCto.class);
			logger.info("WorkItem mostrata correttamente ({})", workitem);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del workitem ({})", e.getMessage());
			workitem = null;
		}

		return workitem;
	}

	/**
	 * 
	 * @param wki
	 * @return
	 */
	public WorkItemEto saveWorkItem(WorkItemEto wki) {

		logger.info("save WorkItem.");

		WorkItemEto workitem;

		ModelMapper mapper = new ModelMapper();

		try {
			workitem = mapper.map(workitemRepository.save(mapper.map(wki, WorkItemEntity.class)), WorkItemEto.class);
			logger.info("WorkItem salvata correttamente ({})", workitem);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del WorkItem, ({})", e.getMessage());
			workitem = null;
		}

		return workitem;
	}

	/**
	 * 
	 * @param wki
	 * @return
	 */
	public boolean deleteWorkItemEntity(WorkItemEto wki) {

		logger.info("delete WorkItem.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			workitemRepository.delete(mapper.map(wki, WorkItemEntity.class));
			result = true;
			logger.info("Elemento WorkItem eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel  WorkItem, ({})", e.getMessage());
		}

		return result;
	}

}
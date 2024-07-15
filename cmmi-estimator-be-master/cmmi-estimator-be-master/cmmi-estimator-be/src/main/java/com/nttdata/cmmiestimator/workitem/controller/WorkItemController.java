package com.nttdata.cmmiestimator.workitem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.cmmiestimator.application.config.BusinesLogicResponse;
import com.nttdata.cmmiestimator.workitem.logic.WorkItemService;
import com.nttdata.cmmiestimator.workitem.to.WorkItemCto;
import com.nttdata.cmmiestimator.workitem.to.WorkItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/workitem")
public class WorkItemController {

	public static final Logger logger = LoggerFactory.getLogger(WorkItemController.class);

	@Autowired
	private WorkItemService workitemService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<WorkItemCto>> findByWorkItem() {

		logger.info("Sono nel Controller findAll, workitem ({})");

		List<WorkItemCto> ris = workitemService.getWorkItem();

		if (ris == null) {
			return new ResponseEntity<List<WorkItemCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<WorkItemCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<WorkItemCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, WorkItem ({})" ,nome);

		WorkItemCto ris = workitemService.getNomeWorkItem(nome);

		if (ris == null) {
			return new ResponseEntity<WorkItemCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<WorkItemCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param cmp
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertWorkItem(@RequestBody WorkItemEto wki) {

		logger.info("Sono nel Controller save, WorkItem ({})", wki);

		WorkItemEto ris = workitemService.saveWorkItem(wki);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del WorkItem ."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento WorkItem salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param wki
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteWorkItem(@RequestBody WorkItemEto wki) {

		logger.info("Sono nel Controller delete, WorkItem({})", wki);

		boolean esito = workitemService.deleteWorkItemEntity(wki);
		if (esito == false) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Elemento non eliminato correttamente."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("OK", "Elemento eliminato correttamente."), HttpStatus.OK);
		}
	}
}

package com.nttdata.cmmiestimator.costitem.controller;

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
import com.nttdata.cmmiestimator.costitem.logic.CostItemService;
import com.nttdata.cmmiestimator.costitem.to.CostItemCto;
import com.nttdata.cmmiestimator.costitem.to.CostItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/costitem")
public class CostItemController {

	public static final Logger logger = LoggerFactory.getLogger(CostItemController.class);

	@Autowired
	private CostItemService costitemService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<CostItemCto>> findByCostItem() {

		logger.info("Sono nel Controller findAll, CostItem ({})");

		List<CostItemCto> ris = costitemService.getCostItem();

		if (ris == null) {
			return new ResponseEntity<List<CostItemCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<CostItemCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<CostItemCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, costitem ({})",nome);

		CostItemCto ris = costitemService.getNomeCostItem(nome);

		if (ris == null) {
			return new ResponseEntity<CostItemCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<CostItemCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param ci
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertCostItem(@RequestBody CostItemEto ci) {

		logger.info("Sono nel Controller save, costitem ({})", ci);

		CostItemEto ris = costitemService.saveCostItem(ci);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del costitem."),
					HttpStatus.INTERNAL_SERVER_ERROR);

		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento CostItem salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param ci
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteCostItem(@RequestBody CostItemEto ci) {
		
		logger.info("Sono nel Controller delete, costitem ({})", ci);

		boolean esito = costitemService.deleteCostItemEntity(ci);
		
		if (esito == false) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Elemento non eliminato correttamente."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("OK", "Elemento eliminato correttamente."), HttpStatus.OK);
		}
	}

}

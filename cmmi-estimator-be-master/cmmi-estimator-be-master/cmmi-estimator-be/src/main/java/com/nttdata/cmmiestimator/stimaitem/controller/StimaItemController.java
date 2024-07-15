package com.nttdata.cmmiestimator.stimaitem.controller;

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
import com.nttdata.cmmiestimator.stimaitem.logic.StimaItemService;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemCto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/stimaitem")
public class StimaItemController {

	public static final Logger logger = LoggerFactory.getLogger(StimaItemController.class);

	@Autowired
	private StimaItemService stimaitemService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<StimaItemCto>> findByStimaItem() {

		logger.info("Sono nel Controller findAll, stima ({})");

		List<StimaItemCto> ris = stimaitemService.getStimaItem();

		if (ris == null) {
			return new ResponseEntity<List<StimaItemCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<StimaItemCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su id
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/{id}")
	public ResponseEntity<StimaItemCto> findById(@PathVariable Long id) {

		logger.info("Sono nel Controller findById, stimaItem ({})", id);

		StimaItemCto ris = stimaitemService.getIdStimaItem(id);
		if (ris == null) {
			return new ResponseEntity<StimaItemCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<StimaItemCto>(ris, HttpStatus.OK);
		}
	}
	
	
	/**
	 * Ricerca basata sulla chiave esterna stima
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/searchstima/{id}")
	public ResponseEntity<List<StimaItemCto>> findByStima(@PathVariable Long id) {

		logger.info("Sono nel Controller findByStima, StimaItem ({})", id);

		List<StimaItemCto> ris = stimaitemService.getStimaItemByStima(id);

		if (ris == null) {
			return new ResponseEntity<List<StimaItemCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<StimaItemCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param stmi
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertStimaItem(@RequestBody StimaItemCto stm) {

		logger.info("Sono nel Controller Save, stimaItem ({})", stm);

		StimaItemEto ris = stimaitemService.saveStimaItem(stm);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio della stimaitem."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento Stima salvato correttamente."),
					HttpStatus.OK);
		}

	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param cmp
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteStimaItem(@RequestBody StimaItemCto cmp) {

		logger.info("Sono nel Controller delete, stimaitem ({})", cmp);

		boolean esito = stimaitemService.deleteStimaItemEntity(cmp);

		if (esito == false) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("OK", "Elemento eliminato correttamente."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("OK", "Elemento eliminato correttamente."), HttpStatus.OK);
		}

	}
}

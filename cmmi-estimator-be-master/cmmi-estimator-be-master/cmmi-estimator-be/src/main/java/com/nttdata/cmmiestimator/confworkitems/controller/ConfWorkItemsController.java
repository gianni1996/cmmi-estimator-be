package com.nttdata.cmmiestimator.confworkitems.controller;

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
import com.nttdata.cmmiestimator.confworkitems.logic.ConfWorkItemsService;
import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsCto;
import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/confworkitems")
public class ConfWorkItemsController {

	public static final Logger logger = LoggerFactory.getLogger(ConfWorkItemsController.class);

	@Autowired
	private ConfWorkItemsService confworkitemsService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ConfWorkItemsCto>> findByConfWorkItems() {

		logger.info("Sono nel Controller findAll, ConfWorkItems ({})");

		List<ConfWorkItemsCto> ris = confworkitemsService.getConfWorkItems();

		if (ris == null) {
			return new ResponseEntity<List<ConfWorkItemsCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ConfWorkItemsCto>>(ris, HttpStatus.OK);
		}

	}

	/**
	 * Ricerca elementi basato su id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/search/{effortUniSviluppo}")
	public ResponseEntity<List<ConfWorkItemsCto>> findByEffortUniSviluppo(@PathVariable float effortUniSviluppo) {

		logger.info("Sono nel Controller findByEffortUniSviluppo, ConfWorkItems ({})", effortUniSviluppo);

		List<ConfWorkItemsCto> ris = confworkitemsService.getEffortUniSviluppoConfWorkItems(effortUniSviluppo);

		if (ris == null) {
			return new ResponseEntity<List<ConfWorkItemsCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ConfWorkItemsCto>>(ris, HttpStatus.OK);
		}

	}

	/**
	 * Ricerca elementi basato su id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/effort/{idWorkitem}/{idComplexity}")
	public ResponseEntity<ConfWorkItemsCto> findByEffortUniSviluppo(@PathVariable Long idWorkitem,
			@PathVariable Long idComplexity) {

		logger.info("Sono nel Controller findByEffortUniSviluppo, ConfWorkItems ({})", idWorkitem, idComplexity);

		ConfWorkItemsCto ris = confworkitemsService.getWorkCopl(idWorkitem, idComplexity);

		if (ris == null) {
			return new ResponseEntity<ConfWorkItemsCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ConfWorkItemsCto>(ris, HttpStatus.OK);
		}

	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param cmp
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertConfWorkItems(@RequestBody ConfWorkItemsCto cwi) {

		logger.info("Sono nel Controller save, ConfWorkItems ({})", cwi);

		ConfWorkItemsEto ris = confworkitemsService.saveConfWorkItems(cwi);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del ConfWorkItems."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento ConfWorkItems salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param cwi
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteConfWorkItems(@RequestBody ConfWorkItemsEto cwi) {

		logger.info("Sono nel Controller delete, confworkitems ({})", cwi);

		boolean esito = confworkitemsService.deleteConfWorkItemsEntity(cwi);

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

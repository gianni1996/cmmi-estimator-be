package com.nttdata.cmmiestimator.confworkactivities.controller;

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
import com.nttdata.cmmiestimator.confworkactivities.logic.ConfWorkActivitiesService;
import com.nttdata.cmmiestimator.confworkactivities.to.ConfWorkActivitiesCto;
import com.nttdata.cmmiestimator.confworkactivities.to.ConfWorkActivitiesEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/confworkactivities")
public class ConfWorkActivitiesController {

	public static final Logger logger = LoggerFactory.getLogger(ConfWorkActivitiesController.class);

	@Autowired
	private ConfWorkActivitiesService confWorkActivitiesService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")

	public ResponseEntity<List<ConfWorkActivitiesCto>> findByConfWorkActivities() {

		logger.info("Sono nel Controller findAll, ConfWorkActivities ({})");

		List<ConfWorkActivitiesCto> ris = confWorkActivitiesService.getConfWorkActivities();

		if (ris == null) {
			return new ResponseEntity<List<ConfWorkActivitiesCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ConfWorkActivitiesCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su id
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/search/{attivita}")
	public ResponseEntity<ConfWorkActivitiesCto> findByAttivita(@PathVariable String attivita) {

		logger.info("Sono nel Controller findByAttivita, ConfWorkActivities ({})", attivita);

		ConfWorkActivitiesCto ris = confWorkActivitiesService.getAttivitaConfWorkActivities(attivita);

		if (ris == null) {
			return new ResponseEntity<ConfWorkActivitiesCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ConfWorkActivitiesCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param cwa
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertConfWorkActivities(@RequestBody ConfWorkActivitiesEto cwa) {

		logger.info("Sono nel Controller save, ConfWorkActivities ({})", cwa);

		ConfWorkActivitiesEto cm = confWorkActivitiesService.saveConfWorkActivities(cwa);
		if (cm == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del ConfWorkActivities."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + cm.getId(), "Elemento ConfWorkActivities salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param cwa
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteConfWorkActivities(@RequestBody ConfWorkActivitiesEto cwa) {

		logger.info("Sono nel Controller delete, ConfWorkActivities ({})", cwa);

		boolean esito = confWorkActivitiesService.deleteConfWorkActivitiesEntity(cwa);

		if (esito == false) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Elemento non eliminato correttamente."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {

		}

		return new ResponseEntity<BusinesLogicResponse>(
				new BusinesLogicResponse("OK", "Elemento eliminato correttamente."), HttpStatus.OK);
	}
}

package com.nttdata.cmmiestimator.stima.controller;

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
import com.nttdata.cmmiestimator.stima.logic.StimaService;
import com.nttdata.cmmiestimator.stima.to.StimaCto;
import com.nttdata.cmmiestimator.stima.to.StimaEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/stima")
public class StimaController {

	public static final Logger logger = LoggerFactory.getLogger(StimaController.class);

	@Autowired
	private StimaService stimaService;

	/**
	 * 
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<StimaCto>> findByStima() {

		logger.info("Sono nel Controller findAll, stima ({})");

		List<StimaCto> ris = stimaService.getStima();

		if (ris == null) {
			return new ResponseEntity<List<StimaCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<StimaCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/search/{id}")
	public ResponseEntity<StimaCto> findById(@PathVariable Long id) {

		logger.info("Sono nel Controller findById, stima ({})", id);

		StimaCto ris = stimaService.getIdStima(id);
		if (ris == null) {
			return new ResponseEntity<StimaCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<StimaCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param cmp
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertStima(@RequestBody StimaCto stm) {

		logger.info("Sono nel Controller Save, stima ({})", stm);

		StimaEto ris = stimaService.saveStima(stm);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio della stima."),
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
	 * @param stm
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteStima(@RequestBody StimaEto stm) {

		logger.info("Sono nel Controller delete, stima ({})");

		boolean esito = stimaService.deleteStimaEntity(stm);

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

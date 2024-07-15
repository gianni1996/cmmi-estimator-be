package com.nttdata.cmmiestimator.phase.controller;

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
import com.nttdata.cmmiestimator.phase.logic.PhaseService;
import com.nttdata.cmmiestimator.phase.to.PhaseCto;
import com.nttdata.cmmiestimator.phase.to.PhaseEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/phase")
public class PhaseController {

	public static final Logger logger = LoggerFactory.getLogger(PhaseController.class);

	@Autowired
	private PhaseService phaseService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<PhaseCto>> findBy() {

		logger.info("Sono nel Controller findAll, phase ({})");

		List<PhaseCto> ris = phaseService.getPhase();

		if (ris == null) {
			return new ResponseEntity<List<PhaseCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<PhaseCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */

	@GetMapping("/search/{nome}")
	public ResponseEntity<PhaseCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, phase ({})", nome);

		PhaseCto ris = phaseService.getNomePhase(nome);

		if (ris == null) {
			return new ResponseEntity<PhaseCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<PhaseCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param phs
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertPhase(@RequestBody PhaseEto phs) {

		logger.info("Sono nel Controller save, phase ({})", phs);

		PhaseEto ris = phaseService.savePhase(phs);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del Phase."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento Phase salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param phs
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deletePhase(@RequestBody PhaseEto phs) {

		logger.info("Sono nel Controller delete, phase ({})", phs);

		boolean esito = phaseService.deletePhaseEntity(phs);

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

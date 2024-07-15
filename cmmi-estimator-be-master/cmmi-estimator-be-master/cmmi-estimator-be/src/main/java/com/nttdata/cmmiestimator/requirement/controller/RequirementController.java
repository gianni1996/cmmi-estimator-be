package com.nttdata.cmmiestimator.requirement.controller;

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
import com.nttdata.cmmiestimator.requirement.logic.RequirementService;
import com.nttdata.cmmiestimator.requirement.to.RequirementCto;
import com.nttdata.cmmiestimator.requirement.to.RequirementEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/requirement")
public class RequirementController {

	public static final Logger logger = LoggerFactory.getLogger(RequirementController.class);

	@Autowired
	private RequirementService requirementService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<RequirementCto>> findByRequirement() {

		logger.info("Sono nel Controller findAll, Requirement ({})");

		List<RequirementCto> ris = requirementService.getRequirement();

		if (ris == null) {
			return new ResponseEntity<List<RequirementCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<RequirementCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<RequirementCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, Requirement ({})", nome);

		RequirementCto ris = requirementService.getNomeRequirement(nome);

		if (ris == null) {
			return new ResponseEntity<RequirementCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<RequirementCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param rqr
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertRequirement(@RequestBody RequirementEto rqr) {

		logger.info("Sono nel Controller save, Requirement ({})", rqr);

		RequirementEto ris = requirementService.saveRequirement(rqr);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del Requirement."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento Requirement salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param rqr
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteRequirement(@RequestBody RequirementEto rqr) {

		logger.info("Sono nel Controller delete, Requirement ({})", rqr);

		boolean esito = requirementService.deleteRequirementEntity(rqr);

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

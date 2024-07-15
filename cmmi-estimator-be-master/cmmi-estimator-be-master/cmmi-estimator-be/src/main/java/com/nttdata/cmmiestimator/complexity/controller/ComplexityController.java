package com.nttdata.cmmiestimator.complexity.controller;

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
import com.nttdata.cmmiestimator.complexity.logic.ComplexityService;
import com.nttdata.cmmiestimator.complexity.to.ComplexityCto;
import com.nttdata.cmmiestimator.complexity.to.ComplexityEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/complexity")
public class ComplexityController {

	public static final Logger logger = LoggerFactory.getLogger(ComplexityController.class);

	@Autowired
	private ComplexityService complexityService;

	/**
	 * I commenti inseriti in questo Controller sono attuabili anche negl'altri
	 * poichè la struttura dei metodi è pressochè identica.
	 */

	/**
	 * Ricerca tutti gli elementi e ritorna un ResponseEntity
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ComplexityCto>> findByComplexity() {

		logger.info("Sono nel Controller findAll, complexity ({})");

		/**
		 * Richiamo del metodo getComplexity().
		 */
		List<ComplexityCto> ris = complexityService.getComplexity();

		if (ris == null) {
			return new ResponseEntity<List<ComplexityCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
			/**
			 * Ritorna "500 Internal Server Error" se il valore di ritorno di
			 * getComplexity() è uguale a NULL.
			 */

		} else {
			return new ResponseEntity<List<ComplexityCto>>(ris, HttpStatus.OK);
			/**
			 * Ritorna "200 OK" se il valore di ritorno di getComplexity() è diverso da
			 * NULL.
			 */
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<ComplexityCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, complexity ({})",nome);

		ComplexityCto ris = complexityService.getNomeComplexity(nome);

		if (ris == null) {
			return new ResponseEntity<ComplexityCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ComplexityCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param cmp
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertComplexity(@RequestBody ComplexityEto cmp) {

		logger.info("Sono nel Controller save, complexity ({})", cmp);

		ComplexityEto cm = complexityService.saveComplexity(cmp);

		if (cm == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del complexity."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + cm.getId(), "Elemento Complexity salvato correttamente."),
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
	public ResponseEntity<BusinesLogicResponse> deleteComplexity(@RequestBody ComplexityEto cmp) {

		logger.info("Sono nel Controller delete, complexity ({})", cmp);

		boolean esito = complexityService.deleteComplexityEntity(cmp);

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

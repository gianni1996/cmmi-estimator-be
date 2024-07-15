package com.nttdata.cmmiestimator.estimationtype.controller;

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
import com.nttdata.cmmiestimator.estimationtype.logic.EstimationTypeService;
import com.nttdata.cmmiestimator.estimationtype.to.EstimationTypeCto;
import com.nttdata.cmmiestimator.estimationtype.to.EstimationTypeEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/estimationtype")
public class EstimationTypeController {

	public static final Logger logger = LoggerFactory.getLogger(EstimationTypeController.class);

	@Autowired
	private EstimationTypeService estimationtypeService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<EstimationTypeCto>> findByEstimationType() {

		logger.info("Sono nel Controller findAll, EstimationType ({})");

		List<EstimationTypeCto> ris = estimationtypeService.getEstimationType();

		if (ris == null) {
			return new ResponseEntity<List<EstimationTypeCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {

			return new ResponseEntity<List<EstimationTypeCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<EstimationTypeCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, EstimationType ({})", nome);

		EstimationTypeCto ris = estimationtypeService.getNomeEstimationType(nome);

		if (ris == null) {
			return new ResponseEntity<EstimationTypeCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<EstimationTypeCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param et
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertEstimationType(@RequestBody EstimationTypeEto et) {

		logger.info("Sono nel Controller save, EstimationType ({})", et);

		EstimationTypeEto ris = estimationtypeService.saveEstimationType(et);
		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del EstimationType."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento EstimationType salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param et
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteEstimationType(@RequestBody EstimationTypeEto et) {

		logger.info("Sono nel Controller delete, EstimationType ({})", et);

		boolean esito = estimationtypeService.deleteEstimationTypeEntity(et);

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

package com.nttdata.cmmiestimator.unitmeasure.controller;

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
import com.nttdata.cmmiestimator.unitmeasure.logic.UnitMeasureService;
import com.nttdata.cmmiestimator.unitmeasure.to.UnitMeasureCto;
import com.nttdata.cmmiestimator.unitmeasure.to.UnitMeasureEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/unitmeasure")
public class UnitMeasureController {

	public static final Logger logger = LoggerFactory.getLogger(UnitMeasureController.class);

	@Autowired
	private UnitMeasureService unitmeasureService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<UnitMeasureCto>> findByUnitMeasure() {

		logger.info("Sono nel Controller findAll, UnitMeasure ({})");

		List<UnitMeasureCto> ris = unitmeasureService.getUnitMeasure();

		if (ris == null) {
			return new ResponseEntity<List<UnitMeasureCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<UnitMeasureCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<UnitMeasureCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, UnitMeasure ({})", nome);

		UnitMeasureCto ris = unitmeasureService.getNomeUnitMeasure(nome);

		if (ris == null) {
			return new ResponseEntity<UnitMeasureCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<UnitMeasureCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param cmp
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertUnitMeasure(@RequestBody UnitMeasureEto unm) {

		logger.info("Sono nel Controller save,UnitMeasure ({})", unm);

		UnitMeasureEto ris = unitmeasureService.saveUnitMeasure(unm);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del UnitMeasure."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento UnitMeasuresalvato correttamente."),
					HttpStatus.OK);
		}

	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param unm
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteUnitMeasure(@RequestBody UnitMeasureEto unm) {

		logger.info("Sono nel Controller delete, UnitMeasure ({})", unm);

		boolean esito = unitmeasureService.deleteUnitMeasureEntity(unm);

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

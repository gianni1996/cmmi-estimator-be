package com.nttdata.cmmiestimator.release.controller;

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
import com.nttdata.cmmiestimator.release.logic.ReleaseService;
import com.nttdata.cmmiestimator.release.to.ReleaseCto;
import com.nttdata.cmmiestimator.release.to.ReleaseEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/release")
public class ReleaseController {

	public static final Logger logger = LoggerFactory.getLogger(ReleaseController.class);

	@Autowired
	private ReleaseService releaseService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ReleaseCto>> findByRelease() {

		logger.info("Sono nel Controller findAll, Release ({})");

		List<ReleaseCto> ris = releaseService.getRelease();

		if (ris == null) {
			return new ResponseEntity<List<ReleaseCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ReleaseCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<ReleaseCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, Release ({})", nome);

		ReleaseCto ris = releaseService.getNomeRelease(nome);

		if (ris == null) {
			return new ResponseEntity<ReleaseCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ReleaseCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param rls
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertRelease(@RequestBody ReleaseEto rls) {

		logger.info("Sono nel Controller save, Release ({})", rls);

		ReleaseEto ris = releaseService.saveRelease(rls);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del Release."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento Release salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param rls
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteRelease(@RequestBody ReleaseEto rls) {

		logger.info("Sono nel Controller delete, Release ({})", rls);

		boolean esito = releaseService.deleteReleaseEntity(rls);

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

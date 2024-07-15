package com.nttdata.cmmiestimator.confskillmix.controller;

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
import com.nttdata.cmmiestimator.confskillmix.logic.ConfSkillMixService;
import com.nttdata.cmmiestimator.confskillmix.to.ConfSkillMixCto;
import com.nttdata.cmmiestimator.confskillmix.to.ConfSkillMixEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/confskillmix")
public class ConfSkillMixController {

	public static final Logger logger = LoggerFactory.getLogger(ConfSkillMixController.class);

	@Autowired
	private ConfSkillMixService confskillmixService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ConfSkillMixCto>> findByConfSkillMix() {

		logger.info("Sono nel Controller findAll, ConfSkillMix ({})");

		List<ConfSkillMixCto> ris = confskillmixService.getConfSkillMix();

		if (ris == null) {
			return new ResponseEntity<List<ConfSkillMixCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ConfSkillMixCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato sul profilo
	 * 
	 * @param profilo
	 * @return
	 */

	@GetMapping("/search/{profilo}")
	public ResponseEntity<ConfSkillMixCto> findByProfilo(@PathVariable String profilo) {

		logger.info("Sono nel Controller findByProfilo, ConfSkillMix ({})", profilo);

		ConfSkillMixCto ris = confskillmixService.getProfiloConfSkillMix(profilo);

		if (ris == null) {
			return new ResponseEntity<ConfSkillMixCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ConfSkillMixCto>(ris, HttpStatus.OK);
		}
	}
	
	/**
	 * Ricerca basata sulla chiave esterna costitem
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/searchcostitem/{id}")
	public ResponseEntity<List<ConfSkillMixCto>> findByCostitem(@PathVariable Long id) {

		logger.info("Sono nel Controller findByProfilo, ConfSkillMix ({})", id);

		List<ConfSkillMixCto> ris = confskillmixService.getCostitemConfSkillMix(id);

		if (ris == null) {
			return new ResponseEntity<List<ConfSkillMixCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ConfSkillMixCto>>(ris, HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param csm
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertConfSkillMix(@RequestBody ConfSkillMixCto csm) {

		logger.info("Sono nel Controller save, ConfSkillMix ({})", csm);

		ConfSkillMixEto ris = confskillmixService.saveConfSkillMix(csm);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del ConfSkillMix."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento ConfSkillMix salvato correttamente."),
					HttpStatus.OK);
		}

	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param csm
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteConfSkillMix(@RequestBody ConfSkillMixCto csm) {

		logger.info("Sono nel Controller delete, ConfSkillMix ({})", csm);

		boolean esito = confskillmixService.deleteConfSkillMixEntity(csm);

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

package com.nttdata.cmmiestimator.projecttechnology.controller;

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
import com.nttdata.cmmiestimator.projecttechnology.logic.ProjectTechnologyService;
import com.nttdata.cmmiestimator.projecttechnology.to.ProjectTechnologyCto;
import com.nttdata.cmmiestimator.projecttechnology.to.ProjectTechnologyEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/projecttechnology")
public class ProjectTechnologyController {

	public static final Logger logger = LoggerFactory.getLogger(ProjectTechnologyController.class);

	@Autowired
	private ProjectTechnologyService projecttechnologyService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ProjectTechnologyCto>> findByProjectTechnology() {

		logger.info("Sono nel Controller findAll, ProjectTechnology ({})");

		List<ProjectTechnologyCto> ris = projecttechnologyService.getProjectTechnology();

		if (ris == null) {
			return new ResponseEntity<List<ProjectTechnologyCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ProjectTechnologyCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<ProjectTechnologyCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, ProjectTechnology ({})", nome);

		ProjectTechnologyCto ris = projecttechnologyService.getNomeProjectTechnology(nome);

		if (ris == null) {
			return new ResponseEntity<ProjectTechnologyCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ProjectTechnologyCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param prt
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertProjectTechnology(@RequestBody ProjectTechnologyEto prt) {

		logger.info("Sono nel Controller save, ProjectTechnology ({})", prt);

		ProjectTechnologyEto ris = projecttechnologyService.saveProjectTechnology(prt);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del projecttechnology."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento ProjectTechnology salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param prt
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteProjectTechnology(@RequestBody ProjectTechnologyEto prt) {

		logger.info("Sono nel Controller delete, ProjectTechnology({})", prt);

		boolean esito = projecttechnologyService.deleteProjectTechnologyEntity(prt);

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

package com.nttdata.cmmiestimator.projectscope.controller;

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
import com.nttdata.cmmiestimator.projectscope.logic.ProjectScopeService;
import com.nttdata.cmmiestimator.projectscope.to.ProjectScopeCto;
import com.nttdata.cmmiestimator.projectscope.to.ProjectScopeEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/projectscope")
public class ProjectScopeController {

	public static final Logger logger = LoggerFactory.getLogger(ProjectScopeController.class);

	@Autowired
	private ProjectScopeService projectscopeService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ProjectScopeCto>> findByProjectScope() {

		logger.info("Sono nel Controller findAll, projectscope ({})");

		List<ProjectScopeCto> ris = projectscopeService.getProjectScope();

		if (ris == null) {
			return new ResponseEntity<List<ProjectScopeCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ProjectScopeCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su nome
	 * 
	 * @param nome
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<ProjectScopeCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, projectscope ({})", nome);

		ProjectScopeCto ris = projectscopeService.getNomeProjectScope(nome);

		if (ris == null) {
			return new ResponseEntity<ProjectScopeCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ProjectScopeCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param prs
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertProjectScope(@RequestBody ProjectScopeEto prs) {

		logger.info("Sono nel Controller save, ProjectScope ({})", prs);

		ProjectScopeEto ris = projectscopeService.saveProjectScope(prs);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del ProjectScope."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento ProjectScope salvato correttamente."),
					HttpStatus.OK);
		}
	}

	/**
	 * Metodo per eliminare
	 * 
	 * @param prs
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BusinesLogicResponse> deleteProjectScope(@RequestBody ProjectScopeEto prs) {

		logger.info("Sono nel Controller delete,  ProjectScope ({})", prs);

		boolean esito = projectscopeService.deleteProjectScopeEntity(prs);

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

package com.nttdata.cmmiestimator.projecttype.controller;

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
import com.nttdata.cmmiestimator.projecttype.logic.ProjectTypeService;
import com.nttdata.cmmiestimator.projecttype.to.ProjectTypeCto;
import com.nttdata.cmmiestimator.projecttype.to.ProjectTypeEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@RestController
@RequestMapping("/projecttype")
public class ProjectTypeController {

	public static final Logger logger = LoggerFactory.getLogger(ProjectTypeController.class);

	@Autowired
	private ProjectTypeService projecttypeService;

	/**
	 * Ricerca tutti gli elementi
	 * 
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<List<ProjectTypeCto>> findByProjectType() {

		logger.info("Sono nel Controller findAll, ProjectType ({})");

		List<ProjectTypeCto> ris = projecttypeService.getProjectType();

		if (ris == null) {
			return new ResponseEntity<List<ProjectTypeCto>>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<List<ProjectTypeCto>>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Ricerca elementi basato su id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/search/{nome}")
	public ResponseEntity<ProjectTypeCto> findByNome(@PathVariable String nome) {

		logger.info("Sono nel Controller findByNome, ProjectType ({})", nome);

		ProjectTypeCto ris = projecttypeService.getNomeProjectType(nome);

		if (ris == null) {
			return new ResponseEntity<ProjectTypeCto>(ris, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<ProjectTypeCto>(ris, HttpStatus.OK);
		}
	}

	/**
	 * Metodo per inserire e aggiornare
	 * 
	 * @param prt
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<BusinesLogicResponse> insertProjectType(@RequestBody ProjectTypeEto prt) {

		logger.info("Sono nel Controller save, projecttype ({})", prt);

		ProjectTypeEto ris = projecttypeService.saveProjectType(prt);

		if (ris == null) {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("KO", "Errore Durante il salvataggio del ProjectType."),
					HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<BusinesLogicResponse>(
					new BusinesLogicResponse("ID= " + ris.getId(), "Elemento ProjectType salvato correttamente."),
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
	public ResponseEntity<BusinesLogicResponse> deleteProjectType(@RequestBody ProjectTypeEto prt) {

		logger.info("Sono nel Controller delete, projecttype ({})", prt);

		boolean esito = projecttypeService.deleteProjectTypeEntity(prt);

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

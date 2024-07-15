package com.nttdata.cmmiestimator.complexity.logic;

import java.lang.reflect.Type;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.cmmiestimator.complexity.model.ComplexityEntity;
import com.nttdata.cmmiestimator.complexity.repository.ComplexityRepository;
import com.nttdata.cmmiestimator.complexity.to.ComplexityCto;
import com.nttdata.cmmiestimator.complexity.to.ComplexityEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Service
@Transactional
public class ComplexityService {

	public static final Logger logger = LoggerFactory.getLogger(ComplexityService.class);

	@Autowired
	private ComplexityRepository complexityRepository;

	private Type listComplexityCto = new TypeToken<List<ComplexityCto>>() {
	}.getType();

	/**
	 * I commenti inseriti in questo Service sono attuabili anche negl'altri poichè
	 * la struttura dei metodi è pressochè identica.
	 */

	/**
	 * Il metodo richiama getComplexity() richiama il metodo findall() residente nel
	 * Repository (ComplexityRepository). Restituisce una lista di "ComplexityCto"
	 * se "tutto va bene" o null se si verifica qualche problema.
	 * 
	 * @return
	 */
	public List<ComplexityCto> getComplexity() {

		/**
		 * L' oggetto Logger viene utilizzato per registrare i messaggi per un sistema
		 * specifico o un componente dell'applicazione.
		 */
		logger.info("findAll Complexity.");

		List<ComplexityCto> complexity;

		ModelMapper mapper = new ModelMapper();

		/**
		 * Richiamo del metodo findAll().
		 */
		List<ComplexityEntity> ris = complexityRepository.findAll();

		/**
		 * Gestione delle eccezioni.
		 */
		try {
			/**
			 * Quando il metodo map viene chiamato, i tipi di origine (source) e di
			 * destinazione (destination) vengono analizzati per determinare quali proprietà
			 * corrispondono implicitamente in base a una strategia di corrispondenza e ad
			 * altre configurazioni . I dati vengono quindi mappati in base a queste
			 * corrispondenze.
			 */
			complexity = mapper.map(ris, listComplexityCto);

			/**
			 * INFO message: le informazioni sono per l'uso di amministratori o utenti
			 * avanzati. Indica principalmente le azioni che hanno portato a un cambiamento
			 * di stato per l'applicazione.
			 */
			logger.info("Complexity mostrata correttamente ({})", complexity);

		} catch (Exception e) {

			/**
			 * La Logging Java errors è un componente essenziale che ci consente di
			 * tracciare la causa principale degli errori. Per impostazione predefinita, i
			 * messaggi di registro Java vengono archiviati solo sulla console.
			 */
			logger.error("Errore durante il caricamento del complexity, ({})", e.getMessage());
			complexity = null;
		}

		return complexity;
	}

	/**
	 * Il metodo richiama getNomeComplexity() richiama il metodo findByNome() residente
	 * nel Repository (ComplexityRepository). Restituisce un oggetto "ComplexityCto"
	 * se "tutto va bene" o null se si verifica qualche problema.
	 * 
	 * @param id
	 * @return
	 */
	public ComplexityCto getNomeComplexity(String nome) {

		logger.info("findByNome Complexity.");

		ComplexityCto complexity;

		ModelMapper mapper = new ModelMapper();

		ComplexityEntity ris = complexityRepository.findByNome(nome);

		try {
			complexity = mapper.map(ris, ComplexityCto.class);
			logger.info("Complexity mostrata correttamente ({})", complexity);
		} catch (Exception e) {
			logger.error("Errore durante il caricamento del complexity, ({})", e.getMessage());
			complexity = null;
		}

		return complexity;
	}

	/**
	 * Il metodo richiama getNomeComplexity() richiama il metodo save() residente nel
	 * Repository (ComplexityRepository). Restituisce un oggetto "ComplexityEto" se
	 * "tutto va bene" o null se si verifica qualche problema.
	 * 
	 * @param cmp
	 * @return
	 */
	public ComplexityEto saveComplexity(ComplexityEto cmp) {

		logger.info("save Complexity.");

		ComplexityEto complexity;

		ModelMapper mapper = new ModelMapper();

		try {
			complexity = mapper.map(complexityRepository.save(mapper.map(cmp, ComplexityEntity.class)),
					ComplexityEto.class);
			logger.info("Complexity salvata correttamente ({})", complexity);
		} catch (Exception e) {
			logger.error("Errore durante il salvataggio del Complexity, ({})", e.getMessage());
			complexity = null;
		}

		return complexity;
	}

	/**
	 * Il metodo richiama deleteComplexityEntity() richiama il metodo delete()
	 * residente nel Repository (ComplexityRepository). Restituisce TRUE (un
	 * booleano) se "tutto va bene" o FALSE se si verifica qualche problema.
	 * 
	 * @param cmp
	 * @return
	 */
	public boolean deleteComplexityEntity(ComplexityEto cmp) {

		logger.info("delete Complexity.");

		boolean result = false;

		ModelMapper mapper = new ModelMapper();

		try {
			complexityRepository.delete(mapper.map(cmp, ComplexityEntity.class));
			result = true;
			logger.info("Elemento Complexity eliminato correttamente ({})", result);
		} catch (Exception e) {
			logger.error("Errore durante l'eliminazione dell'elemento nel Complexity, ({})", e.getMessage());
		}

		return result;
	}

}

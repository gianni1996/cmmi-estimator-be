package com.nttdata.cmmiestimator.complexity.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.cmmiestimator.complexity.model.ComplexityEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Repository
public interface ComplexityRepository extends CrudRepository<ComplexityEntity, Integer> {

	/**
	 * I commenti inseriti in questo Repository sono attuabili anche negl'altri
	 * poichè la struttura dei metodi è pressochè identica.
	 */

	/**
	 * Ritorna tutte le righe della tabella Complexity.
	 * 
	 * @param
	 * @return
	 */
	List<ComplexityEntity> findAll();

	/**
	 * Ritorna la singola riga con un determinato id della tabella Complexity.
	 * 
	 * @param id
	 * @return
	 */
	ComplexityEntity findByNome(String nome);

	/**
	 * Inserisce (INSERT) o aggiorna (UPDATE) una determinata riga della tabella
	 * Complexity.
	 * 
	 * @param cmp
	 * @return
	 */
	ComplexityEntity save(ComplexityEntity cmp);

	/**
	 * Elimina (DELETE) una determinata riga della tabella Complexity.
	 * 
	 * @param cmp
	 * @return
	 */
	void delete(ComplexityEntity cmp);
}

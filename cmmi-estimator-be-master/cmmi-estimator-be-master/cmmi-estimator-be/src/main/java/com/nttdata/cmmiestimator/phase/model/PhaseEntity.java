package com.nttdata.cmmiestimator.phase.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "phase")
public class PhaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phase_generator")
	@SequenceGenerator(name = "phase_generator", sequenceName = "seq_phase", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotEmpty(message = "Name may not be empty")
	private String nome;

	@OneToMany(mappedBy = "phase")
	private List<StimaItemEntity> items;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<StimaItemEntity> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEntity> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "PhaseEntity [id=" + id + ", nome=" + nome + ", items=" + items + "]";
	}

}

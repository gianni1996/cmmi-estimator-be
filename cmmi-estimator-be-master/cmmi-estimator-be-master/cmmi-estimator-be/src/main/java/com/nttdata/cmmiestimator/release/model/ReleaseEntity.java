package com.nttdata.cmmiestimator.release.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "release")
public class ReleaseEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "release_generator")
	@SequenceGenerator(name = "release_generator", sequenceName = "seq_release", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@OneToMany(mappedBy = "release")
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

}

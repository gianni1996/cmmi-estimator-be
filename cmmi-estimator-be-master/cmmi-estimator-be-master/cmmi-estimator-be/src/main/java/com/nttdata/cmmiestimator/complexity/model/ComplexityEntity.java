package com.nttdata.cmmiestimator.complexity.model;

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

import com.nttdata.cmmiestimator.confworkitems.model.ConfWorkItemsEntity;
import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "complexity")
public class ComplexityEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "complexity_generator")
	@SequenceGenerator(name = "complexity_generator", sequenceName = "seq_complexity", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotEmpty(message = "Name may not be empty")
	private String nome;

	@OneToMany(mappedBy = "complexity")
	private List<StimaItemEntity> items;

	@OneToMany(mappedBy = "complexity")
	private List<ConfWorkItemsEntity> confworkitems;

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

	public List<ConfWorkItemsEntity> getConfworkitems() {
		return confworkitems;
	}

	public void setConfworkitems(List<ConfWorkItemsEntity> confworkitems) {
		this.confworkitems = confworkitems;
	}

}

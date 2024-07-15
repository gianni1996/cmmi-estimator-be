package com.nttdata.cmmiestimator.workitem.model;

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
@Table(name = "work_item")
public class WorkItemEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workitem_generator")
	@SequenceGenerator(name = "workitem_generator", sequenceName = "seq_work_item", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotEmpty(message = "Name may not be empty")
	private String nome;

	@OneToMany(mappedBy = "workitem")
	private List<ConfWorkItemsEntity> confworkitems;

	@OneToMany(mappedBy = "workitem")
	private List<StimaItemEntity> stime;

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

	public List<ConfWorkItemsEntity> getConfworkitems() {
		return confworkitems;
	}

	public void setConfworkitems(List<ConfWorkItemsEntity> confworkitems) {
		this.confworkitems = confworkitems;
	}

	public List<StimaItemEntity> getStime() {
		return stime;
	}

	public void setStime(List<StimaItemEntity> stime) {
		this.stime = stime;
	}

}

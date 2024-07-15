package com.nttdata.cmmiestimator.unitmeasure.model;

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
import com.nttdata.cmmiestimator.stima.model.StimaEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "unit_measure")
public class UnitMeasureEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unitmeasure_generator")
	@SequenceGenerator(name = "unitmeasure_generator", sequenceName = "seq_unit_measure", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotEmpty(message = "Name may not be empty")
	private String nome;

	@OneToMany(mappedBy = "unitmeasure")
	private List<ConfWorkItemsEntity> confworkintems;

	@OneToMany(mappedBy = "unitmeasure")
	private List<StimaEntity> stime;

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

	public List<ConfWorkItemsEntity> getConfworkintems() {
		return confworkintems;
	}

	public void setConfworkintems(List<ConfWorkItemsEntity> confworkintems) {
		this.confworkintems = confworkintems;
	}

	public List<StimaEntity> getStime() {
		return stime;
	}

	public void setStime(List<StimaEntity> stime) {
		this.stime = stime;
	}

}

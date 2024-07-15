package com.nttdata.cmmiestimator.projecttechnology.model;

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

import com.nttdata.cmmiestimator.stima.model.StimaEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "project_technology")
public class ProjectTechnologyEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projecttechnology_generator")
	@SequenceGenerator(name = "projecttechnology_generator", sequenceName = "seq_project_technology", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotEmpty(message = "Name may not be empty")
	private String nome;

	@OneToMany(mappedBy = "projecttechnology")
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

	public List<StimaEntity> getStime() {
		return stime;
	}

	public void setStime(List<StimaEntity> stime) {
		this.stime = stime;
	}

}

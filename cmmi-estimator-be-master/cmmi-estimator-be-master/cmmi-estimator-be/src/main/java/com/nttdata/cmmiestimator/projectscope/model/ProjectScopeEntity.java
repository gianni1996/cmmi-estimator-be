package com.nttdata.cmmiestimator.projectscope.model;

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

import com.nttdata.cmmiestimator.stima.model.StimaEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "project_scope")
public class ProjectScopeEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projectscope_generator")
	@SequenceGenerator(name = "projectscope_generator", sequenceName = "seq_project_scope", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@OneToMany(mappedBy = "projectscope")
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

	@Override
	public String toString() {
		return "ProjectScopeEntity [id=" + id + ", nome=" + nome + ", stime=" + stime + "]";
	}

}

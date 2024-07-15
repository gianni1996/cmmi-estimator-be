package com.nttdata.cmmiestimator.costitem.model;

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
import javax.validation.constraints.NotNull;

import com.nttdata.cmmiestimator.confskillmix.model.ConfSkillMixEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "cost_item")
public class CostItemEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costitem_generator")
	@SequenceGenerator(name = "costitem_generator", sequenceName = "seq_cost_item", allocationSize = 1)
	private Long id;

	@Column(name = "nome")
	@NotEmpty(message = "Name may not be empty")
	private String nome;

	@OneToMany(mappedBy = "costitem")
	private List<ConfSkillMixEntity> confskillmix;

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

	public List<ConfSkillMixEntity> getConfskillmix() {
		return confskillmix;
	}

	public void setConfskillmix(List<ConfSkillMixEntity> confskillmix) {
		this.confskillmix = confskillmix;
	}

	@Override
	public String toString() {
		return "CostItemEntity [id=" + id + ", nome=" + nome + ", confskillmix=" + confskillmix + "]";
	}

}

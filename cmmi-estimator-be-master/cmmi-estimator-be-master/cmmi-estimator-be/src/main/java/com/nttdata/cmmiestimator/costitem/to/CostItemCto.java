package com.nttdata.cmmiestimator.costitem.to;

import java.util.List;

import com.nttdata.cmmiestimator.confskillmix.to.ConfSkillMixEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class CostItemCto {

	private Long id;

	private String nome;

	private List<ConfSkillMixEto> confskillmix;

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

	public List<ConfSkillMixEto> getConfskillmix() {
		return confskillmix;
	}

	public void setConfskillmix(List<ConfSkillMixEto> confskillmix) {
		this.confskillmix = confskillmix;
	}

	@Override
	public String toString() {
		return "CostItemCto [id=" + id + ", nome=" + nome + ", confskillmix=" + confskillmix + "]";
	}

}

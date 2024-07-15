package com.nttdata.cmmiestimator.requirement.to;

import java.util.List;

import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class RequirementCto {

	private Long id;

	private String nome;

	private List<StimaItemEto> items;

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

	public List<StimaItemEto> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEto> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "RequirementCto [id=" + id + ", nome=" + nome + ", items=" + items + "]";
	}

}

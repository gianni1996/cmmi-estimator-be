package com.nttdata.cmmiestimator.complexity.to;

import java.util.List;

import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsEto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */

public class ComplexityCto {

	private Long id;

	private String nome;

	private List<StimaItemEto> items;

	private List<ConfWorkItemsEto> confworkitems;

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

	public List<ConfWorkItemsEto> getConfworkitems() {
		return confworkitems;
	}

	public void setConfworkitems(List<ConfWorkItemsEto> confworkitems) {
		this.confworkitems = confworkitems;
	}

	@Override
	public String toString() {
		return "ComplexityCto [id=" + id + ", nome=" + nome + "]";
	}

}

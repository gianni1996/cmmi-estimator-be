package com.nttdata.cmmiestimator.workitem.to;

import java.util.List;

import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsEto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class WorkItemCto {

	private Long id;

	private String nome;

	private List<ConfWorkItemsEto> confworkitems;

	private List<StimaItemEto> stime;

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

	public List<ConfWorkItemsEto> getConfworkitems() {
		return confworkitems;
	}

	public void setConfworkitems(List<ConfWorkItemsEto> confworkitems) {
		this.confworkitems = confworkitems;
	}

	public List<StimaItemEto> getStime() {
		return stime;
	}

	public void setStime(List<StimaItemEto> stime) {
		this.stime = stime;
	}

	@Override
	public String toString() {
		return "WorkItemCto [id=" + id + ", nome=" + nome + ", confworkitems=" + confworkitems + ", stime=" + stime
				+ "]";
	}

}

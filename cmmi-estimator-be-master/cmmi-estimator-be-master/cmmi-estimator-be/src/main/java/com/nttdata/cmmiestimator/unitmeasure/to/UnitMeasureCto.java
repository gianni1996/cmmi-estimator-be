package com.nttdata.cmmiestimator.unitmeasure.to;

import java.util.List;

import com.nttdata.cmmiestimator.confworkitems.to.ConfWorkItemsEto;
import com.nttdata.cmmiestimator.stima.to.StimaEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class UnitMeasureCto {

	private Long id;

	private String nome;

	private List<ConfWorkItemsEto> confworkintems;

	private List<StimaEto> stime;

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

	public List<ConfWorkItemsEto> getConfworkintems() {
		return confworkintems;
	}

	public void setConfworkintems(List<ConfWorkItemsEto> confworkintems) {
		this.confworkintems = confworkintems;
	}

	public List<StimaEto> getStime() {
		return stime;
	}

	public void setStime(List<StimaEto> stime) {
		this.stime = stime;
	}

	@Override
	public String toString() {
		return "UnitMeasureCto [id=" + id + ", nome=" + nome + ", confworkintems=" + confworkintems + ", stime=" + stime
				+ "]";
	}

}

package com.nttdata.cmmiestimator.projecttype.to;

import java.util.List;

import com.nttdata.cmmiestimator.stima.to.StimaEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class ProjectTypeCto {

	private Long id;

	private String nome;

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

	public List<StimaEto> getStime() {
		return stime;
	}

	public void setStime(List<StimaEto> stime) {
		this.stime = stime;
	}

	@Override
	public String toString() {
		return "ProjectTypeCto [id=" + id + ", nome=" + nome + ", stime=" + stime + "]";
	}

}

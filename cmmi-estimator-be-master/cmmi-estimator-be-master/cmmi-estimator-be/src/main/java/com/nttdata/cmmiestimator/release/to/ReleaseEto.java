package com.nttdata.cmmiestimator.release.to;

/**
 * 
 * @author BuonocoreGi
 *
 */

public class ReleaseEto {

	private Long id;

	private String nome;

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

	@Override
	public String toString() {
		return "ReleaseEto [id=" + id + ", nome=" + nome + "]";
	}

}

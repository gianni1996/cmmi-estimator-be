package com.nttdata.cmmiestimator.complexity.to;

/**
 * 
 * @author BuonocoreGi
 *
 */

public class ComplexityEto {

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
		return "ComplexityEto [id=" + id + ", nome=" + nome + "]";
	}

}
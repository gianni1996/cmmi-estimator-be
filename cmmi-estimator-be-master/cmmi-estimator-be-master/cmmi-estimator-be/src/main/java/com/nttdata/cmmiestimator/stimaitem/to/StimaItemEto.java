package com.nttdata.cmmiestimator.stimaitem.to;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class StimaItemEto {

	private Long id;

	private String descrizione;

	private String assunzioni;

	public Long getId() {
		return id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAssunzioni() {
		return assunzioni;
	}

	public void setAssunzioni(String assunzioni) {
		this.assunzioni = assunzioni;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "StimaItemEto [id=" + id + ", descrizione=" + descrizione + ", assunzioni=" + assunzioni + "]";
	}

}

package com.nttdata.cmmiestimator.stima.to;

import java.time.LocalDate;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class StimaEto {

	private Long id;

	private String nomeprogetto;

	private String wbs;

	private String descrizione;

	private LocalDate datainizio;

	private LocalDate datafine;

	private String ownerstima;

	private Float contingency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeprogetto() {
		return nomeprogetto;
	}

	public void setNomeprogetto(String nomeprogetto) {
		this.nomeprogetto = nomeprogetto;
	}

	public String getWbs() {
		return wbs;
	}

	public void setWbs(String wbs) {
		this.wbs = wbs;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDatainizio() {
		return datainizio;
	}

	public void setDatainizio(LocalDate datainizio) {
		this.datainizio = datainizio;
	}

	public LocalDate getDatafine() {
		return datafine;
	}

	public void setDatafine(LocalDate datafine) {
		this.datafine = datafine;
	}

	public String getOwnerstima() {
		return ownerstima;
	}

	public void setOwnerstima(String ownerstima) {
		this.ownerstima = ownerstima;
	}

	public Float getContingency() {
		return contingency;
	}

	public void setContingency(Float contingency) {
		this.contingency = contingency;
	}

	@Override
	public String toString() {
		return "StimaEto [id=" + id + ", nomeprogetto=" + nomeprogetto + ", wbs=" + wbs + ", descrizione=" + descrizione
				+ ", datainizio=" + datainizio + ", datafine=" + datafine + ", ownerstima=" + ownerstima
				+ ", contingency=" + contingency + "]";
	}

}
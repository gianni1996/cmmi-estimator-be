package com.nttdata.cmmiestimator.confskillmix.to;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class ConfSkillMixEto {

	private Long id;

	private String profilo;

	private float allocazione;

	private Long costogiornaliero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProfilo() {
		return profilo;
	}

	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}

	public float getAllocazione() {
		return allocazione;
	}

	public void setAllocazione(float allocazione) {
		this.allocazione = allocazione;
	}

	public Long getCostogiornaliero() {
		return costogiornaliero;
	}

	public void setCostogiornaliero(Long costogiornaliero) {
		this.costogiornaliero = costogiornaliero;
	}

	@Override
	public String toString() {
		return "ConfSkillMixEto [id=" + id + ", profilo=" + profilo + ", allocazione=" + allocazione
				+ ", costogiornaliero=" + costogiornaliero + "]";
	}

}

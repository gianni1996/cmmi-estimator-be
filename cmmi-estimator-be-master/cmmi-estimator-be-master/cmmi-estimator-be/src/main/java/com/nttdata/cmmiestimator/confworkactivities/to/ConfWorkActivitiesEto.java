
package com.nttdata.cmmiestimator.confworkactivities.to;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class ConfWorkActivitiesEto {

	private Long id;

	private String attivita;

	private float effort;

	private float valoripred;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAttivita() {
		return attivita;
	}

	public void setAttivita(String attivita) {
		this.attivita = attivita;
	}

	public float getEffort() {
		return effort;
	}

	public void setEffort(float effort) {
		this.effort = effort;
	}

	public float getValoripred() {
		return valoripred;
	}

	public void setValoripred(float valoripred) {
		this.valoripred = valoripred;
	}

	@Override
	public String toString() {
		return "ConfWorkActivitiesEto [id=" + id + ", attivita=" + attivita + ", effort=" + effort + ", valoripred="
				+ valoripred + "]";
	}

}

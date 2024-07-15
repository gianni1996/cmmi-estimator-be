package com.nttdata.cmmiestimator.confworkactivities.to;

import java.util.List;

import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */

public class ConfWorkActivitiesCto {

	private Long id;

	private String attivita;

	private float effort = 0;

	private float valoripred = 0;

	private List<StimaItemEto> items;

	

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

	public List<StimaItemEto> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEto> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ConfWorkActivitiesCto [id=" + id + ", attivita=" + attivita + ", effort=" + effort + ", valoripred="
				+ valoripred + ", items=" + items + "]";
	}

}

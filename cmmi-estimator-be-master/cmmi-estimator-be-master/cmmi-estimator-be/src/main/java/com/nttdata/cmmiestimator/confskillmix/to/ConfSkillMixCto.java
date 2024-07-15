package com.nttdata.cmmiestimator.confskillmix.to;

import java.util.List;

import com.nttdata.cmmiestimator.costitem.to.CostItemEto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class ConfSkillMixCto {

	private Long id;

	private String profilo;

	private Float allocazione;

	private Long costogiornaliero;

	private CostItemEto costitem;

	private List<StimaItemEto> items;

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

	public Float getAllocazione() {
		return allocazione;
	}

	public void setAllocazione(Float allocazione) {
		this.allocazione = allocazione;
	}

	public Long getCostogiornaliero() {
		return costogiornaliero;
	}

	public void setCostogiornaliero(Long costogiornaliero) {
		this.costogiornaliero = costogiornaliero;
	}

	public CostItemEto getCostitem() {
		return costitem;
	}

	public void setCostitem(CostItemEto costitem) {
		this.costitem = costitem;
	}

	public List<StimaItemEto> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEto> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ConfSkillMixCto [id=" + id + ", profilo=" + profilo + ", allocazione=" + allocazione
				+ ", costogiornaliero=" + costogiornaliero + ", costitem=" + costitem + ", items=" + items + "]";
	}

}

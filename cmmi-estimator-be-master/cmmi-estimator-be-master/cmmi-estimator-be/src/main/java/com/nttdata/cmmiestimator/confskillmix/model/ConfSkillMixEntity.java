package com.nttdata.cmmiestimator.confskillmix.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nttdata.cmmiestimator.costitem.model.CostItemEntity;
import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "conf_skillmix")
public class ConfSkillMixEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confskillmix_generator")
	@SequenceGenerator(name = "confskillmix_generator", sequenceName = "seq_conf_skillmix", allocationSize = 1)
	private Long id;

	@Column(name = "profilo")
	private String profilo;

	@Column(name = "allocazione")
	private float allocazione = 0;

	@Column(name = "costo_giornaliero")
	private long costogiornaliero = 0;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cost_item")
	private CostItemEntity costitem;

	@OneToMany(mappedBy = "confskillmix")
	private List<StimaItemEntity> items;

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

	public long getCostogiornaliero() {
		return costogiornaliero;
	}

	public void setCostogiornaliero(long costogiornaliero) {
		this.costogiornaliero = costogiornaliero;
	}

	public CostItemEntity getCostitem() {
		return costitem;
	}

	public void setCostitem(CostItemEntity costitem) {
		this.costitem = costitem;
	}

	public List<StimaItemEntity> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEntity> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ConfSkillMixEntity [id=" + id + ", profilo=" + profilo + ", allocazione=" + allocazione
				+ ", costogiornaliero=" + costogiornaliero + "]";
	}

}

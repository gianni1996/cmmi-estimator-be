package com.nttdata.cmmiestimator.confworkitems.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.nttdata.cmmiestimator.complexity.model.ComplexityEntity;
import com.nttdata.cmmiestimator.unitmeasure.model.UnitMeasureEntity;
import com.nttdata.cmmiestimator.workitem.model.WorkItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "conf_workitems")
public class ConfWorkItemsEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confworkitems_generator")
	@SequenceGenerator(name = "confworkitems_generator", sequenceName = "seq_conf_workitems", allocationSize = 1)
	private Long id;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_work_item")
	private WorkItemEntity workitem;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_complexity")
	private ComplexityEntity complexity;

	@NotNull
	@Column(name = "effort_uni_sviluppo")
	private float effortUniSviluppo;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unit_measure")
	private UnitMeasureEntity unitmeasure;

	@Column(name = "note")
	private String note;

	@Column(name = "registro_agg_variazioni")
	private Long registroAggVariazioni;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getEffortUniSviluppo() {
		return effortUniSviluppo;
	}

	public void setEffortUniSviluppo(float effortUniSviluppo) {
		this.effortUniSviluppo = effortUniSviluppo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getRegistroAggVariazioni() {
		return registroAggVariazioni;
	}

	public void setRegistroAggVariazioni(Long registroAggVariazioni) {
		this.registroAggVariazioni = registroAggVariazioni;
	}

	public WorkItemEntity getWorkitem() {
		return workitem;
	}

	public void setWorkitem(WorkItemEntity workitem) {
		this.workitem = workitem;
	}

	public UnitMeasureEntity getUnitmeasure() {
		return unitmeasure;
	}

	public void setUnitmeasure(UnitMeasureEntity unitmeasure) {
		this.unitmeasure = unitmeasure;
	}

	public ComplexityEntity getComplexity() {
		return complexity;
	}

	public void setComplexity(ComplexityEntity complexity) {
		this.complexity = complexity;
	}

}

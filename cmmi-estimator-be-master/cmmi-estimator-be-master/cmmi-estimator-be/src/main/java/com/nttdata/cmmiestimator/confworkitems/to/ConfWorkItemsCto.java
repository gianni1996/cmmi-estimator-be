package com.nttdata.cmmiestimator.confworkitems.to;

import com.nttdata.cmmiestimator.complexity.to.ComplexityEto;
import com.nttdata.cmmiestimator.unitmeasure.to.UnitMeasureEto;
import com.nttdata.cmmiestimator.workitem.to.WorkItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class ConfWorkItemsCto {

	private Long id;
	
	private WorkItemEto workitem;
	
	private ComplexityEto complexity;

	private float effortUniSviluppo;
	
	private UnitMeasureEto unitmeasure;

	private String note;

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

	public WorkItemEto getWorkitem() {
		return workitem;
	}

	public void setWorkitem(WorkItemEto workitem) {
		this.workitem = workitem;
	}

	public UnitMeasureEto getUnitmeasure() {
		return unitmeasure;
	}

	public void setUnitmeasure(UnitMeasureEto unitmeasure) {
		this.unitmeasure = unitmeasure;
	}

	public ComplexityEto getComplexity() {
		return complexity;
	}

	public void setComplexity(ComplexityEto complexity) {
		this.complexity = complexity;
	}

}

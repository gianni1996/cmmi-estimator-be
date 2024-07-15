package com.nttdata.cmmiestimator.stima.to;

import java.time.LocalDate;
import java.util.List;

import com.nttdata.cmmiestimator.estimationtype.to.EstimationTypeEto;
import com.nttdata.cmmiestimator.projectscope.to.ProjectScopeEto;
import com.nttdata.cmmiestimator.projecttechnology.to.ProjectTechnologyEto;
import com.nttdata.cmmiestimator.projecttype.to.ProjectTypeEto;
import com.nttdata.cmmiestimator.stimaitem.to.StimaItemEto;
import com.nttdata.cmmiestimator.unitmeasure.to.UnitMeasureEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class StimaCto {

	private Long id;

	private String nomeprogetto;

	private String wbs;

	private String descrizione;

	private LocalDate datainizio;

	private LocalDate datafine;

	private String ownerstima;

	private float contingency;

	private EstimationTypeEto estimationtype;

	private ProjectScopeEto projectscope;

	private UnitMeasureEto unitmeasure;

	private ProjectTechnologyEto projecttechnology;

	private ProjectTypeEto projecttype;

	private List<StimaItemEto> items;

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

	public float getContingency() {
		return contingency;
	}

	public void setContingency(float contingency) {
		this.contingency = contingency;
	}

	public EstimationTypeEto getEstimationtype() {
		return estimationtype;
	}

	public void setEstimationtype(EstimationTypeEto estimationtype) {
		this.estimationtype = estimationtype;
	}

	public ProjectScopeEto getProjectscope() {
		return projectscope;
	}

	public void setProjectscope(ProjectScopeEto projectscope) {
		this.projectscope = projectscope;
	}

	public UnitMeasureEto getUnitmeasure() {
		return unitmeasure;
	}

	public void setUnitmeasure(UnitMeasureEto unitmeasure) {
		this.unitmeasure = unitmeasure;
	}

	public ProjectTechnologyEto getProjecttechnology() {
		return projecttechnology;
	}

	public void setProjecttechnology(ProjectTechnologyEto projecttechnology) {
		this.projecttechnology = projecttechnology;
	}

	public ProjectTypeEto getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(ProjectTypeEto projecttype) {
		this.projecttype = projecttype;
	}

	public List<StimaItemEto> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEto> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "StimaCto [id=" + id + ", nomeprogetto=" + nomeprogetto + ", wbs=" + wbs + ", descrizione=" + descrizione
				+ ", datainizio=" + datainizio + ", datafine=" + datafine + ", ownerstima=" + ownerstima
				+ ", contingency=" + contingency + ", estimationtype=" + estimationtype + ", projectscope="
				+ projectscope + ", unitmeasure=" + unitmeasure + ", projecttechnology=" + projecttechnology
				+ ", projecttype=" + projecttype + ", items=" + items + "]";
	}

}

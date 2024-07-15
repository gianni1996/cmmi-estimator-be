package com.nttdata.cmmiestimator.stima.model;

import java.time.LocalDate;
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

import com.nttdata.cmmiestimator.estimationtype.model.EstimationTypeEntity;
import com.nttdata.cmmiestimator.projectscope.model.ProjectScopeEntity;
import com.nttdata.cmmiestimator.projecttechnology.model.ProjectTechnologyEntity;
import com.nttdata.cmmiestimator.projecttype.model.ProjectTypeEntity;
import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;
import com.nttdata.cmmiestimator.unitmeasure.model.UnitMeasureEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "stima")
public class StimaEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stima_generator")
	@SequenceGenerator(name = "stima_generator", sequenceName = "seq_stima", allocationSize = 1)
	private Long id;

	@Column(name = "nome_progetto")
	private String nomeprogetto;

	@Column(name = "wbs")
	private String wbs;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "data_inizio")
	private LocalDate datainizio;

	@Column(name = "data_fine")
	private LocalDate datafine;

	@Column(name = "owner_stima")
	private String ownerstima;

	@Column(name = "contingency")
	private float contingency;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estimationtype")
	private EstimationTypeEntity estimationtype;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project_scope")
	private ProjectScopeEntity projectscope;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_unit_measure")
	private UnitMeasureEntity unitmeasure;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project_technology")
	private ProjectTechnologyEntity projecttechnology;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_project_type")
	private ProjectTypeEntity projecttype;

	@OneToMany(mappedBy = "stima")
	private List<StimaItemEntity> items;

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

	public EstimationTypeEntity getEstimationtype() {
		return estimationtype;
	}

	public void setEstimationtype(EstimationTypeEntity estimationtype) {
		this.estimationtype = estimationtype;
	}

	public ProjectScopeEntity getProjectscope() {
		return projectscope;
	}

	public void setProjectscope(ProjectScopeEntity projectscope) {
		this.projectscope = projectscope;
	}

	public UnitMeasureEntity getUnitmeasure() {
		return unitmeasure;
	}

	public void setUnitmeasure(UnitMeasureEntity unitmeasure) {
		this.unitmeasure = unitmeasure;
	}

	public ProjectTechnologyEntity getProjecttechnology() {
		return projecttechnology;
	}

	public void setProjecttechnology(ProjectTechnologyEntity projecttechnology) {
		this.projecttechnology = projecttechnology;
	}

	public List<StimaItemEntity> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEntity> items) {
		this.items = items;
	}

	public ProjectTypeEntity getProjecttype() {
		return projecttype;
	}

	public void setProjecttype(ProjectTypeEntity projecttype) {
		this.projecttype = projecttype;
	}

}

package com.nttdata.cmmiestimator.stimaitem.model;

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
import com.nttdata.cmmiestimator.confskillmix.model.ConfSkillMixEntity;
import com.nttdata.cmmiestimator.confworkactivities.model.ConfWorkActivitiesEntity;
import com.nttdata.cmmiestimator.phase.model.PhaseEntity;
import com.nttdata.cmmiestimator.release.model.ReleaseEntity;
import com.nttdata.cmmiestimator.requirement.model.RequirementEntity;
import com.nttdata.cmmiestimator.stima.model.StimaEntity;
import com.nttdata.cmmiestimator.workitem.model.WorkItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "stima_item")
public class StimaItemEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stimaitem_generator")
	@SequenceGenerator(name = "stimaitem_generator", sequenceName = "seq_stima_item", allocationSize = 1)
	private Long id;

	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "assunzioni")
	private String assunzioni;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_release")
	private ReleaseEntity release;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_phase")
	private PhaseEntity phase;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_requirement")
	private RequirementEntity requirement;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_work_item")
	private WorkItemEntity workitem;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_complexity")
	private ComplexityEntity complexity;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_workactivities")
	private ConfWorkActivitiesEntity confworkactivities;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_stima")
	private StimaEntity stima;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_conf_skillmix")
	private ConfSkillMixEntity confskillmix;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getAssunzioni() {
		return assunzioni;
	}

	public void setAssunzioni(String assunzioni) {
		this.assunzioni = assunzioni;
	}

	public ReleaseEntity getRelease() {
		return release;
	}

	public void setRelease(ReleaseEntity release) {
		this.release = release;
	}

	public PhaseEntity getPhase() {
		return phase;
	}

	public void setPhase(PhaseEntity phase) {
		this.phase = phase;
	}

	public RequirementEntity getRequirement() {
		return requirement;
	}

	public void setRequirement(RequirementEntity requirement) {
		this.requirement = requirement;
	}

	public WorkItemEntity getWorkitem() {
		return workitem;
	}

	public void setWorkitem(WorkItemEntity workitem) {
		this.workitem = workitem;
	}

	public ComplexityEntity getComplexity() {
		return complexity;
	}

	public void setComplexity(ComplexityEntity complexity) {
		this.complexity = complexity;
	}

	public ConfWorkActivitiesEntity getConfworkactivities() {
		return confworkactivities;
	}

	public void setConfworkactivities(ConfWorkActivitiesEntity confworkactivities) {
		this.confworkactivities = confworkactivities;
	}

	public StimaEntity getStima() {
		return stima;
	}

	public void setStima(StimaEntity stima) {
		this.stima = stima;
	}

	public ConfSkillMixEntity getConfskillmix() {
		return confskillmix;
	}

	public void setConfskillmix(ConfSkillMixEntity confskillmix) {
		this.confskillmix = confskillmix;
	}
}

package com.nttdata.cmmiestimator.stimaitem.to;

import com.nttdata.cmmiestimator.complexity.to.ComplexityEto;
import com.nttdata.cmmiestimator.confskillmix.to.ConfSkillMixEto;
import com.nttdata.cmmiestimator.confworkactivities.to.ConfWorkActivitiesEto;
import com.nttdata.cmmiestimator.phase.to.PhaseEto;
import com.nttdata.cmmiestimator.release.to.ReleaseEto;
import com.nttdata.cmmiestimator.requirement.to.RequirementEto;
import com.nttdata.cmmiestimator.stima.to.StimaEto;
import com.nttdata.cmmiestimator.workitem.to.WorkItemEto;

/**
 * 
 * @author BuonocoreGi
 *
 */
public class StimaItemCto {

	private Long id;

	private String descrizione;

	private String assunzioni;

	private ReleaseEto release;

	private PhaseEto phase;

	private RequirementEto requirement;

	private WorkItemEto workitem;

	private ComplexityEto complexity;

	private ConfWorkActivitiesEto confworkactivities;

	private StimaEto stima;

	private ConfSkillMixEto confskillmix;

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

	public ReleaseEto getRelease() {
		return release;
	}

	public void setRelease(ReleaseEto release) {
		this.release = release;
	}

	public PhaseEto getPhase() {
		return phase;
	}

	public void setPhase(PhaseEto phase) {
		this.phase = phase;
	}

	public RequirementEto getRequirement() {
		return requirement;
	}

	public void setRequirement(RequirementEto requirement) {
		this.requirement = requirement;
	}

	public WorkItemEto getWorkitem() {
		return workitem;
	}

	public void setWorkitem(WorkItemEto workitem) {
		this.workitem = workitem;
	}

	public ComplexityEto getComplexity() {
		return complexity;
	}

	public void setComplexity(ComplexityEto complexity) {
		this.complexity = complexity;
	}

	public ConfWorkActivitiesEto getConfworkactivities() {
		return confworkactivities;
	}

	public void setConfworkactivities(ConfWorkActivitiesEto confworkactivities) {
		this.confworkactivities = confworkactivities;
	}

	public StimaEto getStima() {
		return stima;
	}

	public void setStima(StimaEto stima) {
		this.stima = stima;
	}

	public ConfSkillMixEto getConfskillmix() {
		return confskillmix;
	}

	public void setConfskillmix(ConfSkillMixEto confskillmix) {
		this.confskillmix = confskillmix;
	}

	@Override
	public String toString() {
		return "StimaItemCto [id=" + id + ", descrizione=" + descrizione + ", assunzioni=" + assunzioni + ", release="
				+ release + ", phase=" + phase + ", requirement=" + requirement + ", workitem=" + workitem
				+ ", complexity=" + complexity + ", confworkactivities=" + confworkactivities + ", stima=" + stima
				+ ", confskillmix=" + confskillmix + "]";
	}

}

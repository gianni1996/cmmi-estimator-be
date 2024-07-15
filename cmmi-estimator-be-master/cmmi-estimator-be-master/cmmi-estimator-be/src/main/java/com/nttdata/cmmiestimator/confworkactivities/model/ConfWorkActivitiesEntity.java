package com.nttdata.cmmiestimator.confworkactivities.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.nttdata.cmmiestimator.stimaitem.model.StimaItemEntity;

/**
 * 
 * @author BuonocoreGi
 *
 */
@Entity
@Table(name = "conf_workactivities")
public class ConfWorkActivitiesEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "confworkactivities_generator")
	@SequenceGenerator(name = "confworkactivities_generator", sequenceName = "seq_conf_workactivities", allocationSize = 1)
	private Long id;

	@Column(name = "attivita")
	@NotEmpty(message = "Attività may not be empty")
	private String attivita;

	@Column(name = "effort")
	@NotNull
	private float effort = 0;

	@Column(name = "valori_pred")
	@NotNull
	private float valoripred = 0;

	@OneToMany(mappedBy = "confworkactivities")
	private List<StimaItemEntity> items;

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

	public List<StimaItemEntity> getItems() {
		return items;
	}

	public void setItems(List<StimaItemEntity> items) {
		this.items = items;
	}

}

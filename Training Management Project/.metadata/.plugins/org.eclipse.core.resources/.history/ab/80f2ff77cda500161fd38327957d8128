package com.project.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the technology database table.
 * 
 */
@Entity
@NamedQuery(name="Technology.findAll", query="SELECT t FROM Technology t")
public class Technology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tech_id")
	private int techId;

	@Column(name="tech_name")
	private String techName;

	//bi-directional many-to-one association to BatchTechnology
	@OneToMany(mappedBy="technology")
	private List<BatchTechnology> batchTechnologies;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="technology")
	private List<TMSSession> sessions;

	//bi-directional many-to-one association to TrainerTechnology
	@OneToMany(mappedBy="technology")
	private List<TrainerTechnology> trainerTechnologies;

	public Technology() {
	}

	public int getTechId() {
		return this.techId;
	}

	public void setTechId(int techId) {
		this.techId = techId;
	}

	public String getTechName() {
		return this.techName;
	}

	public void setTechName(String techName) {
		this.techName = techName;
	}

	public List<BatchTechnology> getBatchTechnologies() {
		return this.batchTechnologies;
	}

	public void setBatchTechnologies(List<BatchTechnology> batchTechnologies) {
		this.batchTechnologies = batchTechnologies;
	}

	public BatchTechnology addBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().add(batchTechnology);
		batchTechnology.setTechnology(this);

		return batchTechnology;
	}

	public BatchTechnology removeBatchTechnology(BatchTechnology batchTechnology) {
		getBatchTechnologies().remove(batchTechnology);
		batchTechnology.setTechnology(null);

		return batchTechnology;
	}

	public List<TMSSession> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<TMSSession> sessions) {
		this.sessions = sessions;
	}

	public TMSSession addSession(TMSSession session) {
		getSessions().add(session);
		session.setTechnology(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setTechnology(null);

		return session;
	}

	public List<TrainerTechnology> getTrainerTechnologies() {
		return this.trainerTechnologies;
	}

	public void setTrainerTechnologies(List<TrainerTechnology> trainerTechnologies) {
		this.trainerTechnologies = trainerTechnologies;
	}

	public TrainerTechnology addTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().add(trainerTechnology);
		trainerTechnology.setTechnology(this);

		return trainerTechnology;
	}

	public TrainerTechnology removeTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().remove(trainerTechnology);
		trainerTechnology.setTechnology(null);

		return trainerTechnology;
	}

}
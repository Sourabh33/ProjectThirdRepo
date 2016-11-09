package com.project.springmvc.model;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the trainer_technology database table.
 * 
 */
@Entity
@Table(name="trainer_technology")
@NamedQuery(name="TrainerTechnology.findAll", query="SELECT t FROM TrainerTechnology t")
public class TrainerTechnology implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_tech_id")
	private Integer trainerTechId;

	//bi-directional many-to-one association to Technology
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;

	//bi-directional many-to-one association to Trainer
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;

	public TrainerTechnology() {
	}

	public int getTrainerTechId() {
		return this.trainerTechId;
	}

	public void setTrainerTechId(int trainerTechId) {
		this.trainerTechId = trainerTechId;
	}

	public Technology getTechnology() {
		return this.technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Trainer getTrainer() {
		return this.trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

}
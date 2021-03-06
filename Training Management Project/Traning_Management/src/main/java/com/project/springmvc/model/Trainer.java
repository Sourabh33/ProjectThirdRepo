package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the trainer database table.
 * 
 */
@Entity
@NamedQuery(name="Trainer.findAll", query="SELECT t FROM Trainer t")
public class Trainer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainer_id")
	private Integer trainerId;

	
	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	@NotEmpty
	@Column(name="trainer_email_id",nullable=false)
	private String trainerEmailId;

	@NotEmpty
	@Column(name="trainer_location",nullable=false)
	private String trainerLocation;

	@NotEmpty
	@Column(name="trainer_name",nullable=false)
	private String trainerName;

	@NotEmpty
	@Column(name="trainer_password",nullable=false)
	private String trainerPassword;

	//bi-directional many-to-one association to Session
	@OneToMany(mappedBy="trainer")
	private List<TMSSession> sessions;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to TrainerTechnology
	@OneToMany(mappedBy="trainer")
	private List<TrainerTechnology> trainerTechnologies;

	public Trainer() {
	}

	public int getTrainerId() {
		return this.trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return this.modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getTrainerEmailId() {
		return this.trainerEmailId;
	}

	public void setTrainerEmailId(String trainerEmailId) {
		this.trainerEmailId = trainerEmailId;
	}

	public String getTrainerLocation() {
		return this.trainerLocation;
	}

	public void setTrainerLocation(String trainerLocation) {
		this.trainerLocation = trainerLocation;
	}

	public String getTrainerName() {
		return this.trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerPassword() {
		return this.trainerPassword;
	}

	public void setTrainerPassword(String trainerPassword) {
		this.trainerPassword = trainerPassword;
	}

	public List<TMSSession> getSessions() {
		return this.sessions;
	}

	public void setSessions(List<TMSSession> sessions) {
		this.sessions = sessions;
	}

	public TMSSession addSession(TMSSession session) {
		getSessions().add(session);
		session.setTrainer(this);

		return session;
	}

	public TMSSession removeSession(TMSSession session) {
		getSessions().remove(session);
		session.setTrainer(null);

		return session;
	}

	public Admin getAdmin1() {
		return this.admin1;
	}

	public void setAdmin1(Admin admin1) {
		this.admin1 = admin1;
	}

	public Admin getAdmin2() {
		return this.admin2;
	}

	public void setAdmin2(Admin admin2) {
		this.admin2 = admin2;
	}

	public List<TrainerTechnology> getTrainerTechnologies() {
		return this.trainerTechnologies;
	}

	public void setTrainerTechnologies(List<TrainerTechnology> trainerTechnologies) {
		this.trainerTechnologies = trainerTechnologies;
	}

	public TrainerTechnology addTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().add(trainerTechnology);
		trainerTechnology.setTrainer(this);

		return trainerTechnology;
	}

	public TrainerTechnology removeTrainerTechnology(TrainerTechnology trainerTechnology) {
		getTrainerTechnologies().remove(trainerTechnology);
		trainerTechnology.setTrainer(null);

		return trainerTechnology;
	}

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((trainerId == null) ? 0 : trainerId.hashCode());
        return result;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Trainer))
            return false;
        Trainer other = (Trainer) obj;
        if (trainerId == null) {
            if (other.trainerId != null)
                return false;
        } else if (!trainerId.equals(other.trainerId))
            return false;
        
        return true;
    }
	
	@Override
	public String toString() {
		
		return "Trainer [ID=" + trainerId + ", EmailId="  +trainerEmailId+",trainerLocation="
		+trainerLocation
		+", trainerName="+trainerName+", trainerPassword="+trainerPassword+"]";
	}
}
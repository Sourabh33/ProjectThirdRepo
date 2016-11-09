package com.project.springmvc.model;
import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;


/**
 * The persistent class for the session database table.
 * 
 */
@Entity
@Table(name="session")
public class TMSSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="session_id")
	private Integer sessionId;

	@Temporal(TemporalType.DATE)
	private Date created;

	@Temporal(TemporalType.DATE)
	private Date modified;

	@NotEmpty
	@Column(name="session_conducted",nullable=false)
	private String sessionConducted;

	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name="session_date",nullable=false)
	private Date sessionDate;

	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="session_end_time",nullable=false)
	private Date sessionEndTime;

	@NotEmpty
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="session_start_time",nullable=false)
	private Date sessionStartTime;

	@NotEmpty
	@Column(name="topic_covered",nullable=false)
	private String topicCovered;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="created_by")
	private Admin admin1;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="modified_by")
	private Admin admin2;

	//bi-directional many-to-one association to Technology
	@ManyToOne
	@JoinColumn(name="tech_id")
	private Technology technology;

	//bi-directional many-to-one association to Trainer
	@ManyToOne
	@JoinColumn(name="trainer_id")
	private Trainer trainer;

	public TMSSession() {
	}

	public int getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
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

	public String getSessionConducted() {
		return this.sessionConducted;
	}

	public void setSessionConducted(String sessionConducted) {
		this.sessionConducted = sessionConducted;
	}

	public Date getSessionDate() {
		return this.sessionDate;
	}

	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}

	public Date getSessionEndTime() {
		return this.sessionEndTime;
	}

	public void setSessionEndTime(Date sessionEndTime) {
		this.sessionEndTime = sessionEndTime;
	}

	public Date getSessionStartTime() {
		return this.sessionStartTime;
	}

	public void setSessionStartTime(Date sessionStartTime) {
		this.sessionStartTime = sessionStartTime;
	}

	public String getTopicCovered() {
		return this.topicCovered;
	}

	public void setTopicCovered(String topicCovered) {
		this.topicCovered = topicCovered;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
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
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sessionId == null) ? 0 : sessionId.hashCode());
        return result;
    }
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof TMSSession))
            return false;
        TMSSession other = (TMSSession) obj;
        if (sessionId == null) {
            if (other.sessionId != null)
                return false;
        } else if (!sessionId.equals(other.sessionId))
            return false;
        
        return true;
    }
	
	@Override
	public String toString() {
		
		return "TMSSession [ID=" + sessionId + ", sessionConducted=" +sessionConducted +",date="+sessionDate
		+", sessionStartTime="+sessionStartTime+", sessionEndTime="+sessionEndTime+"]";
	}


}
package com.project.springmvc.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the batch_employee database table.
 * 
 */
@Entity
@Table(name="batch_employee")
@NamedQuery(name="BatchEmployee.findAll", query="SELECT b FROM BatchEmployee b")
public class BatchEmployee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="batch_emp_id")
	private Integer batchEmpId;

	//bi-directional many-to-one association to Batch
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="emp_id")
	private Employee employee;

	public BatchEmployee() {
	}

	public int getBatchEmpId() {
		return this.batchEmpId;
	}

	public void setBatchEmpId(int batchEmpId) {
		this.batchEmpId = batchEmpId;
	}

	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
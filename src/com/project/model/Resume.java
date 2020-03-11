package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESUME")
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int oid;
	@Column(name = "resume_oid")
	private int resume_oid;
	@Column(name = "resource_oid")
	private int resource_oid;

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getResume_oid() {
		return resume_oid;
	}

	public void setResume_oid(int resume_oid) {
		this.resume_oid = resume_oid;
	}

	public int getResource_oid() {
		return resource_oid;
	}

	public void setResource_oid(int resource_oid) {
		this.resource_oid = resource_oid;
	}

}

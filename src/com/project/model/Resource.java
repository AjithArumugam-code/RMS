package com.project.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "RESOURCE")
public class Resource {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int oid;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "second_name")
	private String secondName;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "designation")
	private String designation;
	@Column(name = "address")
	private String address;
	@Column(name = "current_status")
	private String currentStatus;
	@Column(name = "current_company")
	private String currentCompany;
	@Column(name = "resource_owner_oid")
	private int ResourceOwnerOid;
	@Transient
	private Set<Users> user;

	@Transient
	private List<String> selectedUser;

	public List<String> getSelectedUser() {
		return selectedUser;
	}

	public Set<Users> getUser() {
		return user;
	}

	public void setUser(Set<Users> user) {
		this.user = user;
	}

	public void setSelectedUser(List<String> selectedUser) {
		this.selectedUser = selectedUser;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getCurrentCompany() {
		return currentCompany;
	}

	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}

	public int getResourceOwnerOid() {
		return ResourceOwnerOid;
	}

	public void setResourceOwnerOid(int resourceOwnerOid) {
		ResourceOwnerOid = resourceOwnerOid;
	}
}

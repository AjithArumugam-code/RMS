package com.project.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "USERS")
@NamedQueries({ @NamedQuery(name = "getUserProfileByUserId", query = "from Users userv where userv.user_id= :user_id"),
		@NamedQuery(name = "getUserProfileByUserOid", query = "from Users user where user.oid= :userOid") })
public class Users {
	public static final String STATUS_USER_ACTIVE = "ACT";
	public static final String STATUS_USER_INACTIVE = "INACT";
	public static final String GET_USER_PROFILE_BY_USER_ID = "getUserProfileByUserId";
	public static final String GET_USER_PROFILE_BY_USER_OID = "getUserProfileByUserOid";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int oid;

	
	@Column(name = "first_name")
	private String first_name;

	
	@Column(name = "second_name")
	private String second_name;

	

	@Column(name = "user_id")
	private String user_id;

	
	@Column(name = "designation")
	private String designation;

	
	@Column(name = "mobile")
	private String mobile;

	
	@Column(name = "address")
	private String address;

	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;

	
	@Column(name = "password")
	private String password;

	@Transient
	private List<String> selectedRoles;

	public List<String> getSelectedRoles() {
		return selectedRoles;
	}

	public void setSelectedRoles(List<String> selectedRoles) {
		this.selectedRoles = selectedRoles;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLES", joinColumns = { @JoinColumn(name = "user_oid") }, inverseJoinColumns = {
			@JoinColumn(name = "role_oid") })
	private Set<Roles> roles;

	public String getPassword() {
		return password;
	}

	public final void setPassword(String password) {
		this.password = password;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getSecond_name() {
		return second_name;
	}

	public void setSecond_name(String second_name) {
		this.second_name = second_name;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}

package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLES")
@NamedQueries({
		@NamedQuery(name = "getUserRolesOidByUserOid", query = "select userRole.role_oid from UserRoles userRole where userRole.user_oid= :user_oid") })
public class UserRoles {

	public static final String GET_USER_ROLES_OID_BY_USER_OID = "getUserRolesOidByUserOid";

	public UserRoles() {
	}

	public UserRoles(String user_oid, String role_oid) {
		super();
		this.user_oid = user_oid;
		this.role_oid = role_oid;
	}
	@Id
	@Column(name = "user_oid")
	private String user_oid;
	@Column(name = "role_oid")
	private String role_oid;

	public String getUser_oid() {
		return user_oid;
	}

	public void setUser_oid(String user_oid) {
		this.user_oid = user_oid;
	}

	public String getRole_oid() {
		return role_oid;
	}

	public void setRole_oid(String role_oid) {
		this.role_oid = role_oid;
	}

}

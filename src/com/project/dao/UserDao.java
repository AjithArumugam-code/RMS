package com.project.dao;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.model.Resource;
import com.project.model.Resume;
import com.project.model.Roles;
import com.project.model.UserRoles;
import com.project.model.Users;

public interface UserDao extends UserDetailsService {

	UserDetails loadUserByUsername(String UserName);

	Users saveUserRegistration(Users userVO);

	Set<UserRoles> saveUserRegistrationRoles(Set<UserRoles> userRoleVOs,String userOid);
	
	Set<Roles> getAllRoles();
	
	Set<Users> getAllUsers();

	Resource saveResourceRegistration(Resource resource);

	Resume saveResume(Resume res);

}

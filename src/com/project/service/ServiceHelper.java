package com.project.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.util.CollectionUtils;

import com.project.model.UserRoles;
import com.project.model.Users;

public class ServiceHelper {

	private static Logger logger = Logger.getLogger(ServiceHelper.class);

	public Set<UserRoles> populateUserRoles(Users users) {
		logger.info(users);
		Set<UserRoles> UserRoless = new HashSet<UserRoles>();
		Collection<String> userRoles = users.getSelectedRoles();
		if (!CollectionUtils.isEmpty(userRoles)) {
			for (String userRole : userRoles) {
				UserRoles UserRoles = new UserRoles();
				UserRoles.setRole_oid(userRole);
				UserRoles.setUser_oid(String.valueOf(users.getOid()));
				UserRoless.add(UserRoles);
			}
		}
		return UserRoless;
	}

}

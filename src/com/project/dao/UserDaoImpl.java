package com.project.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.project.common.Constants;
import com.project.model.Resource;
import com.project.model.Resume;
import com.project.model.Roles;
import com.project.model.UserDetail;
import com.project.model.UserRoles;
import com.project.model.Users;
import com.project.service.DaoSupport;

@SuppressWarnings("deprecation")
@Transactional(readOnly = false)
public class UserDaoImpl extends DaoSupport implements UserDao {

	private static Logger logger = Logger.getLogger(UserDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public UserDetails loadUserByUsername(String userName) {

		try {

			logger.info("here the process starts!");

			List<GrantedAuthority> roleList = new ArrayList<GrantedAuthority>();
			List<Users> users = null;
			Users Users = null;

			String[] paramNames = new String[1];
			paramNames[0] = Constants.USER_ID;

			Object[] values = new Object[1];
			values[0] = userName;

			String query = "from Users user where (user.user_id = :user_id)";

			users = find(query, paramNames, values);
			if (users != null && users.size() > 0) {
				Users = (Users) users.get(0);
				Set<Roles> roles = Users.getRoles();
				if (roles != null && roles.size() > 0) {
					for (Object roleObj : roles) {
						Roles Roles = (Roles) roleObj;
						if (Roles != null) {
							GrantedAuthority authority = new GrantedAuthorityImpl(Roles.getRole());
							roleList.add(authority);
						}
					}
				}
			} else {
				throw new UsernameNotFoundException("Username or password is invalid");
			}

			Collection<? extends GrantedAuthority> array = (Collection<? extends GrantedAuthority>) roleList;

			UserDetails userDetails = new UserDetail(Users.getOid(), Users.getUser_id(), Users.getPassword(),
					Users.getFirst_name(), true, true, true, true, array);

			if (userDetails.getAuthorities() == null
					&& (userDetails.getAuthorities() != null && userDetails.getAuthorities().size() > 0)) {
				throw new UsernameNotFoundException("Authorities not found");
			}
			return userDetails;
		} catch (UsernameNotFoundException e) {
			throw e;
		} catch (Throwable e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("Username or Password is invalid");
		}
	}

	@Override
	public Users saveUserRegistration(Users users) {
		try {
			getHibernateTemplate().saveOrUpdate(users);
		} catch (Exception e) {
			logger.error(e);
		}
		return users;
	}

	@Override
	public Resource saveResourceRegistration(Resource resource) {
		try {
			getHibernateTemplate().save(resource);
		} catch (Exception e) {
			logger.error(e);
		}
		return resource;
	}


	@SuppressWarnings("unchecked")
	@Override
	public Set<UserRoles> saveUserRegistrationRoles(Set<UserRoles> userRoleVOs, String userOid) {
		try {
			List<String> existing_UserRoleOids = findByNamedQuery(UserRoles.GET_USER_ROLES_OID_BY_USER_OID, "user_oid",
					userOid);
			Set<UserRoles> needsToDeleteRoleOids = new HashSet<UserRoles>();
			for (UserRoles currentlySelectedUserRoleVO : userRoleVOs) {
				if (existing_UserRoleOids.contains(currentlySelectedUserRoleVO.getRole_oid())) {
					existing_UserRoleOids.remove(currentlySelectedUserRoleVO.getRole_oid());// Removing from the
																							// existing team oids list
																							// those are added earlier &
																							// also selected currently
				}
			}
			for (String existingUserRoleOidToDelete : existing_UserRoleOids) {
				UserRoles userRoleVO = new UserRoles();
				userRoleVO.setUser_oid(userOid);
				userRoleVO.setRole_oid(existingUserRoleOidToDelete);
				needsToDeleteRoleOids.add(userRoleVO);
			}
			if (!CollectionUtils.isEmpty(needsToDeleteRoleOids)) {
				getHibernateTemplate().deleteAll(needsToDeleteRoleOids);// Deleting the unwanted teams those have been
																		// attached earlier with user
			}
		} catch (Exception e) {
			logger.error(e);
		}
		getHibernateTemplate().saveOrUpdateAll(userRoleVOs);
		return userRoleVOs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Roles> getAllRoles() {
		Set<Roles> roles = new HashSet<Roles>();
		try {
			List<Roles> roleVOs = find("from Roles");
			roles.addAll(roleVOs);
		} catch (Exception e) {
			logger.error(e);
		}
		return roles;
	}

	@SuppressWarnings("unchecked")
	public Set<Users> getAllUsers() {
		Set<Users> users = new HashSet<Users>();
		try {
			List<Users> roleVOs = find("from Users");
			users.addAll(roleVOs);
		} catch (Exception e) {
			logger.error(e);
		}
		return users;
	}

	@Override
	public Resume saveResume(Resume res) {
		try {
			getHibernateTemplate().save(res);
		} catch (Exception e) {
			logger.error(e);
		}
		return res;
	}

}

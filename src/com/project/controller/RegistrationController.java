package com.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.ResourceDao;
import com.project.dao.UserDao;
import com.project.dto.ResourceDto;
import com.project.model.Resource;
import com.project.model.Resume;
import com.project.model.ResumeFile;
import com.project.model.Users;
import com.project.service.ServiceHelper;

@Controller
public class RegistrationController {

	private static Logger logger = Logger.getLogger(RegistrationController.class);

	@Autowired
	UserDao userDao;

	@Autowired
	ResourceDao resourceDao;

	@RequestMapping(value = "/user/showRegistration", method = RequestMethod.GET)
	public String showRegisteration(@ModelAttribute("registration") Users users, HttpServletRequest request) {
		users.setRoles(userDao.getAllRoles());
		return "Registration";
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String printWelcome(@ModelAttribute("ResourceRegistration") Resource resource, HttpServletRequest request) {
		resource.setUser(userDao.getAllUsers());
		return "dashboard";
	}

	@RequestMapping(value = "/user/saveUser")
	public String saveUser(@ModelAttribute("registration") Users users, HttpServletRequest request) {
		Md5PasswordEncoder ms = new Md5PasswordEncoder();
		users.setPassword(ms.encodePassword(users.getPassword(), null));
		userDao.saveUserRegistration(users);
		ServiceHelper serviceHelper = new ServiceHelper();
		// Saving User-Role Mapping in user_roles table
		userDao.saveUserRegistrationRoles(serviceHelper.populateUserRoles(users), String.valueOf(users.getOid()));
		return "login";
	}

	@RequestMapping(value = "/saveResource", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("ResourceRegistration") ResourceDto resourceDto, BindingResult bindingResult,
			HttpServletRequest request) throws IOException {
		Resource resource = new Resource();
		ResumeFile resume = new ResumeFile();
		Resume res = new Resume();
		resource.setFirstName(resourceDto.getFirstName());
		resource.setSecondName(resourceDto.getSecondName());
		resource.setAddress(resourceDto.getAddress());
		resource.setDesignation(resourceDto.getDesignation());
		resource.setMobile(resourceDto.getMobile());
		resource.setCurrentStatus(resourceDto.getCurrentStatus());
		resource.setCurrentCompany(resourceDto.getCurrentCompany());
		resource.setResourceOwnerOid(resourceDto.getSelectedUser());
		resume.setResume(resourceDto.getResume());
		userDao.saveResourceRegistration(resource);
		resourceDao.addPhoto(resume);
		res.setResource_oid(resource.getOid());
		res.setResume_oid(resume.getOid());
		logger.info(res);
		userDao.saveResume(res);
		return "login";
	}

}

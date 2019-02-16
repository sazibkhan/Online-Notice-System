package com.school.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.dao.LoginDao;
import com.school.model.LoginUser;
import com.school.model.UserBasicInfo;



@Controller
public class UserRegistration {
	
	@Autowired
	private LoginDao loginDao;
	

	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("register");
	    mav.addObject("user", new UserBasicInfo());
	    mav.setViewName("registration");
	    return mav;
	  }
	
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UserBasicInfo user) {
		  LoginUser loginUser=new LoginUser();
		  loginDao.register(user);
		  loginUser.setUsername(user.getUsername());
		  loginUser.setPassword(user.getPassword());
		  loginDao.Loginregister(loginUser);
		  ModelAndView mav = new ModelAndView("login");
		  mav.addObject("action", new LoginUser());
		  mav.setViewName("login");
		  return mav;
	  }

}

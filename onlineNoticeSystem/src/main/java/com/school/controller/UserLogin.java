package com.school.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.dao.AdminDao;
import com.school.dao.LoginDao;
import com.school.model.AdminBasicInfo;
import com.school.model.AdminUser;
import com.school.model.LoginUser;
import com.school.model.Notice;
import com.school.model.UserBasicInfo;




@Controller
public class UserLogin {
	
	
	
	@Autowired
	private LoginDao loginDao;

	
	UserBasicInfo userInfo=new UserBasicInfo();
	
	@RequestMapping(value="/")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		LoginUser loginUser=new LoginUser();
		model.addObject("action", loginUser);
		model.setViewName("login");
		return model;
	}
	
	
	
	
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("action") LoginUser login) {
	    ModelAndView mav = null;
	    LoginUser user = loginDao.validateUser(login);
	    userInfo.setUsername(login.getUsername());
	    if (null != user) {
	    return new ModelAndView("redirect:/shownotice");
	    } else {
	    mav = new ModelAndView("login");
	    mav.addObject("message", "Sorry Username or Password is wrong...!!");
	    }
	    return mav;
	  }
	 
	 @RequestMapping(value ="/logout", method = RequestMethod.GET)
	 public ModelAndView logout( ModelAndView model,HttpServletRequest request){
			model.addObject("action", new LoginUser());
			model.setViewName("login");
			return model;
		}
	 
	 	@RequestMapping(value="/userInfo", method = RequestMethod.GET)
		public ModelAndView userInfo(ModelAndView model, UserBasicInfo userBasicInfo) {
		 	System.out.println("admin email is working..."+userInfo.getUsername());
		 	userBasicInfo.setUsername(userInfo.getUsername());
			List<UserBasicInfo> infoList = loginDao.userInfo(userBasicInfo);
			
			model.addObject("userInfoList", infoList);
			model.setViewName("userInfo");
			return model;
		}


}

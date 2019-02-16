package com.school.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.dao.AdminDao;
import com.school.dao.NoticeDao;
import com.school.model.AdminBasicInfo;
import com.school.model.AdminUser;
import com.school.model.Notice;
import com.school.service.NoticeService;




@Controller
public class AdminLogin {
	
	@Autowired
	private AdminDao loginDao;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private NoticeDao noticeDao;
	
	private boolean userInValidity;
	
	private String name;
	private String adminEmail;

	Notice n=new Notice();

	
	@RequestMapping(value="/index")
	public ModelAndView listContact(ModelAndView model) throws IOException{
		AdminUser loginUser=new AdminUser();
		model.addObject("admin", loginUser);
		model.setViewName("AdminLogin");
		return model;
	}

	
	 @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	  public ModelAndView loginProcess(ModelAndView model, @ModelAttribute("admin") AdminUser login) {
	    ModelAndView mav = null;
	    AdminUser user = loginDao.validateUser(login);
	    n.setAdmin_email(login.getEmail());
	    if (null != user) {
	    userInValidity=false;
	    adminEmail=login.getEmail();
	    List<Notice> list = noticeDao.list();
		Collections.reverse(list);
		model.addObject("listNotice", list);
		model.addObject("searchAttribute", new Notice());
		model.setViewName("redirect:/searchValue");
	    
	    } else {
	    model = new ModelAndView("AdminLogin");
	    model.addObject("message", "Sorry Username or Password is wrong...!!");
	    }
	    return model;
	  }
	 
	 @RequestMapping(value= "/addnotice", method = RequestMethod.POST)
		public ModelAndView saveContact(ModelAndView model, @ModelAttribute("notice") Notice notice) {
			notice.setAdmin_email(n.getAdmin_email());
			System.out.println("admin is working.."+n.getAdmin_email());
			noticeService.saveOrUpdate(notice);		
			List<Notice> list = noticeDao.list();
			Collections.reverse(list);
			model.addObject("listNotice", list);
			model.addObject("searchAttribute", new Notice());
			model.setViewName("adminNotice");
			return model;
		}
	 
	 @RequestMapping(value="/adminInfo", method = RequestMethod.GET)
		public ModelAndView ImNotice(ModelAndView model, AdminBasicInfo adminBasicInfo ) {
		 	adminBasicInfo.setEmail(n.getAdmin_email());
		 	System.out.println("admin email is working..."+adminBasicInfo.getEmail());
			List<AdminBasicInfo> list = loginDao.adminInfo(adminBasicInfo);
			List<Notice> noticelist = noticeDao.adminWiseNotice(adminBasicInfo);
			
			model.addObject("adminWiseNotice", noticelist);
			model.addObject("adminInfoList", list);
			model.setViewName("adminInfo");
			return model;
		}


	public String getAdminEmail() {
		return adminEmail;
	}


	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	
}

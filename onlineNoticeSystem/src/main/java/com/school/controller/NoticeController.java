package com.school.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.school.dao.NoticeDao;
import com.school.model.LoginUser;
import com.school.model.Notice;
import com.school.model.UserBasicInfo;
import com.school.service.NoticeService;





@Controller
public class NoticeController {
	@Autowired
	private NoticeDao noticeDao;
	AdminLogin adminLogin=new AdminLogin();

	 @RequestMapping(value = "/addnotice", method = RequestMethod.GET)
	 public ModelAndView showdeshboard(ModelAndView model) throws IOException{
		  ModelAndView mav = new ModelAndView();
		  mav.addObject("notice", new Notice());
		  mav.setViewName("dashboard");
		  return mav;
	  }

		@RequestMapping(value="/shownotice")
		public ModelAndView newContact(ModelAndView model,Notice notice) {
			model.addObject("searchAttribute", new Notice());
			if (notice.getSearch()!=null) {
			List<Notice> list = noticeDao.listSearch(notice.getSearch());
			Collections.reverse(list);
			model.addObject("listNotice", list);
			model.setViewName("showNotice");
			}else {
				List<Notice> list = noticeDao.list();
				Collections.reverse(list);
				model.addObject("listNotice", list);
				model.setViewName("showNotice");
			}
			return model;
		}
		
		@RequestMapping(value="/searchValue")
		public ModelAndView adminNotice(ModelAndView model, Notice notice) {
			model.addObject("searchAttribute", new Notice());
			if (notice.getSearch()!=null) {
				List<Notice> list = noticeDao.listSearch(notice.getSearch());
				Collections.reverse(list);
				model.addObject("listNotice", list);
				System.out.println("item wise item working.."+notice.getSearch());
				model.setViewName("adminNotice");
			} else {
				List<Notice> list = noticeDao.list();
				Collections.reverse(list);
				model.addObject("listNotice", list);
				System.out.println("search is workinng..");
				model.setViewName("adminNotice");
			}
			return model;
		}
	
		@RequestMapping(value="/importantNotice")
		public ModelAndView importantNotice(ModelAndView model) {
			model.addObject("searchAttribute", new Notice());
			List<Notice> list = noticeDao.importantList();
			Collections.reverse(list);
			model.addObject("ImportantListNotice", list);
			model.setViewName("importantNotice");
			return model;
		}
		
		@RequestMapping(value="/important", method = RequestMethod.GET)
		public ModelAndView ImNotice(ModelAndView model) {
			List<Notice> list = noticeDao.importantList();
			Collections.reverse(list);
			model.addObject("ImportantListNotice", list);
			model.setViewName("userImportantNotice");
			return model;
		}
		
		@RequestMapping(value = "/editNotice", method = RequestMethod.GET)
		public ModelAndView editNotice(HttpServletRequest request) {
			System.out.println("notice Id accepted"+request.getParameter("id"));
			
			int noticeID = Integer.parseInt(request.getParameter("id"));
			Notice notice = noticeDao.get(noticeID);
			ModelAndView model = new ModelAndView();
			model.addObject("notice", notice);
			model.setViewName("dashboard");
			return model;
		}
		
		 public static void insertionSort(int array[]) {  
		        int n = array.length;  
		        for (int j = 1; j < n; j++) {  
		            int key = array[j];  
		            int i = j-1;  
		            while ( (i > -1) && ( array [i] > key ) ) {  
		                array [i+1] = array [i];  
		                i--;  
		            }  
		            array[i+1] = key;  
		        }  
		    }  
		
	
}

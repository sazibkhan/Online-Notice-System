package com.school.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.AdminDao;
import com.school.model.AdminBasicInfo;
import com.school.model.AdminUser;




@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDao loginDao;


	public void registerUserInfo(AdminBasicInfo userBasicInfo) {
		loginDao.registerUserInfo(userBasicInfo);
		
	}


	public void saveLogin(AdminUser loginUser) {
		loginDao.saveLogin(loginUser);
		
	}

	
}

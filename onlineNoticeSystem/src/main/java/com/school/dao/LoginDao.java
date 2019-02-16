package com.school.dao;

import java.util.List;

import com.school.model.LoginUser;
import com.school.model.UserBasicInfo;

public interface LoginDao {
	
	  void register(UserBasicInfo user);
	  void Loginregister(LoginUser user);
	
	 LoginUser validateUser(LoginUser login);
		public List<UserBasicInfo> userInfo(UserBasicInfo userBasicInfo);

}

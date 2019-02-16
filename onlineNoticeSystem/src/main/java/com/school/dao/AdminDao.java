package com.school.dao;

import java.util.List;

import com.school.model.AdminBasicInfo;
import com.school.model.AdminUser;
import com.school.model.SignUpAttemptDTO;
import com.school.model.UserBasicInfo;

public interface AdminDao {

	
	AdminUser validateUser(AdminUser login);

	void createSignUpAttempt(SignUpAttemptDTO signUpAttemptDTO);

	void deleteExtraObject(String email);

	void registerUserInfo(AdminBasicInfo userBasicInfo);

	void saveLogin(AdminUser loginUser);

	AdminBasicInfo validInfo(AdminBasicInfo userBasicInfo);

	SignUpAttemptDTO findActivationCode(SignUpAttemptDTO sign);
	
	public List<AdminBasicInfo> adminInfo(AdminBasicInfo adminBasicInfo);


	


}

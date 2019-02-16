package com.school.dao;

import java.util.List;

import com.school.model.AdminBasicInfo;
import com.school.model.Notice;


public interface NoticeDao {

	void saveOrUpdate(Notice notice);

	public List<Notice> list();
	public List<Notice> importantList();
	List<Notice> adminWiseNotice(AdminBasicInfo adminBasicInfo);

	public Notice get(int noticeID);

	List<Notice> listSearch(String search);
	

}

package com.school.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.NoticeDao;
import com.school.model.Notice;


@Service
@Transactional
public class NoticeService {

	@Autowired
	private NoticeDao noticeDao;

	public void saveOrUpdate(Notice notice) {
		notice.setCreate_date(new Date());
		noticeDao.saveOrUpdate(notice);
	}
	
}

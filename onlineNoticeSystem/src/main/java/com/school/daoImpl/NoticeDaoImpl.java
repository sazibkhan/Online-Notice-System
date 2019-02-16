package com.school.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.school.dao.NoticeDao;
import com.school.model.AdminBasicInfo;
import com.school.model.Notice;


public class NoticeDaoImpl implements NoticeDao{
	

	private JdbcTemplate jdbcTemplate;
	
	public NoticeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void saveOrUpdate(Notice notice) {
		if (notice.getId() > 0) {
//			 update
			String sql = "UPDATE notice SET notice=?, create_date=?, valueable=?, notice_title=?, admin_email=? WHERE id=?";
			jdbcTemplate.update(sql, notice.getNotice(), notice.getCreate_date(), notice.getValueable(), notice.getNotice_title(), notice.getAdmin_email(), notice.getId());
		} else {
			// insert
		String sql = "insert into notice( notice, create_date, valueable, notice_title, admin_email) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, notice.getNotice(), notice.getCreate_date(), notice.getValueable(), notice.getNotice_title(), notice.getAdmin_email());
				}
		
	}
		public List<Notice> list() {
//			SELECT n.id, n.notice, n.create_date, n.notice_title, i.username FROM info i join notice n on(n.admin_email=i.email);
			String sql = "SELECT n.id, n.notice, n.create_date, n.notice_title, i.username,i.photoPath FROM info i join notice n on(n.admin_email=i.email)";
			List<Notice> listnotice = jdbcTemplate.query(sql, new RowMapper<Notice>() {
				
			
				public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
					Notice notice = new Notice();
					notice.setId(rs.getInt("id"));
					notice.setNotice(rs.getString("notice"));
					notice.setNotice_title(rs.getString("notice_title"));
					notice.setCreate_date(rs.getDate("create_date"));
					notice.setAdmin_name(rs.getString("username"));
					notice.setPhotoPath(rs.getString("photoPath"));
					return notice;
				}
			});
			return listnotice;
		}
		
		
		public List<Notice> importantList() {
			String sql = "SELECT n.id, n.notice, n.create_date, n.notice_title, i.username, i.photoPath FROM info i join notice n on(n.admin_email=i.email) where valueable = 1";
			List<Notice> listnotice = jdbcTemplate.query(sql, new RowMapper<Notice>() {
				public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
					Notice notice = new Notice();
					notice.setId(rs.getInt("id"));
					notice.setNotice(rs.getString("notice"));
					notice.setNotice_title(rs.getString("notice_title"));
					notice.setCreate_date(rs.getDate("create_date"));
					notice.setAdmin_name(rs.getString("username"));
					notice.setPhotoPath(rs.getString("photoPath"));
					return notice;
				}
			});
			return listnotice;
		}
		
		public List<Notice> adminWiseNotice(AdminBasicInfo adminBasicInfo) {
			String sql = "SELECT n.id, n.notice, n.create_date, n.notice_title, i.username, i.photoPath FROM info i join notice n on(n.admin_email=i.email) where admin_email='" + adminBasicInfo.getEmail() + "'";
			List<Notice> adminWiseList = jdbcTemplate.query(sql, new RowMapper<Notice>() {
				public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
					Notice notice = new Notice();
					notice.setId(rs.getInt("id"));
					notice.setNotice(rs.getString("notice"));
					notice.setNotice_title(rs.getString("notice_title"));
					notice.setCreate_date(rs.getDate("create_date"));
					notice.setAdmin_name(rs.getString("username"));
					notice.setPhotoPath(rs.getString("photoPath"));
					return notice;
				}
			});
			return adminWiseList;
		}
		
		public List<Notice> listSearch(String search) {
//			SELECT n.id, n.notice, n.create_date, n.notice_title, i.username FROM info i join notice n on(n.admin_email=i.email);

			String sql = "SELECT n.id, n.notice, n.create_date, n.notice_title, i.username, i.photoPath FROM info i join notice n on(n.admin_email=i.email) WHERE i.username LIKE '%"+search	+"%'";
			List<Notice> listnotice = jdbcTemplate.query(sql, new RowMapper<Notice>() {
				
			
				public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
					Notice notice = new Notice();
					notice.setId(rs.getInt("id"));
					notice.setNotice(rs.getString("notice"));
					notice.setNotice_title(rs.getString("notice_title"));
					notice.setCreate_date(rs.getDate("create_date"));
					notice.setAdmin_name(rs.getString("username"));
					notice.setPhotoPath(rs.getString("photoPath"));
					return notice;
				}
			});
			return listnotice;
		}
		
		public Notice get(int noticeID) {
			String sql = "SELECT * FROM notice WHERE id='" + noticeID + "'";
			return jdbcTemplate.query(sql, new ResultSetExtractor<Notice>() {

		
				public Notice extractData(ResultSet rs) throws SQLException,
						DataAccessException {
					if (rs.next()) {
						Notice notice = new Notice();
						notice.setId(rs.getInt("id"));
						notice.setNotice(rs.getString("notice"));
						notice.setNotice_title(rs.getString("notice_title"));
						notice.setCreate_date(rs.getDate("create_date"));
						notice.setAdmin_email(rs.getString("admin_email"));
						return notice;
					}
					
					return null;
				}
				
			});
		}
	

}

package com.school.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.school.dao.AdminDao;
import com.school.model.AdminBasicInfo;
import com.school.model.AdminUser;
import com.school.model.Notice;
import com.school.model.SignUpAttemptDTO;
import com.school.model.UserBasicInfo;





public class AdminDaoImpl implements AdminDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public AdminDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void registerUserInfo(AdminBasicInfo user) {
	    String sql = "insert into info (id, username, password, firstname, lastname, email, address, phone, photoPath) values(?,?,?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql,  user.getId(), user.getUsername(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(), user.getPhotoPath());
	    }
	
	public void saveLogin(AdminUser user) {
	    String sql = "insert into login (id, password, email) values(?,?,?)";
	    jdbcTemplate.update(sql, user.getId(), user.getPassword(), user.getEmail());
	    }
	
	public void createSignUpAttempt(SignUpAttemptDTO sing) {
	    String sql = "insert into singup (signID, email, status, date, activationCode) values(?, ?, ?, ?, ?)";
	    jdbcTemplate.update(sql, sing.getSignID(), sing.getEmail(), sing.getStatus(), sing.getDate(), sing.getActivationCode());
	    }
	
	
	
	public void deleteExtraObject(String email) {
		String sql = "DELETE FROM singup WHERE email=?";
		jdbcTemplate.update(sql, email);
	}
	
	

	public AdminUser validateUser(AdminUser login) {
		String sql = "select * from login where email='" + login.getEmail() + "' and password='" + login.getPassword()+ "'";
	    List<AdminUser> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	}


	class UserMapper implements RowMapper<AdminUser> {
		  public AdminUser mapRow(ResultSet rs, int arg1) throws SQLException {
			 AdminUser user = new AdminUser();
		    user.setEmail(rs.getString("email"));
		    user.setPassword(rs.getString("password"));
		    return user;
		  }
		}
	

	public AdminBasicInfo validInfo(AdminBasicInfo userBasicInfo) {
		String sql = "select * from info where email='" + userBasicInfo.getEmail() + "'";
	    List<AdminBasicInfo> info = jdbcTemplate.query(sql, new UserInfoMapper());
	    return info.size() > 0 ? info.get(0) : null;
	}


	class UserInfoMapper implements RowMapper<AdminBasicInfo> {
		  public AdminBasicInfo mapRow(ResultSet rs, int arg1) throws SQLException {
			  AdminBasicInfo info = new AdminBasicInfo();
			  info.setEmail(rs.getString("email"));
			
		    return info;
		  }
		}
	
	public SignUpAttemptDTO findActivationCode(SignUpAttemptDTO signUpAttemptDTO) {
		String sql = "select * from singup where activationCode='" + signUpAttemptDTO.getActivationCode() + "'";
	    List<SignUpAttemptDTO> attempt = jdbcTemplate.query(sql, new SignAttemptMapper());
	    return attempt.size() > 0 ? attempt.get(0) : null;
	}


	class SignAttemptMapper implements RowMapper<SignUpAttemptDTO> {
		  public SignUpAttemptDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			  SignUpAttemptDTO attempt = new SignUpAttemptDTO();
			  attempt.setActivationCode(rs.getString("activationCode"));
			
		    return attempt;
		  }
		}
	
	

	public List<AdminBasicInfo> adminInfo(AdminBasicInfo adminBasicInfo) {
		String sql = "select * from info where email='" + adminBasicInfo.getEmail() + "'";
		List<AdminBasicInfo> adminInfo = jdbcTemplate.query(sql, new RowMapper<AdminBasicInfo>() {
			public AdminBasicInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
				AdminBasicInfo adminBasicInfo = new AdminBasicInfo();
				adminBasicInfo.setId(rs.getInt("id"));
				adminBasicInfo.setUsername(rs.getString("username"));
				adminBasicInfo.setPassword(rs.getString("password"));
				adminBasicInfo.setFirstname(rs.getString("firstname"));
				adminBasicInfo.setLastname(rs.getString("lastname"));
				adminBasicInfo.setEmail(rs.getString("email"));
				adminBasicInfo.setAddress(rs.getString("address"));
				adminBasicInfo.setPhone(rs.getInt("phone"));
				adminBasicInfo.setPhotoPath(rs.getString("photoPath"));
				return adminBasicInfo;
			}
		});
		return adminInfo;
	}
	

}
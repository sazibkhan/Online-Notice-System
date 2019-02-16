package com.school.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.school.dao.LoginDao;
import com.school.model.AdminBasicInfo;
import com.school.model.LoginUser;
import com.school.model.UserBasicInfo;



public class UserLoginDaoImpl implements LoginDao{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserLoginDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public void register(UserBasicInfo user) {
		String sql = "insert into user_info (username, password, firstname, lastname, address, phone, gender) values(?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname(),
	    user.getLastname(),user.getAddress(), user.getPhone(), user.getGender() });
		
		System.out.println("user basic daoimpl is working....");
	    }
	
	public void Loginregister(LoginUser user) {
	    String sql = "insert into user_login (user_id, username, password) values(?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getUser_id(),user.getUsername(), user.getPassword()});
	    System.out.println(" login daoimpl is working....");
	    }
	

	public LoginUser validateUser(LoginUser login) {
		 String sql = "select * from user_login where username='" + login.getUsername() + "' and password='" + login.getPassword()+ "'";
		 
	    List<LoginUser> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	}


class UserMapper implements RowMapper<LoginUser> {
	  public LoginUser mapRow(ResultSet rs, int arg1) throws SQLException {
		 LoginUser user = new LoginUser();
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    return user;
	  }
	}

public List<UserBasicInfo> userInfo(UserBasicInfo userBasicInfo) {
	System.out.println("data accepted in daoImpl"+userBasicInfo.getUsername());
	String sql = "select * from user_info where username='" + userBasicInfo.getUsername() + "'";
	List<UserBasicInfo> adminInfo = jdbcTemplate.query(sql, new RowMapper<UserBasicInfo>() {
		public UserBasicInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBasicInfo adminBasicInfo = new UserBasicInfo();
			System.out.println("data find by "+rs.getString("username"));
			adminBasicInfo.setUsername(rs.getString("username"));
			adminBasicInfo.setPassword(rs.getString("password"));
			adminBasicInfo.setFirstname(rs.getString("firstname"));
			adminBasicInfo.setLastname(rs.getString("lastname"));
			adminBasicInfo.setAddress(rs.getString("address"));
			adminBasicInfo.setPhone(rs.getInt("phone"));
			adminBasicInfo.setGender(rs.getString("gender"));
			return adminBasicInfo;
		}
	});
	return adminInfo;
}

}
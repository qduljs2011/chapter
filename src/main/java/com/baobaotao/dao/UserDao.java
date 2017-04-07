package com.baobaotao.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.User;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public int getMatchCount(String userName,String password){
		String sql="select count(*) from t_user where user_name=? and pass_word=?";
		return jdbcTemplate.queryForObject(sql, Integer.class, userName,password);
	}
	public User findUserByUserName(final String userName){
		String sqlStr="select user_id,user_name,credits from t_user where user_name=?";
		final User user=new User();
		jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				user.setUserName(userName);
				user.setUserId(rs.getInt("user_id"));
				user.setCredits(rs.getInt("credits"));
			}
		}
		);
		return user;
	}
	public void updateLoginInfo(User user){
		String sql="update t_user set last_visit=?,last_ip=?,credits=? where user_id=?";
		System.out.println(user.getLastVisit());
		jdbcTemplate.update(sql,user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId());
	}
	public User findUserById(int userId) {
		String sql="select * from t_user where user_id=?";
		return jdbcTemplate.query(sql, new Object[]{userId},new ResultSetExtractor<User>(){

			@Override
			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
				
				if(rs.next()){
					
					User user=new User();
					user.setUserId(userId);
					user.setUserName(rs.getString("user_name"));
					user.setPassword(rs.getString("pass_word"));
					user.setLastVisit(rs.getDate("last_visit"));
					user.setLastIp(rs.getString("last_ip"));
					user.setCredits(rs.getInt("credits"));
					return user;
				}else{
					return null;
				}
				
			}
			
		});
	}
	
	
}

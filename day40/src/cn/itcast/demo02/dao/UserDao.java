package cn.itcast.demo02.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.demo02.domain.User;
import cn.itcast.demo02.utils.JdbcUtils;

public class UserDao {

	public User login(String username, String password) throws SQLException {
		
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		
		String sql = "select * from user where username = ? and password = ?";
		
		User user = qr.query(sql, new BeanHandler<User>(User.class),username,password);
		
		return user;
	}

	
	
}

package cn.itcast.demo02.service;

import java.sql.SQLException;

import cn.itcast.demo02.dao.UserDao;
import cn.itcast.demo02.domain.User;

public class UserService {

	UserDao userdao = new UserDao();
	
	public User login(String username, String password) {
		
		User user = null;
		
		try {
			user = userdao.login(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

}

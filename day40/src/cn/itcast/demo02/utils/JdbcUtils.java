package cn.itcast.demo02.utils;



import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//鍒涘缓涓�釜C3P0鐨勮繛鎺ユ睜瀵硅薄
	private static DataSource ds = new ComboPooledDataSource();
	
	//绾跨▼缁戝畾杩炴帴瀵硅薄鐨凾hreadLocal
	private static ThreadLocal<Connection> pool = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		
		conn = pool.get();
		if( conn == null ){
			try {
				//浠庤繛鎺ユ睜涓彇寰椾竴涓柊鐨勮繛鎺ュ璞★紝骞跺拰褰撳墠绾跨▼缁戝畾
				conn = ds.getConnection();
				pool.set(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
}

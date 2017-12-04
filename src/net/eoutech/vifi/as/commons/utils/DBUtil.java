package net.eoutech.vifi.as.commons.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	private static DBUtil instance; //单例模式
	
	public static DBUtil getInstance() {
		if (instance == null) {
			instance = new DBUtil();
		}
		return instance;
	}
	
	private DBUtil(){ //构造函数
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection(){
		Connection conn = null;
		try {
			String url = "jdbc:mysql://192.168.1.215:3306/UUWIFI?generateSimpleParameterMetadata=true&useUnicode=true&characterEncoding=utf8";
			String username = "root";
			String password = "myvifi";
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}

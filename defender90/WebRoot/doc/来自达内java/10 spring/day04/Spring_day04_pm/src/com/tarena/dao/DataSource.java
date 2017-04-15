package com.tarena.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSource {
	private String driver;
	
	@Value("#{jdbc.url}")
	private String url;
	@Value("#{jdbc.user}")
	private String user;
	@Value("#{jdbc.pwd}")
	private String pwd;
	
	@Value("#{jdbc.driver}")
	public void setDriver(String driver) {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		this.driver = driver;
	}
	
	public Connection getConnection()
		throws SQLException{
		Connection conn = DriverManager.getConnection(
				url, user, pwd);
		return conn;
	}
	
	public void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





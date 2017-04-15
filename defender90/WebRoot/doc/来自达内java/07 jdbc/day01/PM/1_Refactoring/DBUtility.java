package day01.v3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtility {
	private static String driver = null;
	private static String url = null;
	private static String user = null;
	private static String pwd = null;

	static {
		try {
			Properties props=new Properties();
			// 加载配置文件
			props.load(DBUtility.class
					.getClassLoader()
					.getResourceAsStream("day01/v3/db.properties")
					);
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			pwd = props.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	public static Connection openConnection() throws SQLException {
		return DriverManager.getConnection(url, user, pwd);
	}
	public static void closeConnection(Connection con) {
		if (con != null)
			try { con.close(); } 
			catch (SQLException e) {
				System.out.println("关闭连接时发生异常");
			}
	}
}


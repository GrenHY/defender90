package day01.v4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionSource {
	private static BasicDataSource dataSource = null;

	public ConnectionSource() {}
	public static void init() {
		Properties dbProps = new Properties();
		// 取配置文件可以根据实际的不同修改
		try {			
			String path="day01/v4/db.properties";
			dbProps.load(ConnectionSource.class
					.getClassLoader()
					.getResourceAsStream(path)
					);
		} catch (IOException e) {e.printStackTrace();}

		try {
			String driver = dbProps.getProperty("driver");
			String url = dbProps.getProperty("url");
			String username = dbProps.getProperty("username");
			String password = dbProps.getProperty("password");

			String initialSize = dbProps.getProperty("initialSize");
			String minIdle = dbProps.getProperty("minIdle");
			String maxIdle = dbProps.getProperty("maxIdle");
			String maxWait = dbProps.getProperty("maxWait");
			String maxTotal = dbProps.getProperty("maxTotal");

			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);

			// 初始化连接数
			if (initialSize != null)
				dataSource.setInitialSize(
						Integer.parseInt(initialSize));

			// 最小空闲连接
			if (minIdle != null)
				dataSource.setMinIdle(
						Integer.parseInt(minIdle));

			// 最大空闲连接
			if (maxIdle != null)
				dataSource.setMaxIdle(
						Integer.parseInt(maxIdle));

			// 超时回收时间(以毫秒为单位)
			if (maxWait != null)
				dataSource.setMaxWaitMillis(Long.parseLong(maxWait));

			// 最大连接数
			if (maxTotal != null)
				if (!maxTotal.trim().equals("0"))
					dataSource.setMaxTotal(Integer.parseInt(maxTotal));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("创建连接池失败!请检查设置!!!");
		}
	}

	public static synchronized Connection getConnection() throws SQLException {
		if (dataSource == null) {
			init();
		}
		Connection conn = null;
		if (dataSource != null) {
			conn = dataSource.getConnection();
		}
		return conn;
	}
}

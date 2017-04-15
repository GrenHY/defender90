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
		// ȡ�����ļ����Ը���ʵ�ʵĲ�ͬ�޸�
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

			// ��ʼ��������
			if (initialSize != null)
				dataSource.setInitialSize(
						Integer.parseInt(initialSize));

			// ��С��������
			if (minIdle != null)
				dataSource.setMinIdle(
						Integer.parseInt(minIdle));

			// ����������
			if (maxIdle != null)
				dataSource.setMaxIdle(
						Integer.parseInt(maxIdle));

			// ��ʱ����ʱ��(�Ժ���Ϊ��λ)
			if (maxWait != null)
				dataSource.setMaxWaitMillis(Long.parseLong(maxWait));

			// ���������
			if (maxTotal != null)
				if (!maxTotal.trim().equals("0"))
					dataSource.setMaxTotal(Integer.parseInt(maxTotal));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�������ӳ�ʧ��!��������!!!");
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

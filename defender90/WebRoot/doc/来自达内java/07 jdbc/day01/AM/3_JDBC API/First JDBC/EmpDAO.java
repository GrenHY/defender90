package day01.v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		dao.findAll();
	}

	public void findAll() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			//mysql:
			String driver="com.mysql.jdbc.Driver";
			//oracle:
			//String driver="oracle.jdbc.OracleDriver";
			Class.forName(driver);
			//mysql:
			String url="jdbc:mysql://192.168.205.129:3306/zhangdong"
						+"?useUnicode=true&characterEncoding=utf8&";
			//Oracle:
			//String url="jdbc:oracle:thin:@192.168.205.129:1521:ORCL";
			con = DriverManager.getConnection(url,"zhangdong","sa");
			stmt = con.createStatement();
			String sql="select empno,ename,sal,hiredate from emp_你名字全拼";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + ","
						+ rs.getString("ename") + ","
						+ rs.getDouble("sal") + "," 
						+ rs.getDate("hiredate"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("驱动类无法找到!");
			throw new RuntimeException(e);
		} catch (SQLException e) {
			System.out.println("数据库访问异常!");
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null)	rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				System.out.println("关闭连接时发生异常");
			}
		}
	}
}

package day01.v4;

import java.sql.Connection;
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
			con = ConnectionSource.getConnection();
			stmt = con.createStatement();
			String sql="select empno, ename, sal, hiredate from emp_你名字全拼";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + ","
						+ rs.getString("ename") + ","
						+ rs.getDouble("sal") + "," 
						+ rs.getDate("hiredate")
						);
			}
		} catch (SQLException e) {
			System.out.println("数据库访问异常!");
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("释放资源时发生异常");
			}
		}
	}
}

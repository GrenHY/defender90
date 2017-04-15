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
			String sql="select empno, ename, sal, hiredate from emp_������ȫƴ";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + ","
						+ rs.getString("ename") + ","
						+ rs.getDouble("sal") + "," 
						+ rs.getDate("hiredate")
						);
			}
		} catch (SQLException e) {
			System.out.println("���ݿ�����쳣!");
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
				System.out.println("�ͷ���Դʱ�����쳣");
			}
		}
	}
}

package com.tarena.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tarena.entity.User;

@Repository("userDao")//���սӿ�����!
public class OracleUserDao 
	implements UserDao, Serializable{
	
	@Resource
	private DataSource dataSource;

	public User findByName(String name) {
		String sql = "select id, name, " +
				"pwd, phone from t_user " +
				"where name=?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			java.sql.PreparedStatement ps =
				conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			User user = null;
			while(rs.next()){
				//rowToUser ����ǰrs�е�һ������
				//���Ƶ� User������
				user = rowToUser(rs);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			dataSource.close(conn);
		}
	}
	/** ��rs��ǰ�����ݸ��Ƶ� User������ */
	private User rowToUser(ResultSet rs)
		throws SQLException{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setPwd(rs.getString("pwd"));
		user.setPhone(rs.getString("phone"));
		return user;
	}
}




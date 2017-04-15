package com.tarena.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tarena.entity.User;

@Repository("userDao")//按照接口命名!
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
				//rowToUser 将当前rs中的一行数据
				//复制到 User对象中
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
	/** 将rs当前行数据复制到 User对象中 */
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




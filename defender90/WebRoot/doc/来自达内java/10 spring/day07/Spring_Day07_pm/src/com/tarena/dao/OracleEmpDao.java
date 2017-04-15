package com.tarena.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tarena.entity.Emp;
@Repository("empDao")
public class OracleEmpDao
	implements EmpDao, Serializable{
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	public void add(Emp emp) {
		String sql = "insert into t_emp (" +
				"empno, ename, mgr, hiredate," +
				"sal, comm, deptno ) values (" +
				"seq_t_emp.nextval, ?,?,?,?,?,?) ";
		//sql, 替换的参数，返回值是数量1
		int rows = jdbcTemplate.update(sql,
				emp.getEname(), emp.getMgr(),
				emp.getHiredate(), emp.getSal(),
				emp.getComm(), emp.getDeptno());
	}

	public Emp delete(Integer empno) {
		Emp emp = findById(empno);
		String sql = "delete from t_emp where empno=?";
		jdbcTemplate.update(sql, empno);
		return emp;
	}
	public List<Emp> findByDept(Integer deptno) {
		String sql = "select empno, ename, mgr, " +
		"hiredate, sal, comm, deptno " +
		"from t_emp where deptno=?";
		List<Emp> list = jdbcTemplate
			.query(sql, new Object[]{deptno},
					rowMapper);
	 	return list;
	}
	public List<Emp> findAll() {
		String sql = "select empno, ename, mgr, " +
		"hiredate, sal, comm, deptno " +
		"from t_emp ";
		List<Emp> list = jdbcTemplate
			.query(sql, rowMapper);
		//.query(sql, sql参数， rowMapper)
		return list;
	}

	public Emp findById(Integer empno) {
		String sql = "select empno, ename, mgr, " +
				"hiredate, sal, comm, deptno " +
				"from t_emp where empno=?";
		try {
			Emp emp = jdbcTemplate.queryForObject(
					sql, new Object[]{empno}, rowMapper);
			//(sql, 替换参数, rowToObject)
			return emp;
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
	private RowMapper<Emp> rowMapper = 
		new RowMapper<Emp>() {
			//将rs中的一行映射为一个Emp对象
			public Emp mapRow(
					ResultSet rs, int index) 
			throws SQLException {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				return emp;
			}
		};

	public void update(Emp emp) {
		String sql = "update t_emp set ename=?, " +
				"mgr=?, hiredate=?, sal=?, comm=?, " +
				"deptno=? where empno=?";
		jdbcTemplate.update(sql, 
				emp.getEname(),emp.getMgr(),
				emp.getHiredate(),
				emp.getSal(), emp.getComm(), 
				emp.getDeptno(), emp.getEmpno());
	}
}







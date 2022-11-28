package org.sim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.sim.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("Dao")
public class EmpDaoImpl implements EmpDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmpDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Emp e) {
		jdbcTemplate.update("insert into emp values(?,?,?)", e.getEno(), e.getName(), e.getAddress());

	}

	@Override
	public void delete(int eno) {
		jdbcTemplate.update("delete from emp where eno=?", eno);

	}

	@Override
	public List<Emp> getEmployee() {
		return jdbcTemplate.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
				Emp e = new Emp();
				e.setEno(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				return e;
			}
			
		});
	}

	@Override
	public Emp getEmployee(int eno) {
		return jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement("select * from emp where eno=?");
				pst.setInt(1, eno);
				return pst;
			}
		}, new ResultSetExtractor<Emp>() {

			@Override
			public Emp extractData(ResultSet rs) throws SQLException, DataAccessException {
				Emp e = new Emp();
				e.setEno(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setAddress(rs.getString(3));
				return e;
			}
		});
	}

	@Override
	public void update(int eno, Emp e) {
		jdbcTemplate.update("update emp set name=? and address=? where eno=?", e.getName(),e.getAddress(),e.getEno());

	}

}

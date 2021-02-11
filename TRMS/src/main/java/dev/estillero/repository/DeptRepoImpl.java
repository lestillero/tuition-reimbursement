package dev.estillero.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dev.estillero.models.Dept;
import dev.estillero.util.JDBCConnection;

public class DeptRepoImpl implements DeptRepo {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createDept(Dept d) {
		try {
			
			String sql = "CALL create_dept(?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, d.getDept_name());
			
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Dept getDept(String dept_name) {
		try {
			
			String sql = "SELECT * FROM dept WHERE dept_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dept_name);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Dept d = new Dept();
				d.setDept_id(rs.getInt("DEPT_ID"));
				d.setDept_name(rs.getString("DEPT_NAME"));
				d.setDept_head_id(rs.getInt("DEPT_HEAD_ID"));
				
				return d;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Dept> getAllDepts() {
		List<Dept> depts = new ArrayList<Dept>();
		
		try {
			
			String sql = "SELECT * FROM dept";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Dept d = new Dept();
				d.setDept_id(rs.getInt("DEPT_ID"));
				d.setDept_name(rs.getString("DEPT_NAME"));
				d.setDept_head_id(rs.getInt("DEPT_HEAD_ID"));
				
				depts.add(d);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public boolean updateDept(Dept d) {
		try {
			
			String sql = "UPDATE dept SET dept_name = ?, dept_head_id = ? WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, d.getDept_name());
			ps.setString(2, Integer.toString(d.getDept_head_id()));
			ps.setString(3, Integer.toString(d.getDept_id()));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean deleteDept(String dept_name) {
		try {
			
			String sql = "DELETE dept WHERE dept_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, dept_name);
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}

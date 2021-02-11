package dev.estillero.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dev.estillero.models.Staff;
import dev.estillero.util.JDBCConnection;

public class StaffRepoImpl implements StaffRepo {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean addtoStaff(Staff s) {
		try {
			
			String sql = "CALL addto_staff(?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, s.getFirst_name());
			cs.setString(2, s.getLast_name());
			cs.setString(3, Integer.toString(s.getSupervisor_id()));
			cs.setString(4, Integer.toString(s.getDept_id()));
			
			cs.execute();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public Staff getStaffById(int staff_id) {
		try {
			
			String sql = "SELECT * FROM staff WHERE staff_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(staff_id));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				Staff s = new Staff();
				s.setStaff_id(rs.getInt("STAFF_ID"));
				s.setFirst_name(rs.getString("FIRST_NAME"));
				s.setLast_name(rs.getString("LAST_NAME"));
				s.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
				s.setDept_id(rs.getInt("DEPT_ID"));
				s.setAvail_fund(rs.getDouble("AVAIL_FUND"));
				
				return s;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public List<Staff> getStaffByFirstName(String first_name) {
		List<Staff> staff = new ArrayList<Staff>();
				
		try {
			
			String sql = "SELECT * FROM staff WHERE first_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, first_name);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Staff s = new Staff();
				s.setStaff_id(rs.getInt("STAFF_ID"));
				s.setFirst_name(rs.getString("FIRST_NAME"));
				s.setLast_name(rs.getString("LAST_NAME"));
				s.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
				s.setDept_id(rs.getInt("DEPT_ID"));
				s.setAvail_fund(rs.getDouble("AVAIL_FUND"));
				
				staff.add(s);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return staff;
		
	}

	@Override
	public List<Staff> getStaffByLastName(String last_name) {
		List<Staff> staff = new ArrayList<Staff>();
		
		try {
			
			String sql = "SELECT * FROM staff WHERE last_name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, last_name);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Staff s = new Staff();
				s.setStaff_id(rs.getInt("STAFF_ID"));
				s.setFirst_name(rs.getString("FIRST_NAME"));
				s.setLast_name(rs.getString("LAST_NAME"));
				s.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
				s.setDept_id(rs.getInt("DEPT_ID"));
				s.setAvail_fund(rs.getDouble("AVAIL_FUND"));
				
				staff.add(s);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return staff;
		
	}

	@Override
	public List<Staff> getStaffBySupervisor(int supervisor_id) {
		List<Staff> staff = new ArrayList<Staff>();
		
		try {
			
			String sql = "SELECT * FROM staff WHERE supervisor_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(supervisor_id));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Staff s = new Staff();
				s.setStaff_id(rs.getInt("STAFF_ID"));
				s.setFirst_name(rs.getString("FIRST_NAME"));
				s.setLast_name(rs.getString("LAST_NAME"));
				s.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
				s.setDept_id(rs.getInt("DEPT_ID"));
				s.setAvail_fund(rs.getDouble("AVAIL_FUND"));
				
				staff.add(s);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return staff;
	}

	@Override
	public List<Staff> getStaffByDept(int dept_id) {
		List<Staff> staff = new ArrayList<Staff>();
		
		try {
			
			String sql = "SELECT * FROM staff WHERE dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(dept_id));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Staff s = new Staff();
				s.setStaff_id(rs.getInt("STAFF_ID"));
				s.setFirst_name(rs.getString("FIRST_NAME"));
				s.setLast_name(rs.getString("LAST_NAME"));
				s.setSupervisor_id(rs.getInt("SUPERVISOR_ID"));
				s.setDept_id(rs.getInt("DEPT_ID"));
				s.setAvail_fund(rs.getDouble("AVAIL_FUND"));
				
				staff.add(s);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return staff;
	}
	
	@Override
	public int findSupervisor(int staff_id) {
		try {
			
			String sql = "SELECT supervisor_id FROM staff WHERE staff_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(staff_id));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				return rs.getInt("SUPERVISOR_ID");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
		
	}

	@Override
	public boolean updateStaff(Staff s) {
		try {
			
			String sql = "UPDATE staff SET "
				+ "first_name = ?, last_name = ?, "
				+ "supervisor_id = ?, dept_id = ?, "
				+ "avail_fund = ? WHERE staff_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, s.getFirst_name());
			ps.setString(2, s.getLast_name());
			ps.setString(3, Integer.toString(s.getSupervisor_id()));
			ps.setString(4, Integer.toString(s.getDept_id()));
			ps.setString(5, Double.toString(s.getAvail_fund()));
			ps.setString(6, Integer.toString(s.getStaff_id()));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean removeStaff(int staff_id) {
		try {
			
			String sql = "DELETE staff WHERE staff_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(staff_id));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}

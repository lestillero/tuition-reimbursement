package dev.estillero.repository;

import java.util.List;
import dev.estillero.models.Staff;

public interface StaffRepo {
	
	// CREATE
	public boolean addtoStaff(Staff s);
	
	// READ
	public Staff getStaffById(int staff_id);
	public List<Staff> getStaffByFirstName(String first_name);
	public List<Staff> getStaffByLastName(String last_name);
	public List<Staff> getStaffBySupervisor(int supervisor_id);
	public List<Staff> getStaffByDept(int dept_id);
	
	public int findSupervisor(int staff_id);
	
	// UPDATE
	public boolean updateStaff(Staff s);
	
	// DELETE
	public boolean removeStaff(int staff_id);
	

}

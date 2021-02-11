package dev.estillero.services;

import dev.estillero.models.Dept;
import dev.estillero.models.Staff;

public interface AdminService {
	
	// Admin = CEO = President
	
	// Admin adds or deletes members of staff
	public boolean addtoStaff(Staff s);
	public boolean removeStaff(int staff_id);
	
	// Admin creates or deletes department
	public boolean createDept(Dept d);
	public boolean deleteDept(String dept_name);
	
	// Auxiliary looks up staff name to id
	public int findStaffByName(String name);

}

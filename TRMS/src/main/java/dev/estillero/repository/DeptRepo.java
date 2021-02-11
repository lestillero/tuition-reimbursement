package dev.estillero.repository;

import java.util.List;
import dev.estillero.models.Dept;

public interface DeptRepo {
	
	// CREATE
	public boolean createDept(Dept d);
	
	// READ
	public Dept getDept(String dept_name);
	public List<Dept> getAllDepts();
	
	// UPDATE
	public boolean updateDept(Dept d);
	
	// DELETE
	public boolean deleteDept(String dept_name);
	
}

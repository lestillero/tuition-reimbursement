package dev.estillero.models;

public class Staff {
	
	private int staff_id;
	private String first_name;
	private String last_name;
	private int supervisor_id;
	private int dept_id;
	private double avail_fund;
	
	
	public Staff() {
		super();
	}
	
	
	public Staff(String first_name, String last_name, int supervisor_id, int dept_id, double avail_fund) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.supervisor_id = supervisor_id;
		this.dept_id = dept_id;
		this.avail_fund = avail_fund;
	}
	
	
	public Staff(int staff_id, String first_name, String last_name, int supervisor_id, int dept_id, double avail_fund) {
		super();
		this.staff_id = staff_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.supervisor_id = supervisor_id;
		this.dept_id = dept_id;
		this.avail_fund = avail_fund;
	}
	
	
	public int getStaff_id() {
		return this.staff_id;
	}
	
	
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	
	public String getFirst_name() {
		return this.first_name;
	}
	
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	
	public String getLast_name() {
		return this.last_name;
	}
	
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	
	public int getSupervisor_id() {
		return this.supervisor_id;
	}
	
	
	public void setSupervisor_id(int supervisor_id) {
		this.supervisor_id = supervisor_id;
	}
	
	
	public int getDept_id() {
		return this.dept_id;
	}
	
	
	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}
	
	
	public double getAvail_fund() {
		return this.avail_fund;
	}
	
	
	public void setAvail_fund(double avail_fund) {
		this.avail_fund = avail_fund;
	}
	
	
	@Override
	public String toString() {
		return "Staff [staff_id=" + this.staff_id + ", first_name=" + this.first_name + ", last_name=" + this.last_name
			+ ", supervisor_id=" + this.supervisor_id + ", dept_id=" + this.dept_id + ", avail_fund=" + this.avail_fund
			+ "]";
	}
}

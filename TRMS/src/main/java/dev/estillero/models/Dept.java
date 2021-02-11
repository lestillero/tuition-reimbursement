package dev.estillero.models;

public class Dept {
	
	private int dept_id;
	private String dept_name;
	private int dept_head_id;
	
	
	public Dept() {
		super();
	}
	
	
	public Dept(String dept_name) {
		super();
		this.dept_name = dept_name;
	}


	public Dept(String dept_name, int dept_head_id) {
		super();
		this.dept_name = dept_name;
		this.dept_head_id = dept_head_id;
	}


	public Dept(int dept_id, String dept_name, int dept_head_id) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_head_id = dept_head_id;
	}


	public int getDept_id() {
		return this.dept_id;
	}


	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}


	public String getDept_name() {
		return this.dept_name;
	}


	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}


	public int getDept_head_id() {
		return this.dept_head_id;
	}


	public void setDept_head_id(int dept_head_id) {
		this.dept_head_id = dept_head_id;
	}


	@Override
	public String toString() {
		return "Dept [dept_id=" + this.dept_id + ", dept_name=" + this.dept_name + ", dept_head_id=" + this.dept_head_id
			+ "]";
	}
}

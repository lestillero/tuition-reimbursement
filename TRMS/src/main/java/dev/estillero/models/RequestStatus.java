package dev.estillero.models;

import java.sql.Date;

public class RequestStatus {
	
	private int request_id;
	private String status;
	private Date date_requestor;
	private String addtlinfo_requestor;
	private Date date_supervisor;
	private String addtlinfo_supervisor;
	private Date date_dept;
	private String addtlinfo_dept;
	private Date date_benco;
	private String addtlinfo_benco;
	
	
	public RequestStatus() {
		super();
	}
	
	public RequestStatus(int request_id) {
		super();
		this.request_id = request_id;
	}
	
	
	public RequestStatus(Date date_requestor) {
		super();
		this.date_requestor = date_requestor;
	}

	
	public RequestStatus(String status, Date date_requestor, String addtlinfo_requestor) {
		super();
		this.status = status;
		this.date_requestor = date_requestor;
		this.addtlinfo_requestor = addtlinfo_requestor;
	}


	public RequestStatus(String status, Date date_requestor, String addtlinfo_requestor, Date date_supervisor,
		String addtlinfo_supervisor, Date date_dept, String addtlinfo_dept, Date date_benco,
		String addtlinfo_benco) {
		super();
		this.status = status;
		this.date_requestor = date_requestor;
		this.addtlinfo_requestor = addtlinfo_requestor;
		this.date_supervisor = date_supervisor;
		this.addtlinfo_supervisor = addtlinfo_supervisor;
		this.date_dept = date_dept;
		this.addtlinfo_dept = addtlinfo_dept;
		this.date_benco = date_benco;
		this.addtlinfo_benco = addtlinfo_benco;
	}


	public RequestStatus(int request_id, String status, Date date_requestor, String addtlinfo_requestor,
		Date date_supervisor, String addtlinfo_supervisor, Date date_dept, String addtlinfo_dept, Date date_benco,
		String addtlinfo_benco) {
		super();
		this.request_id = request_id;
		this.status = status;
		this.date_requestor = date_requestor;
		this.addtlinfo_requestor = addtlinfo_requestor;
		this.date_supervisor = date_supervisor;
		this.addtlinfo_supervisor = addtlinfo_supervisor;
		this.date_dept = date_dept;
		this.addtlinfo_dept = addtlinfo_dept;
		this.date_benco = date_benco;
		this.addtlinfo_benco = addtlinfo_benco;
	}
	
	public RequestStatus(int request_id, String status, String date_requestor, String addtlinfo_requestor,
		String date_supervisor, String addtlinfo_supervisor, String date_dept, String addtlinfo_dept, String date_benco,
		String addtlinfo_benco) {
		super();
		this.request_id = request_id;
		this.status = status;
		this.date_requestor = Date.valueOf(date_requestor);
		this.addtlinfo_requestor = addtlinfo_requestor;
		this.date_supervisor = Date.valueOf(date_supervisor);
		this.addtlinfo_supervisor = addtlinfo_supervisor;
		this.date_dept = Date.valueOf(date_dept);
		this.addtlinfo_dept = addtlinfo_dept;
		this.date_benco = Date.valueOf(date_benco);
		this.addtlinfo_benco = addtlinfo_benco;
	}


	public int getRequest_id() {
		return this.request_id;
	}


	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}


	public String getStatus() {
		return this.status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDate_requestor() {
		return this.date_requestor;
	}
	

	public void setDate_requestor(Date date_requestor) {
		this.date_requestor = date_requestor;
	}


	public String getAddtlinfo_requestor() {
		return this.addtlinfo_requestor;
	}


	public void setAddtlinfo_requestor(String addtlinfo_requestor) {
		this.addtlinfo_requestor = addtlinfo_requestor;
	}


	public Date getDate_supervisor() {
		return this.date_supervisor;
	}
	

	public void setDate_supervisor(Date date_supervisor) {
		this.date_supervisor = date_supervisor;
	}


	public String getAddtlinfo_supervisor() {
		return this.addtlinfo_supervisor;
	}


	public void setAddtlinfo_supervisor(String addtlinfo_supervisor) {
		this.addtlinfo_supervisor = addtlinfo_supervisor;
	}


	public Date getDate_dept() {
		return this.date_dept;
	}
	

	public void setDate_dept(Date date_dept) {
		this.date_dept = date_dept;
	}


	public String getAddtlinfo_dept() {
		return this.addtlinfo_dept;
	}


	public void setAddtlinfo_dept(String addtlinfo_dept) {
		this.addtlinfo_dept = addtlinfo_dept;
	}


	public Date getDate_benco() {
		return this.date_benco;
	}
	

	public void setDate_benco(Date date_benco) {
		this.date_benco = date_benco;
	}


	public String getAddtlinfo_benco() {
		return this.addtlinfo_benco;
	}


	public void setAddtlinfo_benco(String addtlinfo_benco) {
		this.addtlinfo_benco = addtlinfo_benco;
	}


	@Override
	public String toString() {
		return "RequestStatus [request_id=" + this.request_id + ", status=" + this.status + ", date_requestor="
			+ this.date_requestor + ", addtlinfo_requestor=" + this.addtlinfo_requestor + ", date_supervisor="
			+ this.date_supervisor + ", addtlinfo_supervisor=" + this.addtlinfo_supervisor + ", date_dept="
			+ this.date_dept + ", addtlinfo_dept=" + this.addtlinfo_dept + ", date_benco=" + this.date_benco
			+ ", addtlinfo_benco=" + this.addtlinfo_benco + "]";
	}
}

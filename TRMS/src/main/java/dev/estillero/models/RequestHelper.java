package dev.estillero.models;

import java.sql.Date;

public class RequestHelper {
	
	private int staff_id;
	private Date date_requestor;
	private Date date_start;
	private Date date_end;
	private String location;
	private String event_type;
	private String description;
	private String grading_format;
	private Double amt_requested;
	
	public RequestHelper() {
		super();
	
	}
	
	public RequestHelper(String date_requestor, String date_start, String date_end, String location, String event_type,
		String description, String grading_format, Double amt_requested) {
		super();
		this.date_requestor = Date.valueOf(date_requestor);
		this.date_start = Date.valueOf(date_start);
		this.date_end = Date.valueOf(date_end);
		this.location = location;
		this.event_type = event_type;
		this.description = description;
		this.grading_format = grading_format;
		this.amt_requested = amt_requested;
	}
	
	/*
	public RequestHelper(int staff_id, Date date_requestor, Date date_start, Date date_end, String location,
		String event_type, String description, String grading_format, Double amt_requested) {
		super();
		this.staff_id = staff_id;
		this.date_requestor = date_requestor;
		this.date_start = date_start;
		this.date_end = date_end;
		this.location = location;
		this.event_type = event_type;
		this.description = description;
		this.grading_format = grading_format;
		this.amt_requested = amt_requested;
	}
	*/
	
	public RequestHelper(int staff_id, String date_requestor, String date_start, String date_end, String location,
		String event_type, String description, String grading_format, Double amt_requested) {
		super();
		this.staff_id = staff_id;
		this.date_requestor = Date.valueOf(date_requestor);
		this.date_start = Date.valueOf(date_start);
		this.date_end = Date.valueOf(date_end);
		this.location = location;
		this.event_type = event_type;
		this.description = description;
		this.grading_format = grading_format;
		this.amt_requested = amt_requested;
	}
	
	public int getStaff_id() {
		return this.staff_id;
	}
	
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	public Date getDate_requestor() {
		return this.date_requestor;
	}
	
	public void setDate_requestor(Date date_requestor) {
		this.date_requestor = date_requestor;
	}
	
	public Date getDate_start() {
		return this.date_start;
	}
	
	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}
	
	public Date getDate_end() {
		return this.date_end;
	}
	
	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getEvent_type() {
		return this.event_type;
	}
	
	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getGrading_format() {
		return this.grading_format;
	}
	
	public void setGrading_format(String grading_format) {
		this.grading_format = grading_format;
	}
	
	public Double getAmt_requested() {
		return this.amt_requested;
	}
	
	public void setAmt_requested(Double amt_requested) {
		this.amt_requested = amt_requested;
	}
	
	@Override
	public String toString() {
		return "RequestHelper [staff_id=" + this.staff_id + ", date_requestor=" + this.date_requestor + ", date_start="
			+ this.date_start + ", date_end=" + this.date_end + ", location=" + this.location + ", event_type="
			+ this.event_type + ", description=" + this.description + ", grading_format=" + this.grading_format
			+ ", amt_requested=" + this.amt_requested + "]";
	}

}

package dev.estillero.models;

import java.sql.Date;

public class RequestInfo {
	
	private int request_id;
	private int staff_id;
	private Date date_start;
	private Date date_end;
	private String location;
	private String event_type;
	private String description;
	private String grading_format;
	private String supporting_docs;
	private String passing_grade_verif;
	
	
	public RequestInfo() {
		super();
	}
	
	
	public RequestInfo(int staff_id, Date date_start, Date date_end, String location, String event_type,
		String description, String grading_format, String supporting_docs, String passing_grade_verif) {
		super();
		this.staff_id = staff_id;
		this.date_start = date_start;
		this.date_end = date_end;
		this.location = location;
		this.event_type = event_type;
		this.description = description;
		this.grading_format = grading_format;
		this.supporting_docs = supporting_docs;
		this.passing_grade_verif = passing_grade_verif;
	}
	
	
	public RequestInfo(int request_id, int staff_id, Date date_start, Date date_end, String location,
		String event_type, String description, String grading_format, String supporting_docs,
		String passing_grade_verif) {
		super();
		this.request_id = request_id;
		this.staff_id = staff_id;
		this.date_start = date_start;
		this.date_end = date_end;
		this.location = location;
		this.event_type = event_type;
		this.description = description;
		this.grading_format = grading_format;
		this.supporting_docs = supporting_docs;
		this.passing_grade_verif = passing_grade_verif;
	}
	
	public RequestInfo(int request_id, int staff_id, String date_start, String date_end, String location,
		String event_type, String description, String grading_format, String supporting_docs,
		String passing_grade_verif) {
		super();
		this.request_id = request_id;
		this.staff_id = staff_id;
		this.date_start = Date.valueOf(date_start);
		this.date_end = Date.valueOf(date_end);
		this.location = location;
		this.event_type = event_type;
		this.description = description;
		this.grading_format = grading_format;
		this.supporting_docs = supporting_docs;
		this.passing_grade_verif = passing_grade_verif;
	}
	
	
	public int getRequest_id() {
		return this.request_id;
	}
	
	
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	
	
	public int getStaff_id() {
		return this.staff_id;
	}


	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
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
	
	
	public String getSupporting_docs() {
		return this.supporting_docs;
	}
	
	
	public void setSupporting_docs(String supporting_docs) {
		this.supporting_docs = supporting_docs;
	}
	
	
	public String getPassing_grade_verif() {
		return this.passing_grade_verif;
	}
	
	
	public void setPassing_grade_verif(String passing_grade_verif) {
		this.passing_grade_verif = passing_grade_verif;
	}
	
	
	@Override
	public String toString() {
		return "RequestInfo [request_id=" + this.request_id + ", staff_id=" + this.staff_id + ", date_start="
			+ this.date_start + ", date_end=" + this.date_end + ", location=" + this.location + ", event_type="
			+ this.event_type + ", description=" + this.description + ", grading_format=" + this.grading_format
			+ ", supporting_docs=" + this.supporting_docs + ", passing_grade_verif=" + this.passing_grade_verif + "]";
	}
}

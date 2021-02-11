package dev.estillero.services;

import java.util.List;
import dev.estillero.models.Request;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;

public interface ApproverService {
	
	// Approver views one request
	public RequestStatus getRequestStatus(int request_id);
		
		
	// Approver views list of requests to respond to
	public List<RequestInfo> getPendingRequestsInfo(int staff_id);
		
		
	// Approver asks for additional info
	public boolean askEmployeeForAddtlInfo(RequestStatus rs);
	public boolean askSupervisorForAddtlInfo(RequestStatus rs);
		
		
	// Approver approves or denies request
	public boolean approve(int staff_id, RequestStatus rs);
	public boolean deny(int staff_id, RequestStatus rs);
		
		
	// Handling of supervisor's inattention
	// - checks to see whether supervisor attended to request in timely manner
	// - if true, auto-approve and mark that under addtlinfo_supervisor
	public boolean escalate(RequestStatus rs);
		
		
	// ONLY Supervisor confirms passing grade or satifactory presentation
	public boolean confirmGradePresentation(RequestInfo ri);
		
		
	// Approver views list of all requests that were sent to them
	// - may want to view as a request archive-record
	// - may want to access old grades or presentations
	public List<Request> getTheirRequests();

}

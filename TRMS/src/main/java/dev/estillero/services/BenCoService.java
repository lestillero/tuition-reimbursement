package dev.estillero.services;

import java.util.List;
import dev.estillero.models.FundInfo;
import dev.estillero.models.Request;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;

public interface BenCoService {
	
	// BenCo views one request
	public Request getRequest(int request_id);
	
	
	// BenCo views list of pending requests
	public List<RequestStatus> getStatusOFAllPendingRequests(); //uses RequestStatus
	
	
	// BenCo requests info from employee, supervisor, or dept head
	public boolean askEmployeeForAddtlInfo(RequestStatus rs);
	public boolean askSupervisorForAddtlInfo(RequestStatus rs);
	public boolean askDeptHeadForAddtlInfo(RequestStatus rs);
	
	
	// BenCo approves or denies request
	// - denying REQUIRES reason
	public boolean approve(RequestStatus rs);
	public boolean deny(RequestStatus rs);

	
	// BenCo updates amt_rewarded, affirms amt_reimbursed (paid)
	// - could be MORE or LESS than amt_requested
	// - addtlinfo_benco MUST provide reasoning under addtlinfo_benco
	public boolean awardAmt(FundInfo fi);
	public boolean alterAmt(FundInfo fi);
	public boolean reimburseAmt(FundInfo fi);
	
	
	// BenCo confirms passing grade (updates passing_grade_verif)
	public boolean verifyPassingGrade(RequestInfo ri);
	
	
	// BenCo views list of all request_ids of reimbursements
	// that are "Exceeding Available Funds"
	public List<Request> getAllExceedingAvailFunds();
	
	
	// BenCo views list of all requests
	// - may want to view as a request archive-record
	// - may want to compile list of popular courses
	public List<RequestInfo> getAllRequestInfo();
	public List<RequestStatus> getAllRequestStatus();
	public List<FundInfo> getAllFundInfo();
	
	public List<Request> getAllRequests();
	
}

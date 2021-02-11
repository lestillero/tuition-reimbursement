package dev.estillero.services;

import java.util.List;
import dev.estillero.models.Request;
import dev.estillero.models.RequestHelper;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;

public interface RequestorService {
	
	// Requestor creates new request
	public boolean createRequest(RequestHelper rh);
	
	//public boolean createRequestInfo(RequestInfo ri);
	//public boolean createRequestStatus(RequestStatus rs);
	//public boolean createFundInfo(FundInfo fi);
	
	
	// Requestor views one request
	public Request getRequest(int request_id);
	
	
	// Requestor views list of pending requests & their statuses
	public List<RequestInfo> getPendingRequestsInfo(int staff_id);
	
	
	// Requestor updates request_info with additional information
	public boolean answerAddtlInfo(int request_id, String info);
	
	
	// Requestor cancels request IFF Benco alters amt
	public boolean cancelRequest(Request r);
	
	
	// Requestor views list of all previous requests
	public List<RequestStatus> getMyRequestStatuses(int staff_id);

}

package dev.estillero.repository;

import java.util.List;
import dev.estillero.models.FundInfo;
import dev.estillero.models.RequestHelper;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;

public interface RequestRepo {

	// CREATE
	public boolean createRequest(RequestHelper rh);
	
	//public boolean createRequestInfo(RequestInfo ri);
	//public boolean createRequestStatus(RequestStatus rs);
	//public boolean createFundInfo(FundInfo fi);
	
	
	// READ	
	public RequestInfo getRequestInfo(int request_id);
	public RequestStatus getRequestStatus(int request_id);
	public FundInfo getFundInfo(int request_id);
	
	public List<RequestStatus> getMyRequestStatuses(int staff_id);
	public List<RequestInfo> getPendingRequestsInfo(int staff_id);
	public List<RequestInfo> getAllPendingRequestsInfo();

	
	// UPDATE
	public boolean updateRequestInfo(RequestInfo ri);
	public boolean updateRequestStatus(RequestStatus rs);
	public boolean updateFundInfo(FundInfo fi);
	
	
	// DELETE
	public boolean deleteRequest(int request_id);

}

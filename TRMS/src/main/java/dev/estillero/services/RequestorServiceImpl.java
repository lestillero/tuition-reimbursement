package dev.estillero.services;

import java.util.List;
import dev.estillero.models.Request;
import dev.estillero.models.RequestHelper;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;
import dev.estillero.repository.RequestRepo;
import dev.estillero.repository.RequestRepoImpl;

public class RequestorServiceImpl implements RequestorService {
	
	RequestRepo rr = new RequestRepoImpl();

	@Override
	public boolean createRequest(RequestHelper rh) {
		return rr.createRequest(rh);
	}

	@Override
	public Request getRequest(int request_id) {
		Request r = new Request();
		
		r.setRi(rr.getRequestInfo(request_id));
		r.setRs(rr.getRequestStatus(request_id));
		r.setFi(rr.getFundInfo(request_id));
		
		return r;
	}

	@Override
	public List<RequestInfo> getPendingRequestsInfo(int staff_id) {
		return rr.getPendingRequestsInfo(staff_id);
	}

	@Override
	public boolean answerAddtlInfo(int request_id, String info) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancelRequest(Request r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<RequestStatus> getMyRequestStatuses(int staff_id) {
		return rr.getMyRequestStatuses(staff_id);
	}

}

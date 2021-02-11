package dev.estillero.services;

import java.sql.Date;
import java.util.List;
import dev.estillero.models.FundInfo;
import dev.estillero.models.Request;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;
import dev.estillero.repository.RequestRepo;
import dev.estillero.repository.RequestRepoImpl;

public class ApproverServiceImpl implements ApproverService {
	
	RequestRepo rr = new RequestRepoImpl();

	@Override
	public RequestStatus getRequestStatus(int request_id) {
		return rr.getRequestStatus(request_id);
	}

	@Override
	public List<RequestInfo> getPendingRequestsInfo(int staff_id) {
		if (staff_id == 19) {
			return rr.getAllPendingRequestsInfo();
		} else {
			return rr.getPendingRequestsInfo(staff_id);
		}
	}

	@Override
	public boolean askEmployeeForAddtlInfo(RequestStatus rs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean askSupervisorForAddtlInfo(RequestStatus rs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean approve(int staff_id, RequestStatus rs) {
		RequestStatus approvedStatus = rs;
		Date today = new Date(System.currentTimeMillis());
		
		FundInfo approvedFund = rr.getFundInfo(approvedStatus.getRequest_id());
		Double amtAwarded = approvedFund.getAmt_requested();
		
		if (staff_id == 19) {
			approvedStatus.setDate_benco(today);
			approvedStatus.setAddtlinfo_benco("Approved");
			approvedStatus.setStatus("Pending grade");
			approvedFund.setAmt_awarded(amtAwarded);
		} else if (staff_id < 8) {
			approvedStatus.setDate_dept(today);
			approvedStatus.setAddtlinfo_dept("Approved");
			approvedStatus.setStatus("Pending BenCo");
		} else {
			approvedStatus.setDate_supervisor(today);
			approvedStatus.setAddtlinfo_supervisor("Approved");
			approvedStatus.setStatus("Pending Dept Head");
		}
		
		rr.updateRequestStatus(approvedStatus);
		return true;
		
	}

	@Override
	public boolean deny(int staff_id, RequestStatus rs) {
		RequestStatus deniedStatus = rs;
		Date today = new Date(System.currentTimeMillis());
		
		if (staff_id == 19) {
			deniedStatus.setDate_benco(today);
			deniedStatus.setAddtlinfo_benco("Denied");
			deniedStatus.setStatus("Denied");
		} else if (staff_id < 8) {
			deniedStatus.setDate_dept(today);
			deniedStatus.setAddtlinfo_dept("Denied");
			deniedStatus.setStatus("Denied");
		} else {
			deniedStatus.setDate_supervisor(today);
			deniedStatus.setStatus("Denied");
		}
		
		rr.updateRequestStatus(deniedStatus);
		return true;
		
	}

	@Override
	public boolean escalate(RequestStatus rs) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmGradePresentation(RequestInfo ri) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Request> getTheirRequests() {
		// TODO Auto-generated method stub
		return null;
	}

}

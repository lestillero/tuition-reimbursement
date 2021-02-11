package dev.estillero.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import dev.estillero.models.FundInfo;
import dev.estillero.models.RequestHelper;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;
import dev.estillero.util.JDBCConnection;

public class RequestRepoImpl implements RequestRepo {
	
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createRequest(RequestHelper rh) {
				
		System.out.println("TESTING TESTING");
		System.out.println(rh.getDate_requestor());
		System.out.println(rh.getDate_requestor().getClass());
		
//		Date datreq = new Date(rh.getDate_requestor().getTime()+5011200000L);
//		Date datstrt = new Date(rh.getDate_requestor().getTime()+5011200000L);
//		Date datend = new Date(rh.getDate_end().getTime()+5011200000L);
		
		try {
				
			String sql = "CALL create_request(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
				
			cs.setString(1, Integer.toString(rh.getStaff_id()));
			cs.setDate(2, rh.getDate_requestor());
			cs.setDate(3, rh.getDate_start());
			cs.setDate(4, rh.getDate_end());
			cs.setString(5, rh.getLocation());
			cs.setString(6, rh.getEvent_type());
			cs.setString(7, rh.getDescription());
			cs.setString(8, rh.getGrading_format());
			cs.setString(9, Double.toString(rh.getAmt_requested()));
			
			cs.execute();
			return true;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return false;
		
	}

	@Override
	public RequestInfo getRequestInfo(int request_id) {		
		try {
			
			String sql = "SELECT * FROM request_info WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(request_id));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				RequestInfo ri = new RequestInfo();
				ri.setRequest_id(rs.getInt("REQUEST_ID"));
				ri.setStaff_id(rs.getInt("STAFF_ID"));
				ri.setDate_start(rs.getDate("DATE_START"));
				ri.setDate_end(rs.getDate("DATE_END"));
				ri.setLocation(rs.getString("LOCATION"));
				ri.setEvent_type(rs.getString("EVENT_TYPE"));
				ri.setDescription(rs.getString("DESCRIPTION"));
				ri.setGrading_format(rs.getString("GRADING_FORMAT"));
				ri.setSupporting_docs(rs.getString("SUPPORTING_DOCS"));
				ri.setPassing_grade_verif(rs.getString("PASSING_GRADE_VERIF"));
				
				return ri;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public RequestStatus getRequestStatus(int request_id) {
		try {
			
			String sql = "SELECT * FROM request_status WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(request_id));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				RequestStatus r = new RequestStatus();
				r.setRequest_id(rs.getInt("REQUEST_ID"));
				r.setStatus(rs.getString("STATUS"));
				r.setDate_requestor(rs.getDate("DATE_REQUESTOR"));
				r.setAddtlinfo_requestor(rs.getString("ADDTLINFO_REQUESTOR"));
				r.setDate_supervisor(rs.getDate("DATE_SUPERVISOR"));
				r.setAddtlinfo_supervisor(rs.getString("ADDTLINFO_SUPERVISOR"));
				r.setDate_dept(rs.getDate("DATE_DEPT"));
				r.setAddtlinfo_dept(rs.getString("ADDTLINFO_DEPT"));
				r.setDate_benco(rs.getDate("DATE_BENCO"));
				r.setAddtlinfo_benco(rs.getString("ADDTLINFO_BENCO"));
				
				return r;
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public FundInfo getFundInfo(int request_id) {
		try {
			
			String sql = "SELECT * FROM fund_info WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(request_id));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				FundInfo fi = new FundInfo();
				fi.setRequest_id(rs.getInt("REQUEST_ID"));
				fi.setAmt_requested(rs.getDouble("AMT_REQUESTED"));
				fi.setAmt_awarded(rs.getDouble("AMT_AWARDED"));
				fi.setAmt_reimbursed(rs.getDouble("AMT_REIMBURSED"));
				
				return fi;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@Override
	public List<RequestStatus> getMyRequestStatuses(int staff_id) {
		List<RequestStatus> requests = new ArrayList<RequestStatus>();
		
		try {
			
			String sql = "SELECT staff_id, request_info.request_id, status, "
				+ "date_requestor, addtlinfo_requestor, date_supervisor, "
				+ "addtlinfo_supervisor, date_dept, addtlinfo_dept, "
				+ "date_benco, addtlinfo_benco FROM request_info INNER JOIN "
				+ "request_status ON "
				+ "request_info.request_id = request_status.request_id WHERE "
				+ "staff_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(staff_id));
			
			ResultSet rs = ps.executeQuery();
			System.out.println(rs);
			
			while (rs.next()) {
				
				RequestStatus r = new RequestStatus();
				r.setRequest_id(rs.getInt("REQUEST_ID"));
				r.setStatus(rs.getString("STATUS"));
				r.setDate_requestor(rs.getDate("DATE_REQUESTOR"));
				r.setAddtlinfo_requestor(rs.getString("ADDTLINFO_REQUESTOR"));
				r.setDate_supervisor(rs.getDate("DATE_SUPERVISOR"));
				r.setAddtlinfo_supervisor(rs.getString("ADDTLINFO_SUPERVISOR"));
				r.setDate_dept(rs.getDate("DATE_DEPT"));
				r.setAddtlinfo_dept(rs.getString("ADDTLINFO_DEPT"));
				r.setDate_benco(rs.getDate("DATE_BENCO"));
				r.setAddtlinfo_benco(rs.getString("ADDTLINFO_BENCO"));
				
				requests.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return requests;
		
	}

	@Override
	public List<RequestInfo> getPendingRequestsInfo(int staff_id) {
		List<RequestInfo> pending = new ArrayList<RequestInfo>();
		
		try {
			
			String sql = "SELECT request_id, staff.staff_id, supervisor_id, "
				+ "dept_id FROM request_info INNER JOIN staff ON "
				+ "request_info.staff_id = staff.staff_id WHERE "
				+ "supervisor_id = ? OR dept_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(staff_id));
			ps.setString(2, Integer.toString(staff_id));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				RequestInfo ri = new RequestInfo();
				ri.setRequest_id(rs.getInt("REQUEST_ID"));
				ri.setStaff_id(rs.getInt("STAFF_ID"));
								
				pending.add(ri);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pending;
		
	}
	
	@Override
	public List<RequestInfo> getAllPendingRequestsInfo() {
		List<RequestInfo> pending = new ArrayList<RequestInfo>();
		
		try {
			
			String sql = "SELECT request_id, staff.staff_id, supervisor_id, "
				+ "dept_id FROM request_info INNER JOIN staff ON "
				+ "request_info.staff_id = staff.staff_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				RequestInfo ri = new RequestInfo();
				ri.setRequest_id(rs.getInt("REQUEST_ID"));
				ri.setStaff_id(rs.getInt("STAFF_ID"));
				
				pending.add(ri);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pending;
		
	}
	
	@Override
	public boolean updateRequestInfo(RequestInfo ri) {
		try {
			
			String sql = "UPDATE request_info SET "
				+ "staff_id = ?, date_start = ?, date_end = ?, location = ?, "
				+ "event_type = ?, description = ?, grading_format = ?, "
				+ "supporting_docs = ?, passing_grade_verif = ? "
				+ "WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(ri.getStaff_id()));
			ps.setString(2, ri.getDate_start().toString());
			ps.setString(3, ri.getDate_end().toString());
			ps.setString(4, ri.getLocation());
			ps.setString(5, ri.getEvent_type());
			ps.setString(6, ri.getDescription());
			ps.setString(7, ri.getGrading_format());
			ps.setString(8, ri.getSupporting_docs());
			ps.setString(9, ri.getPassing_grade_verif());
			ps.setString(10, Integer.toString(ri.getRequest_id()));
			
			ps.executeQuery();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean updateRequestStatus(RequestStatus rs) {
		try {
			
			String sql = "UPDATE request_status SET "
				+ "status = ?, date_requestor = ?, addtlinfo_requestor = ?, "
				+ "date_supervisor = ?, addtlinfo_supervisor = ?, "
				+ "date_dept = ?, addtlinfo_dept = ?, "
				+ "date_benco = ?, addtlinfo_benco = ? WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, rs.getStatus());
			ps.setDate(2, rs.getDate_requestor());
			ps.setString(3, rs.getAddtlinfo_requestor());
			ps.setDate(4, rs.getDate_supervisor());
			ps.setString(5, rs.getAddtlinfo_supervisor());
			ps.setDate(6, rs.getDate_dept());
			ps.setString(7, rs.getAddtlinfo_dept());
			ps.setDate(8, rs.getDate_benco());
			ps.setString(9, rs.getAddtlinfo_benco());
			ps.setString(10, Integer.toString(rs.getRequest_id()));
			
			ps.executeQuery();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean updateFundInfo(FundInfo fi) {
		try {
			
			String sql = "UPDATE fund_info SET "
				+ "amt_requested = ?, amt_awarded = ?, "
				+ "amt_reimbursed = ? WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Double.toString(fi.getAmt_requested()));
			ps.setString(2, Double.toString(fi.getAmt_awarded()));
			ps.setString(3, Double.toString(fi.getAmt_reimbursed()));
			ps.setString(4, Integer.toString(fi.getRequest_id()));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

	@Override
	public boolean deleteRequest(int request_id) {
		try {
			
			String sql = "DELETE request_info WHERE request_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(request_id));
			
			ps.executeQuery();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}

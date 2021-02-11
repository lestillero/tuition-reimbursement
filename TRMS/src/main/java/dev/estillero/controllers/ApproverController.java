package dev.estillero.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import dev.estillero.models.RequestInfo;
import dev.estillero.models.RequestStatus;
import dev.estillero.models.Staff;
import dev.estillero.services.ApproverService;
import dev.estillero.services.ApproverServiceImpl;

public class ApproverController {

	public static ApproverService as = new ApproverServiceImpl();
	public static Gson gson = new Gson();

	public static void getPendingRequestsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		Staff loggedInStaff = (Staff) session.getAttribute("loggedIn");
		System.out.println(loggedInStaff);

		int loggedInStaffId = loggedInStaff.getStaff_id();
		System.out.println(loggedInStaffId);

		List<RequestInfo> pending = as.getPendingRequestsInfo(loggedInStaffId);
		System.out.println(pending);

		response.getWriter().append((!(pending.isEmpty())) ? gson.toJson(pending) : "{}");

	}
	
	public static void approve(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		RequestStatus reqid = gson.fromJson(request.getReader(), RequestStatus.class);
		
		RequestStatus rs = as.getRequestStatus(reqid.getRequest_id());
		System.out.println(rs);
		
		HttpSession session = request.getSession();
		Staff loggedInStaff = (Staff) session.getAttribute("loggedIn");
		System.out.println(loggedInStaff);
		
		int loggedInStaffId = loggedInStaff.getStaff_id();
		System.out.println(loggedInStaffId);
		
		as.approve(loggedInStaffId, rs);
		
	}
	
public static void deny(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		RequestStatus reqid = gson.fromJson(request.getReader(), RequestStatus.class);
	
		RequestStatus rs = as.getRequestStatus(reqid.getRequest_id());
		System.out.println(rs);
		
		HttpSession session = request.getSession();
		Staff loggedInStaff = (Staff) session.getAttribute("loggedIn");
		System.out.println(loggedInStaff);
		
		int loggedInStaffId = loggedInStaff.getStaff_id();
		System.out.println(loggedInStaffId);
		
		as.deny(loggedInStaffId, rs);
		
	}
	
	

}

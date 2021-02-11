package dev.estillero.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import dev.estillero.models.Request;
import dev.estillero.models.RequestHelper;
import dev.estillero.models.RequestStatus;
import dev.estillero.models.Staff;
import dev.estillero.services.RequestorService;
import dev.estillero.services.RequestorServiceImpl;

public class RequestorController {
	
	public static RequestorService rs = new RequestorServiceImpl();
	public static Gson gson = new Gson();
	public static GsonBuilder gsonbuilder = new GsonBuilder();
	
	public static void createRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		gsonbuilder.setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz");
				
		RequestHelper rh = gsonbuilder.create().fromJson(request.getReader(), RequestHelper.class);
		System.out.println(rh);
		
		HttpSession session = request.getSession();
		System.out.println(session);
		
		Staff loggedInStaff = (Staff) session.getAttribute("loggedIn");
		System.out.println(loggedInStaff);
		
		int loggedInStaffId = loggedInStaff.getStaff_id();
		System.out.println(loggedInStaffId);
		
		rh.setStaff_id(loggedInStaffId);
		System.out.println(rh);
		
		boolean success = rs.createRequest(rh);
		response.getWriter().append((success) ? gson.toJson(rh) : "{}");
			
	}
	
	public static void getRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("rid");
		
		int requestId;
		
		try {
			requestId = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "rid parameter incorrectly formatted");
			return;
		}
		
		Request r = rs.getRequest(requestId);
		
		response.getWriter().append((r != null) ? gson.toJson(r) : "{}");
		
	}
	
	public static void getMyRequestStatuses(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		Staff loggedInStaff = (Staff) session.getAttribute("loggedIn");
		System.out.println(loggedInStaff);
		
		int loggedInStaffId = loggedInStaff.getStaff_id();
		System.out.println(loggedInStaffId);
		
		List<RequestStatus> statuses = rs.getMyRequestStatuses(loggedInStaffId);
		System.out.println(statuses);
		
		response.getWriter().append((!(statuses.isEmpty())) ? gson.toJson(statuses) : "{}");
		
	}

}

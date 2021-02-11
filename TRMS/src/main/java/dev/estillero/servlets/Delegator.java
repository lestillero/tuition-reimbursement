package dev.estillero.servlets;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.estillero.controllers.ApproverController;
import dev.estillero.controllers.LoginController;
import dev.estillero.controllers.RequestorController;

public class Delegator {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String uri = request.getRequestURI();

		System.out.println(uri);

		switch(uri) {
				
			case "/TRMS/login.do": {
				LoginController.login(request, response);
				break; }
			
			case "/TRMS/createRequest.do": {
				RequestorController.createRequest(request, response);
				break; }
			
			case "/TRMS/getMyRequestStatuses.do": {
				RequestorController.getMyRequestStatuses(request, response);
				break; }
			
			case "/TRMS/getRequest.do": {
				RequestorController.getRequest(request, response);
				break; }
			
			case "/TRMS/getPendingRequestsInfo.do": {
				ApproverController.getPendingRequestsInfo(request, response);
				break; }
			
			case "/TRMS/approve.do": {
				ApproverController.approve(request, response);
				break; }
			
			case "/TRMS/deny.do": {
				ApproverController.deny(request, response);
				break; }
			
			default: {
				response.sendError(418, "Default case hit");
				break;
			}
		}

	}

}

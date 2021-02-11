package dev.estillero.controllers;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import dev.estillero.models.Staff;
import dev.estillero.services.LoginService;
import dev.estillero.services.LoginServiceImpl;

public class LoginController {
	
	public static LoginService ls = new LoginServiceImpl();
	public static Gson gson = new Gson();
	
	public static void login(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		
		String firstName = request.getParameter("fn");
		String lastName = request.getParameter("ln");
		
		Staff s = ls.login(firstName, lastName);
		
		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", s);
		
	}

}

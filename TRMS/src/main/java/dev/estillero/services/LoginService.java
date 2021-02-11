package dev.estillero.services;

import dev.estillero.models.Staff;

public interface LoginService {
	
	public Staff login(String first_name, String last_name);

}

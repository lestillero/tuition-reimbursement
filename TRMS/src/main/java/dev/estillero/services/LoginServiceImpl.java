package dev.estillero.services;

import java.util.ArrayList;
import java.util.List;
import dev.estillero.models.Staff;
import dev.estillero.repository.StaffRepo;
import dev.estillero.repository.StaffRepoImpl;

public class LoginServiceImpl implements LoginService {

	StaffRepo sr = new StaffRepoImpl();
	
	@Override
	public Staff login(String first_name, String last_name) {
		//need to find the right name and grab the Staff object?
		//- really want to pull id for setAttribute
		//- probably need supervisor_id and dept_id
		
		//STEPS
		//look up last name
		//		if last name is not found, return false
		//		else, cycle through list and find particular Staff that matches first name as well
		List<Staff> sameLastName = sr.getStaffByLastName(last_name);
		
		if (sameLastName.isEmpty()) {
			System.out.println("There is no Staff member with last name given.");
			return null;
		} else {
			
			List<Staff> sameFirstNameToo = new ArrayList<Staff>();
			
			for (Staff s : sameLastName) {
				if (s.getFirst_name().equals(first_name)) {
					sameFirstNameToo.add(s);
				}
			}
			
			if (sameFirstNameToo.isEmpty()) {
				System.out.println("There is no Staff member with first name given.");
				return null;
			} else if (sameFirstNameToo.size() > 1) {
				System.out.println("There are too many people with the same first name and last name!");
				return null;
			} else {
				System.out.println("Successfully logged in!");
				System.out.println(sameFirstNameToo.get(0));
				return sameFirstNameToo.get(0);
			}
			
		}
		
	}

}

package com.caresoft.clinicappp;
import java.util.Date;
import java.util.ArrayList;

//... imports class definition...
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	// Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    //overload 
    public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}

    // TO DO: Implement a constructor that takes an ID and a role
    //HIPAACompliantUser methods
    public boolean assignPin(int pin){
    	if(String.valueOf(pin).length() < 4) {
    		System.out.println("Please enter PIN of at least 4 numbers");
    		return false;
    	}
    	else { 
    		this.pin = pin;
    		return true;
    	}	
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID){
    	if(confirmedAuthID == this.id) {
    		System.out.println("Authorized");
    		return true;
    	}
    	else{
    		System.out.println("Not Authorized!");
    		newIncident("Note");
    		return false;
    	}
    }
    // TO DO: Implement HIPAACompliantAdmin!
    @Override
    public ArrayList<String> reportSecurityIncidents() {
    	// TODO Auto-generated method stub
    	return this.getSecurityIncidents();
    }
    
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        if(securityIncidents == null) {
        	String test = "Example";
        	securityIncidents.add(test);
        	securityIncidents.add(report);
        }
        else {
        System.out.println(report);
        securityIncidents.add(report);
        }
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    
    // TO DO: Setters & Getters
	public Integer getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}



}

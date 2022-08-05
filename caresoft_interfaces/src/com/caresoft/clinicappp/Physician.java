package com.caresoft.clinicappp;
import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
	private int pin;
	private boolean accessAuthorized;

	// Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
        public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
    // TO DO: Implement HIPAACompliantUser!
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
	    		return false;
	    	}
	    }
	    
	    //getters and setters source > generate getters/setters select all yeehaw
	    public int getPin() {
			return pin;
		}
	    //this is handled above
//		public void setPin(int pin) {
//			this.pin = pin;
//		}
		public boolean isAccessAuthorized() {
			return accessAuthorized;
		}
		public void setAccessAuthorized(boolean accessAuthorized) {
			this.accessAuthorized = accessAuthorized;
		}
		public ArrayList<String> getPatientNotes() {
			return patientNotes;
		}
		public void setPatientNotes(ArrayList<String> patientNotes) {
			this.patientNotes = patientNotes;
		}
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

}

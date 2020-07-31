package event.management;

import java.util.ArrayList;
import java.util.Collections;

public class Management {
	public ArrayList<Attendant> attendants;
	
	public Management() {
		attendants = new ArrayList<Attendant>();
	}
	// isNoAttendant
	private boolean isNoAttendant() {
		if (attendants.size()==0) return true;
		else return false;
	}
	
	// Check if the seat is empty
	private boolean seatIsEmpty(int seat) {
		if (isNoAttendant())
			return true;
		else {
			for (Attendant a: attendants) {
				if (seat == a.getSeatLocation())
					return false;
			}
		}
		return true;
	}
	// Add attendant
	public String addAttendant(String firstName, String lastName, int age, int seatLocation, double moneyPaid) {
		Attendant person = new Attendant(firstName, lastName, age, seatLocation, moneyPaid);
		if (seatIsEmpty(person.getSeatLocation())) {
			attendants.add(person);
			return "Sucessfully Added. Thank you!\n";
		}
		else {
			return("Failed to add "+person.getFirstName()+" "+person.getLastName()+" to seat number "+person.getSeatLocation()+".\n"+
								"This seat have been occupied. Please choose another seat...\n");
		}
	}
	
	// Remove attendant
	public String removeAttendant(int seatLocation) {
		ArrayList<Object> toBeRemoved = new ArrayList<Object>();
		StringBuilder response = new StringBuilder();
		for (Attendant a: attendants) {
			if (a.getSeatLocation()==seatLocation) {
				toBeRemoved.add(a);
				response.append("Attendant ("+a.getFirstName()+" "+a.getLastName()+") has been removed!\n");
			}
		}
		
		if (toBeRemoved.size()==0)
			return "Error: The chosen seat is empty\n";
		else {
			attendants.removeAll(toBeRemoved);
			return response.toString();
		}
	}
	// Show seat map
	private String showSeatMap() {
		StringBuilder seatMap = new StringBuilder();
		for (Attendant a: attendants) {
			seatMap=seatMap.append(a.getFirstName()+" "+a.getLastName()+" at seat "+a.getSeatLocation()+"\n");
		}
		return seatMap.toString();
	}
	
	// Calculate revenue
	private String calculateRevenue() {
		double revenue = 0;
		for (Attendant a: attendants) {
			revenue += a.getMoneyPaid();
		}
		return "\nTotal Revenue: $"+revenue;
	}
	// Get highest payers
	private String getHighestPayers() {
		ArrayList<Double> moneyPaid = new ArrayList<Double>();
		for (Attendant a: attendants) {
			moneyPaid.add(a.getMoneyPaid());
		}
		Double highestPaidAmount = Collections.max(moneyPaid);
		StringBuilder highestPayers = new StringBuilder();
		highestPayers.append("\nHighest Payer(s):\n");
		for (Attendant a: attendants) {
			if (a.getMoneyPaid()==highestPaidAmount) {
				highestPayers.append(a.getFirstName()+" "+a.getLastName()+"\n");
			}
		}
		return highestPayers.toString();
	}
	// Show Attendants
	
	
	// Show Management Report
	public String showReport() {
		if (isNoAttendant())
			return "                      No Attendants Yet\n";
		else {
			String report =   ("################################"
							+"\n#               Attendance Report               #"
							+"\n################################"
							+"\n"+showSeatMap()
							+"\n"+calculateRevenue()
							+"\n"+getHighestPayers()
							+"\n################################");
			return report;
		}
	}
	// Show Number of Attendants
	public void getSize() {
		System.out.println(attendants.size());
	}
	public ArrayList<Attendant> getAttendants(){
		return this.attendants;
	}
}

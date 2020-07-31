package event.management;

public class Attendant {
	private String firstName;
	private String lastName;
	private int age;
	private int seatLocation;
	private double moneyPaid;
	
	public Attendant(String firstName, String lastName, int age, int seatLocation, double moneyPaid) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.seatLocation = seatLocation;
		this.moneyPaid = moneyPaid;
	}

	//Setters and Getters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public int getSeatLocation() {
		return seatLocation;
	}
	public void setSeatLocation(int seatLocation) {
		this.seatLocation = seatLocation;
	}

	public double getMoneyPaid() {
		return moneyPaid;
	}
	public void setMoneyPaid(float moneyPaid) {
		this.moneyPaid = moneyPaid;
	}
	
	// Show Info Function
	public void showInfo() {
		System.out.println("Name: " + firstName +" "+ lastName
						+"\nAge: " + age
						+"\nSeat Location: " + seatLocation
						+"\nMoney Paid: " + moneyPaid+"\n");
		
	}
}

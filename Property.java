/*
 * Class: CMSC203 CRN: 22507
 * Assignment 4
 * Instructor: Farnaz Eivaz
 * 
 * Description:Data Element Class named Property that has fields to hold the property name, the 
 * city where the property is located, the rent amount, the owner's name, and the Plot to be 
 * occupied by the property, along with getters and setters to access and set these fields. Write 
 * a parameterized constructor (i.e., takes values for the fields as parameters) and a copy 
 * constructor (takes a Property object as the parameter).  
    
 * Due: 10/20/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
public class Property {
	
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0;
		this.plot = new Plot();	
	}
	
	//Copy Constructor
	public Property(Property p) {
		city = p.city;
		owner = p.owner;
		propertyName = p.propertyName;
		rentAmount = p.rentAmount;	
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(0, 0, 1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, 
	int y, int width, int depth) {
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x, y, width, depth);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public void setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x, y, width, depth);
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	@Override
	public String toString() {
		return ("Property Name: " + this.propertyName + "\n Located in " + this.city + 
				"\n Belonging to: " + this.owner + "\n Rent Amount: " + this.rentAmount);
	}


}
//Abraham Lamidi wrote this code.

/*
 * Class: CMSC203 CRN: 22507
 * Assignment 4
 * Instructor: Farnaz Eivaz
 * 
 * Description:  Data Manager Class that has fields specifying the name, TaxID, number of 
 * properties and array of properties, fees, and maximum size of plot .
    
 * Due: 10/20/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/

public class ManagementCompany {
	
	private String name;
	private String taxID;
	private Property[] properties;
	private double mgmFeePer;
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	private int numberOfProperties = 0;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y,int width, 
			int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x,y,width,depth);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public Plot getPlot() {
		return plot; 
	}
	
	public int addProperty(Property property) {
		 
		boolean notContain = false;
		
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		if (numberOfProperties >= MAX_PROPERTY) {
			return -1;
		}

		if (property == null) {
			return -2;
		}

		if (this.plot.encompasses(property.getPlot()) == notContain) {
			return -3;
		} 
		
		if (numberOfProperties < MAX_PROPERTY){
			properties[numberOfProperties] = property;
			numberOfProperties++;
		}
		
		return numberOfProperties-1;
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		int version2;
		version2 = addProperty(new Property(name, city, rent, owner));
		return version2;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, 
			int width, int depth) {
		int version3;
		version3 = addProperty(new Property(name, city, rent, owner, x, y, width, depth));
		return version3;
	}
	
	public double totalRent() {
		
		double total = 0.0;
		for (int i = 0; i < numberOfProperties; i++) {
			total += properties[i].getRentAmount();
		}
		return total;
		
	}
	
	public double maxRentProp() {
		
		double _maxRent = 0.0;
		_maxRent = properties[maxRentPropertyIndex()].getRentAmount();
		return _maxRent;
	}
	
	public int maxRentPropertyIndex() {
		
		int count = 0;
		double maximumRent = properties[count].getRentAmount();
		double rent_Amount;
		
		for(int i = 0; i < numberOfProperties; i++){	
			rent_Amount = properties[i].getRentAmount();
			
			if(!(properties[i] == null)){
				if(rent_Amount > maximumRent){
					count = i;
					maximumRent = rent_Amount;
				}
			}
			
		}
		
		return count; 
	}
	
	public String displayPropertyAtIndex(int i) {
		
		String index = "";
		if (properties[i] != null) {
			index = ("Owner: " + properties[i].getOwner() + "City: " + properties[i].getCity() 
					+ "Property Name: " + properties[i].getPropertyName() + "Rent Amount: " 
					+ properties[i].getRentAmount() + "Plot: " + properties[i].getPlot());
		}
		return index;
	
	}
	
	public String toString() {
		
		String print = "";
		System.out.println("List of the properties for Alliance, taxID: " + taxID);
		System.out.println("__________________________________________________");
		for (int i = 0; i < numberOfProperties; i++) {
			if (properties[i] != null) {
				print = (" Property Name: " + properties[i].getPropertyName() + "\n" 
			+ "  Located in: " + properties[i].getCity() + "\n" + "  Belonging to: " 
			+ properties[i].getOwner() + "\n" + "  Rent Amount: " + properties[i].getRentAmount());
				}
			System.out.println(print);
		}
		System.out.println("__________________________________________________");
		return("Total management Fee: " + ((mgmFeePer * totalRent()) / 100.0));
	}


}
//Abraham Lamidi wrote this code.
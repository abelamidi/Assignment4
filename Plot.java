/*
 * Class: CMSC203 CRN: 22507
 * Assignment 4
 * Instructor: Farnaz Eivaz
 * 
 * Description: Data Element Class named Plot that has fields specifying the X and Y location of 
 * the upper left corner of each Plot and a depth and width of each Plot.  Notice that the X, Y 
 * location is at the upper left, not as in normal Cartesian coordinates, due to the grid system 
 * adopted by computer monitors. 
    
 * Due: 10/20/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
public class Plot {
	
	private int x;
	private int y;
	private int width;
	private int depth;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(Plot p) { 
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public boolean overlaps(Plot p) {
		
		boolean overlap = true; 
		int parameterX = p.x;
		int xPlot = x; 
		int width1 = width; 		
		int yPlot = y; 
		int depth1 = depth; 
		boolean notOverlapping = false; 
		
		if(parameterX >= xPlot + width1 || (parameterX + p.width) <= xPlot)
		{
			overlap = notOverlapping;
		}
		
		if(p.y >= yPlot + depth1  || (p.y + p.depth) <= yPlot)
		{
			overlap = notOverlapping;
		}
		
		return overlap;
		
	}
	
	public boolean encompasses(Plot p) {
		
		int valX = p.x;
		int valY = p.y;
		int valWidth = p.width;
		int valDepth = p.depth;
		
		return valX >= x && valY >= y && valX + valWidth <= x + width && valY + valDepth <= 
				y + depth;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	@Override
	public String toString(){
		return ("Upper left: (" + this.x + "," + this.y + "); Width: " + this.width + " Depth: "
				+ this.depth);
	}

}
//Abraham Lamidi wrote this code.
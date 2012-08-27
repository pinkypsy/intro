/**
 * file:RGBColor.java
 * @author Ohad Cohen, ohadcn@cs.huji.ac.il
 * exercise : intro2cs ex8 2011-2012 
 * description: This class represents a color,
 *  defined by its red, green and blue components.
 */
public class RGBColor implements Comparable<RGBColor>{
	
	/**
	 * those variables store the color
	 */
	private int red, green, blue;
	
	/**
	 * Construct a new RGBColor with the given color component values.
	 * Assumes the given values are legal (in the range 0-255).
	 * @param red The red color component value.
	 * @param green The green color component value.
	 * @param blue The blue color component value.
	 */
	public RGBColor(int red, int green, int blue) {
		this.red=red;
		this.green=green;
		this.blue=blue;
	}
	
	/**
	 * Construct a new RGBColor which is a copy of the given color.
	 * Assumes the given color is not null.
	 * @param other The RGBColor to copy.
	 */
	public RGBColor(RGBColor other) {
		this(other.red,other.green,other.blue);
	}
	
	/**
	 * Construct a black RGBColor.
	 */
	public RGBColor() {
		this(0,0,0);
	}
	
	/**
	 * Returns the red color component value of this RGBColor.
	 * @return the red color component value of this RGBColor.
	 */
	public int getRed() {
		return red;
	}
	
	/**
	 * Returns the green color component value of this RGBColor.
	 * @return the green color component value of this RGBColor.
	 */
	public int getGreen() {
		return green;
	}
	
	/**
	 * Returns the blue color component value of this RGBColor.
	 * @return the blue color component value of this RGBColor.
	 */
	public int getBlue() {
		return blue;
	}
	
	/**
	 * Sets the red color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 * @param red The red color component value to set.
	 */
	public void setRed(int red) {
		this.red=red;
	}
	
	/**
	 * Sets the green color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 * @param green The green color component value to set.
	 */	
	public void setGreen(int green) {
		this.green=green;
	}
	
	/**
	 * Sets the blue color component value of this RGBColor.
	 * Assumes the given value is legal (in the range 0-255).
	 * @param blue The blue color component value to set.
	 */		
	public void setBlue(int blue) {
		this.blue=blue;
	}
	
	/**
	 * Inverts the color of this RGBColor,
	 */
	public void invert() {
		red=255-red;
		green=255-green;
		blue=255-blue;
	}
	
	/**
	 * Changes this color to be a mix of this and other RGBColors.
	 * @param other The other color.
	 */
	public void mix(RGBColor other) {
		red=(red+other.red)/2;
		green=(green+other.green)/2;
		blue=(blue+other.blue)/2;
	}
	
	/**
	 * Returns the grayscale value of this RGBColor.
	 * @return The grayscale value of this RGBColor
	 */
	public float convertToGrayscale() {
		return (float) (red*.3 + green*.59 + blue*.11);
	}
	
	/**
	 * Compares this and other color. Returns true if this and other are the same RGBcolor.
	 * @param other the other color to be compared with.
	 * @return true if the RGBColors are equal; false otherwise.
	 */
	public boolean equals(RGBColor other) {
		return ((red==other.red)&&
				(green==other.green)&&
				(blue==other.blue));
	}

	/**
	 * Compares this object with the specified object for order.
	 *  Returns a negative integer, zero, or a positive integer 
	 *  as this object is less than, equal to, or greater than the specified object.
	 *  @param o the object to be compared. 
	 *  @return a negative integer, zero, or a positive integer 
	 *  as this object is less than, equal to, or greater than the specified object.
	 */
	public int compareTo(RGBColor o) {
		if(compare(this.convertToGrayscale(),o.convertToGrayscale())!=0)
			return compare(this.convertToGrayscale(),o.convertToGrayscale());
		
		if(compare(this.getRed(),o.getRed())!=0)
			return compare(this.getRed(),o.getRed());
		
		if(compare(this.getGreen(),o.getGreen())!=0)
			return compare(this.getGreen(),o.getGreen());
		
		return compare(this.getBlue(),o.getBlue());
				
	}
	
	/**
	 * this method compares two numbers
	 * returns 1 if the first is greater, -1 if the 2nd is greater or 0 if they are equal
	 * @param a the first number
	 * @param b the 2nd number to compare
	 * @return 1 if a is greater, -1 if b is greater or 0 if a & b are equals
	 */
	private static int compare(double a,double b) {
		if(a==b)
			return 0;
		if(a<b)
			return -1;
		//b<a
		return 1;
	}
}
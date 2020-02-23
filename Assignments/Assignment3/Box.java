
public class Box extends Rectangle {
	
	private double height;
	
	public Box (double width, double length, double height) {
		super(width, length);
		this.height = height;
	}
	
	@Override
	public double getArea() {
		return (2 * (this.width * this.length)) + (2 * (this.width * this.height)) + (2 * (this.length * this.height));
	}
	
} // end of class Box

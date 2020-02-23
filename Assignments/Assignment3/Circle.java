
public class Circle implements Measurable {
	
	public double radius;
	
	public Circle (double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return (Math.PI * Math.pow(this.radius, 2));
	}
}

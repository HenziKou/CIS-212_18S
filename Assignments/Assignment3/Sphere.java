
public class Sphere extends Circle {
	
	public Sphere (double radius) {
		super(radius);
	}
	
	@Override
	public double getArea() {
		return (4 * (Math.PI * Math.pow(this.radius, 2)));
	}
}

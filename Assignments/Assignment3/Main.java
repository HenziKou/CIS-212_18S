import java.util.Random;
import java.util.ArrayList;
import java.lang.Double;

public class Main {
	
	static int _rects = 0;
	static int _boxes = 0;
	static int _circles = 0;
	static int _spheres = 0;
	
	public static void main (String [] args) {
		
		ArrayList <Measurable> values = new ArrayList <> ();	// create a list
		Random rand = new Random();
		
		for (int i = 1; i < 1000; i++) { 	// populate list with 1000 random instances
			int num = rand.nextInt(4);
			
			if (num == 0) {
				Rectangle r = new Rectangle(nextDouble(), nextDouble());
				values.add(r);
				_rects++;
			} else if (num == 1) {
				Box b = new Box(nextDouble(), nextDouble(), nextDouble());
				values.add(b);
				_boxes++;
			} else if (num == 2) {
				Circle c = new Circle(nextDouble());
				values.add(c);
				_circles++;
			} else {
				Sphere s = new Sphere(nextDouble());
				values.add(s);
				_spheres++;
			}
		} // end of for loop
		
		System.out.println("rects: " + _rects + " boxes: " + _boxes + " circles: " + _circles + " spheres: " + _spheres);
		System.out.println("sum: " + calculateSum(values));
		
	} // end of main method
	
	private static double nextDouble() {
			
		Random ranDouble = new Random();
		return ranDouble.nextDouble() + Double.MIN_VALUE;		// Hint: use 'Random.nextDouble() + Double.MIN_VALUE'
			
	} // end of nextDouble method
		
	private static double calculateSum (ArrayList <Measurable> values) {
		
		double sum = 0;
			
		for (int i = 0; i < values.size(); i++) {
			sum += values.get(i).getArea();
		}
			
		return sum;
			
	} // end of calculateSum method
		
} // end of class main

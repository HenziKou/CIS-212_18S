import java.awt.Color;
import java.awt.Point;

public class MainPoints
{
	private final Point point;
	private final Color currColor;
	private final int size;
	
	public MainPoints(Point point, Color color, int size)
	{
		this.point = point;
		this.currColor = color;
		this.size = size;
	} // end MainPoint constructor
	
	public int x_loc()
	{
		return (int) point.getX();
	}
	
	public int y_loc()
	{
		return (int) point.getY();
	}
	
	public Color getColor()
	{
		return this.currColor;
	}
	
	public int currSize()
	{
		return this.size;
	}
	
} // end MainPoints class

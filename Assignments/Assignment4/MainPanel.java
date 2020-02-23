import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;			// Mouse listener
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

import java.util.ArrayList;

public class MainPanel extends JPanel
{
	private ArrayList<MainPoints> points;
	private int size = 10;
	private Color currColor;
	
	public MainPanel()
	{
		points = new ArrayList<MainPoints> ();
		currColor = Color.BLACK;
		
		// listener for when mouse is dragged
		addMouseMotionListener(
				new MouseMotionAdapter()
				{
					@Override
					public void mouseDragged(MouseEvent event)
					{
						points.add(new MainPoints(event.getPoint(), currColor, size));
						repaint();
						
						System.out.println(points.size() + ": x = " + points.get(points.size() - 1).x_loc() + " y = " + points.get(points.size() - 1).y_loc());
					}
				}
		); // end addMouseMotionListener
		
		// listener for when mouse is clicked
		addMouseListener(
				new MouseAdapter()
				{
					@Override
					public void mousePressed(MouseEvent event)
					{
						points.add(new MainPoints(event.getPoint(), currColor, size));
						repaint();
						
						System.out.println(points.size() + ": x = " + points.get(points.size() - 1).x_loc() + " y = " + points.get(points.size() - 1).y_loc());
					}
				}
		);
	} // end MainPanel constructor
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		
		for (MainPoints point: points)
		{
			graphics.setColor(point.getColor());
			graphics.fillOval(point.x_loc(), point.y_loc(), point.currSize(), point.currSize());
		}
	}
	
	public void setColor(Color currColor, Graphics graphics)
	{
		this.currColor = currColor;
	}
	
	public void currSize(int size)
	{
		this.size = size;
	}
	
	public void clear()
	{
		points = new ArrayList<MainPoints>();
		repaint();
	}
	
} // end MainPanel class

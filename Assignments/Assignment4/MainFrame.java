import java.awt.BorderLayout;			// Specifies how components are arranged
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;				// Provides interactive buttons
import javax.swing.JFrame;				// Provides basic window features
import javax.swing.JPanel;


public class MainFrame extends JFrame
{
	private final JButton button1;
	private final JButton button2;
	private final JButton button3;
	private final JButton button4;
	private final JButton button5;
	private final JButton button6;
	private final JButton button7;
	private final JButton button8;
		
	public MainFrame()
	{
		setLayout(new BorderLayout());					// horizontal layout
		
		// Create main center panel
		MainPanel mainPanel = new MainPanel();
		mainPanel.setBackground(Color.WHITE);
		add(mainPanel, BorderLayout.CENTER);
		
		// Create left button panel
		JPanel leftPanel = new JPanel();
		add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new GridLayout(4, 1));
		
		// Create right button panel
		JPanel rightPanel = new JPanel();
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setLayout(new GridLayout(4, 1));
		
		// Create buttons
		button1 = new JButton("Black");						// initialize button 1
		button1.setMaximumSize(new Dimension(200, 200));
		button1.setPreferredSize(new Dimension(50, 50));
		button1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.setColor(Color.BLACK, null);
					}
				});
		leftPanel.add(button1);
		
		button2 = new JButton("Green");						// initialize button 2
		button2.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.setColor(Color.GREEN, null);
					}
				});
		leftPanel.add(button2);
		
		button3 = new JButton("Yellow");					// initialize button 3
		button3.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.setColor(Color.YELLOW, null);
					}
				});
		leftPanel.add(button3);
		
		button4 = new JButton("Gray");						// initialize button 4
		button4.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.setColor(Color.GRAY, null);
					}
				});
		leftPanel.add(button4);
		
		button5 = new JButton("Small");						// initialize button 5
		button5.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.currSize(10);
					}
				});
		rightPanel.add(button5);
		
		button6 = new JButton("Medium");					// initialize button 6
		button6.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.currSize(20);
					}
				});
		rightPanel.add(button6);
		
		button7 = new JButton("Large");						// initialize button 7
		button7.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.currSize(30);
					}
				});
		rightPanel.add(button7);
		
		button8 = new JButton("Clear");						// initialize button 8
		button8.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						mainPanel.clear();
					}
				});
		rightPanel.add(button8);
	
	} // end MainFrame constructor 
	
	
} // end MainFrame class

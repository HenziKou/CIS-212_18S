import javax.swing.JFrame;
import java.awt.BorderLayout;

public class MainApp
{
	public static void main(String[] args)
	{
		MainFrame mainFrame = new MainFrame();
		
		mainFrame.setTitle("MainApp");
		mainFrame.setSize(700, 600);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

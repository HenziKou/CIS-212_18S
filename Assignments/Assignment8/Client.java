import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.ArrayList;

public class Client
{
	// initialize a port
	private static final int PORT = 12345;
	
	// implement a main method to execute the program
	public static void main(String[] args)
	{		
		// initialize variables
		Socket socket = null;
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
		
		// initialize an array list to store the integers inputed by user
		ArrayList<Integer> numlist = new ArrayList<Integer> ();
		
		Scanner scanner = new Scanner(System.in);
		String stringInt = "";
		boolean running = true;
		
		while (running == true)
		{
			System.out.println("Enter an integer (\"!\" to send): \n");			
			stringInt = scanner.next();
			System.out.println("\n");
			
			if (stringInt.equals("!")) {
				running = false;
			} else {
				int number = Integer.parseInt(stringInt);
				numlist.add(number);
			}
		} // end while loop
		
		scanner.close();			// close scanner
		
		try
		{
			InetAddress address = InetAddress.getLocalHost();
			socket = new Socket(address, PORT);
										
			// Always flush an object output stream preemptively
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("got here");
			outputStream.flush();
			
			// send list of integers to the server
			System.out.println("Send: " + numlist);
			outputStream.writeObject(numlist);
			outputStream.flush();
			
			// get the returned list of prime integers from the server
			inputStream = new ObjectInputStream(socket.getInputStream());
			@SuppressWarnings("unchecked")
			ArrayList<Integer> primeslist = (ArrayList<Integer>)inputStream.readObject();
			System.out.println("Receive: " + primeslist);
			
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// Close resources in finally block so that they get closed even if we hit an exception above.
			try
			{
				if (socket != null) {
					socket.close();
				}
				
				if (outputStream != null) {
					outputStream.close();
				}
				
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // end try/catch/finally method
		
	} // end main method
	
} // end CLient class


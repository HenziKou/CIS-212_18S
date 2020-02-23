import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server
{
	// initialize a port
	private static final int PORT = 12345;

	// implement a main method to execute program
	public static void main(String[] args)
	{
		// initialize the variables
		ServerSocket serverSocket = null;
		Socket socket = null;
		ObjectInputStream inputStream = null;
		ObjectOutputStream outputStream = null;
					
		try
		{
			serverSocket = new ServerSocket(PORT);
			System.out.println("Server socket created");
			
			// reading the list of integers from the client
			socket = serverSocket.accept();
			
			// Always flush an object output stream preemptively
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.flush();
			
			inputStream = new ObjectInputStream(socket.getInputStream());
			@SuppressWarnings("unchecked")
			ArrayList<Integer> intlist = (ArrayList<Integer>)inputStream.readObject();
			System.out.println("Server received: " + intlist);
			
			// send list of prime integers to client
			ArrayList<Integer> primeslist = new ArrayList<Integer> ();
			primeslist = primeChecker(intlist);
			outputStream.writeObject(primeslist);
			outputStream.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} finally {
			// Close resources in finally block so that they get closed even if we hit an exception above.
			try
			{
				if (serverSocket != null) {
					serverSocket.close();
				}
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
	
	// Prime method is inspired and referenced from Mykong.com, "How to determine a prime number in Java"
	// https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
	
	// runs array list of integers through method and returns list of primes
	public static ArrayList<Integer> primeChecker(ArrayList<Integer> numlist)
	{
		ArrayList<Integer> duplicate = new ArrayList<Integer> ();
		ArrayList<Integer> primes = new ArrayList<Integer> ();
		
		for (int i = 0; i < numlist.size(); i++)
		{
			duplicate.add(numlist.get(i));
		}
		
		for (int j = 0; j < duplicate.size(); j++)
		{
			if (isPrime(duplicate.get(j)) == true)
			{
				primes.add(j);
			}
		}
		
		return primes;
	} // end primeChecker method
	
	// Check if integer n is prime or not
	public static boolean isPrime(int n)
	{
		// integers 0 and 1 are not prime
		if (n == 0 || n == 1)
			return false;
		
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		
		// if not then check the odds
		for (int i = 3; i * i <= n; i+=2)
		{
			if (n % i == 0)
				return false;
		} // end for loop
		
		return true;
	} // end isPrime method
		
} // end Server class


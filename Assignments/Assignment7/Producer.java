import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable
{
	// initialize the variables
	private final LinkedBlockingQueue<String> queue;
	public static int produced = 0;
	private static boolean running = false;
	
	// initialize the constructor
	public Producer(LinkedBlockingQueue<String> queue)
	{
		this.queue = queue;
	}
	
	// initialize a boolean to check if the program is running
	public static boolean isRunning() {
		return running;
	}

	@Override
	public void run() 
	{
		String element = "";
		
		for (int i = 1; i <= 1000; i++)
		{
			produced += 1;
			Double random = Math.random();
			element = random.toString();
			
			if (i % 100 == 0)
				System.out.println("\"Producer 1\": " + i + " events produced\n");
			
			try {
				queue.put(element);
			} catch (InterruptedException e) {
				System.out.println("Producer thread failed.");
				e.printStackTrace();
			}
		} // end for loop
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
		System.out.println("Summary: \n");
		System.out.println("\"Producer 1\" produces " + produced + " events.\n");
		running = true;

	} // end run method
	
} // end Producer class


/*
initialize variables to:
		create a queue of items created
		the total number of items created
	 	a boolean to keep the function running when true and terminates when otherwise
	
initialize the constructor
	
implement the run() method that is inherited from Runnable
		iterate 1000 times to create 1000 random strings using Math.random() and Double.toString()
		implement a try/catch
		use put() method to strings
try/catch for the sleep() to ensure that producer does not over produce what the queue limit can hold
print out the results
*/

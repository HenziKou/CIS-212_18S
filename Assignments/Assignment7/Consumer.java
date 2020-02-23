import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;

public class Consumer implements Runnable
{
	// initialize variables
	private final LinkedBlockingQueue<String> queue;
	public static int consumed = 0;
	private String name = "";
	private static Random random = new Random();
	
	// initialize the constructor
	public Consumer(LinkedBlockingQueue<String> queue, String name)
	{
		this.queue = queue;
		this.name = name;
	}
	
	@Override
	public void run()
	{		
		while(!Producer.isRunning() || queue.size() != 0)
		{
			try
			{
				Thread.sleep(random.nextInt(10));
				if(queue.poll() != null)		
					consumed += 1;
				
				if (consumed % 100 == 0)
					System.out.println("\"" + this.name + "\": " + consumed + " events consumed\n");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Consumer thread failed.");
			}
		} // end while loop
		
		//System.out.println("\"" + this.name + "\" consumes " + consumed + " events.\n");
	} // end run method
	
} // end Consumer class

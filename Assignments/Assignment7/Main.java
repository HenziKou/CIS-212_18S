import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		// initialize a queue with predefined size
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String> (100);
		
		// initialize a single producer
		Producer producer = new Producer(queue);
		
		// initialize four new consumers
		Consumer consumer1 = new Consumer(queue, "Consumer 1");
		Consumer consumer2 = new Consumer(queue, "Consumer 2");
		Consumer consumer3 = new Consumer(queue, "Consumer 3");
		Consumer consumer4 = new Consumer(queue, "Consumer 4");
		
		// using executor, execute each producer/consumer instance
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(producer);
		// implement a Thread.sleep(int) method
		Thread.sleep(4);
		executor.execute(consumer1);
		executor.execute(consumer2);
		executor.execute(consumer3);
		executor.execute(consumer4);
		
		// close executor interface
		executor.shutdown();
		
		System.out.println("consumer 1 produced: " + consumer1.getcount());
	} // end main method
} // end Main class

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Assignment2 {

	// Part 1
	public static void main(String[] args) {

	    int array_len = 0;
	    double array_den = 0.0;
		Scanner input = new Scanner(System.in);

	    System.out.println("Please array length: "); // integer array length
	    array_len = input.nextInt();

	    while (array_len < 1)
	    {
	        System.out.println("Please array length: ");
	        array_len = input.nextInt();
	    }

	    System.out.println("Enter density: "); // array density
	    array_den = input.nextDouble();

	    while (array_den < 0 || array_den > 1)
	    {
	    	System.out.println("Enter density: ");
	    	array_den = input.nextDouble();
	    }

	    input.close();

	    // Part 8
	    long start = System.nanoTime(); // duration of density array
	   	denseArray(array_len, array_den);
	   	long end = System.nanoTime();
	   	double period = (end - start) / 1000000.0;
	   	System.out.println("create dense length: " + array_len + " time: " + period);

	   	start = System.nanoTime(); // duration of new sparse length
	   	newSparse(denseArray(array_len, array_den));
	   	end = System.nanoTime();
	   	period = (end - start) / 1000000.0;
	   	System.out.println("convert to sparse length: " + array_len + " time: " + period);

	   	start = System.nanoTime(); // duration of converting to sparse array
	   	sparseArray(array_len, array_den);
	   	end = System.nanoTime();
	   	period = (end - start) / 1000000.0;
	   	System.out.println("create sparse length: " + array_len + " time: " + period);

	   	start = System.nanoTime(); // duration of new dense length
	   	ArrayList<int[]> sparse = sparseArray(array_len, array_den);
	   	end = System.nanoTime();
	   	period = (end - start) / 1000000.0;
	   	System.out.println("convert to dense length: " + array_len + " time: " + period);

	   	start = System.nanoTime(); // duration of dense
	   	maxDense(denseArray(array_len, array_den));
	   	end = System.nanoTime();
	   	period = (end - start) / 1000000.0;
	   	System.out.println("dense find time: " + period);

	   	start = System.nanoTime(); // duration of spare
	   	maxSparse(sparseArray(array_len, array_den));
	   	end = System.nanoTime();
	   	period = (end - start) / 1000000.0;
	   	System.out.println("sparse find time: " + period);

	} // end main

	// Part 2
	public static int [] denseArray (int array_len, double array_den) {
	    
	    int [] dense  = new int [array_len];

	    for (int i = 0; i < array_len; i++)
	    {
	    	double randDouble = Math.random();
	        if (randDouble < array_den)
	        {
	        	Random rand = new Random();
	        	dense[i] = rand.nextInt(1000000);
	        } else {
	        	dense[i] = 0;	
	    	}
		}

		return dense;
	} // end denseArray

	// Part 3
	public static ArrayList <int []> sparseArray(int array_len, double array_den) {
		
		Random rand = new Random();
		ArrayList <int []> sparse = new ArrayList <int []> (array_len);

		for (int i = 0; i < array_len; i++)
		{
			double num = rand.nextDouble();
			if (num < array_den)
			{
				int [] table = new int [2];
				table[0] = i;
				table[1] = rand.nextInt(1000000) + 1;
				sparse.add(table);
			}
		}

		return sparse;
	} // end sparseArray

	// Part 4
	public static ArrayList <Integer> newSparse (int [] dense_array) {

		ArrayList <Integer> table1 = new ArrayList <Integer> ();
		ArrayList <Integer> table2 = new ArrayList <Integer> ();

		for (int i = 0; i < dense_array.length; i++)
		{
			if (dense_array[i] != 0)
			{
				table2.add(i);
				table2.add(dense_array[i]);
				table1.addAll(table2);
				table2.clear();
			}
		}

		return table1;
	} // end newSparse

	// Part 5
	public static int [] newDense (ArrayList <int []> array, int int_length) {

		int position = 0;
		int value;
		int [] dense = new int [int_length];
		
		for (int i = 0; i < int_length; i++)
			{
			dense[i] = 0;
			}
		
		for (int val = 0; val < array.size(); val++)
		{
			int [] current = array.get(val);
			position = current[0];
			value = current[1];
			dense[position] = value;
		}

		return dense;
	} // end newDense

	// Part 6
	public static void maxDense (int [] dense) {

		int max = 0;
		int index = 0;

		for (int i = 0; i < dense.length; i++)
		{
			if (dense[i] > max)
			{
				max = dense[i];
				index = i;
			}
		}

		System.out.println("find max (dense): " + max + " at: " + index);
	} // end maxDense

	// Part 7
	public static void maxSparse (ArrayList <int []> sparse) {

		int max = 0;
		int index = 0;

		for (int [] i: sparse)
		{
			if (i[1] > max)
			{
				max = i[1];	
				index = i[0];
			}
		}

		System.out.println("find max (sparse): " + max + " at: " + index);
	} // end maxSparse

} // end Assignment2





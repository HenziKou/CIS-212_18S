import java.util.Arrays;

public class Main
{	
	public static void main(String[] args)
	{
		// testing functionality of OccurrenceSet class with integers
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer> ();
		
		// adding integer elements to the intSet
		intSet.add(1);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		
		System.out.println(intSet);
		
		// to array types
		System.out.println("to array: " + Arrays.toString(intSet.toArray()));
				
		intSet.add(9);
		intSet.add(10);
		intSet.add(3);
		intSet.add(3);
				
		System.out.println(intSet);
				
		Integer[] intList = new Integer[intSet.size()];
		System.out.println("to array S[]: " + Arrays.toString(intSet.toArray(intList)));		
		System.out.println("size: " + intSet.size());
		System.out.println("contains 5: " + intSet.contains(5));
				
		
		// testing functionality of OccurrenceSet class with strings
		OccurrenceSet<String> stringSet = new OccurrenceSet<String> ();
		
		// adding string elements to the stringSet
		stringSet.add("hello");
		stringSet.add("hello");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		
		System.out.println(stringSet);
		
		// test cases for each method in OccurrenceSet
		System.out.println(stringSet.size());
		System.out.println(stringSet.isEmpty());
		System.out.println(stringSet.contains(1));
		System.out.println(stringSet.contains("hello"));
		System.out.println(stringSet.add("is"));
		System.out.println(stringSet.contains("is"));
		System.out.println(stringSet.remove("is"));
		System.out.println(stringSet.contains("is"));
		stringSet.clear();
		System.out.println(stringSet.size());
		
		// size and string representation
		System.out.println();
		System.out.println(stringSet + " " + stringSet.size());
		
		// testing addAll
		OccurrenceSet<String> addtest = new OccurrenceSet<String>();
				
		addtest.add("hello");
		addtest.add("there");
		addtest.add("world");
		addtest.add("a");
		addtest.add("is");
				
		System.out.println();
		System.out.println(addtest);
				
		stringSet.addAll(addtest);
				
		System.out.println(stringSet);
		
		// remove all test and contains all tests
		
		System.out.println();
		System.out.println(stringSet.containsAll(addtest));
				
		stringSet.removeAll(addtest);
		System.out.println();
		System.out.println(stringSet);
				
		System.out.println(stringSet.containsAll(addtest));
				
		stringSet.clear();
		System.out.println();
		System.out.println("clear: " + stringSet);
	}
} // end class Main

 import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class PhoneBook
{
	private String phoneNumber;
	private String firstName;
	private String lastName;
			
	public static void main(String[] args)
	{		
		Scanner input = new Scanner(System.in);
		
		try
		{
			ArrayList<PhoneBook> original = new ArrayList<PhoneBook> ();
			
			Path p = Paths.get("res", "test.txt");
			BufferedReader br = Files.newBufferedReader(p);
			String line = br.readLine();
			
			while (line != null)
			{
				String a [] = line.split(", ");
				String b [] = a[0].split(" ");
				
				String number = b[0];
				String first = b[1];
				String last = a[1];
				
				PhoneBook contact = new PhoneBook(number, first, last);		// why does the type of 'contact' need to be PhoneBook?
				original.add(contact);
				
				line = br.readLine();	// read next line
			}
			
			br.close(); // close BufferedReader
			
			// call methods below here
			// this is where the methods will run if called
			
			// calling method to search contacts within phonebook
			System.out.println("Enter a name to search in the phonebook: ");
			String contact = input.next();
			findContact(original, contact);
			
			// use selection sort to alphabetize the contacts by last name
			ArrayList<PhoneBook> select = selectionSort(original);
			
			// use merge sort to alphabetize the contacts by last name
			ArrayList<PhoneBook> merge = mergeSort(original);
			
			// validate if the two new array list are properly alphabetized
			verifySort(select);
			verifySort(merge);
			
			// elapsed running times of selection and merge sort functions
			sortingTime(original);
			
		} // end try
		
		catch (IOException event) {
			System.out.println("Error");
		} // end catch
		
		input.close();
		
	} // end main method
	
	public PhoneBook(String phoneNumber, String firstName, String lastName)
	{
		this.phoneNumber = phoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	} // end PhoneBook constructor
	
	private String getNumber()
	{
		return this.phoneNumber;
	}
	
	private String getFirstName()
	{
		return this.firstName;
	}
	
	private String getLastName()
	{
		return this.lastName;
	}
	
	public String fullContact()
	{
		return this.phoneNumber + " " + this.firstName + ", " + this.lastName + "\n";
	}
	
	
	// Part 2 - Find contacts matching user input and place into "Output.txt"
	public static void findContact(ArrayList<PhoneBook> original, String s)
	{
		try
		{
			int array_size = original.size();
			FileWriter fw = new FileWriter("Output.txt", false);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (int i = 0; i < array_size; i++)
			{
				PhoneBook entry = original.get(i);
				
				if (entry.getFirstName().contains(s) || entry.getLastName().contains(s))
				{
					System.out.println(entry.getFirstName());
					bw.write(entry.fullContact());
				}
			} // end for loop
			
			bw.close();		// close BufferedWriter
		}
		
		catch (IOException event) {
			System.out.println("Error");
		}
		
	} // end findContact method
	
	
	// Part 3 - Recursive method of reversing the contacts phone book
	public static ArrayList<PhoneBook> reverseContacts(ArrayList<PhoneBook> original)
	{
		// implement a for loop to go through each item within the array list
		ArrayList<PhoneBook> reverse = new ArrayList<PhoneBook> ();
		
		// Copy all elements in original into a copy list
		for (int i = 0; i < original.size(); i++)
			reverse.add(original.get(i));
		
		// Check and see if reverse array list has only one item
		if (reverse.size() == 1)
			return reverse;
		
		else {
			PhoneBook mod = reverse.remove(reverse.size() - 1);
			reverse.add(mod);
			reverse.addAll(reverseContacts(reverse));
			return reverse;
		}
		
	} // end reverseContacts method
	
	
	// Part 4 - Implement 'Selection Sort' to alphabetically sort the contacts by last name
	public static ArrayList<PhoneBook> selectionSort(ArrayList<PhoneBook> original)
	{
		ArrayList<PhoneBook> selectionBook = new ArrayList<PhoneBook> ();
		
		// Copy all elements in original into a copy list
		for (int i = 0; i < original.size(); i++)
			selectionBook.add(original.get(i));
		
		// If ArrayList size is 0 or 1 then just return as is
		if (selectionBook.size() == 0 || selectionBook.size() == 1)
			return selectionBook;
		
		// Loop through and find the lowest value
		for (int i = 0; i < selectionBook.size() - 1; i++)
		{
			// initialize variables
			int min_index = i;
			PhoneBook entry = selectionBook.get(min_index);
			
			for (int j = i + 1; j < selectionBook.size(); j++)
			{
				PhoneBook entry2 = selectionBook.get(j);
				
				if (entry2.getLastName().compareTo(entry.getLastName()) < 0)
				{
					min_index = j;
					//entry = selectionBook.get(j);
				}
			} // end j for loop
			
			//Collections.swap(selectionBook, i, min_index);
			PhoneBook temp = selectionBook.get(min_index);
			selectionBook.set(min_index, selectionBook.get(i));
			selectionBook.set(i, temp);
		} // end i for loop
		
		return selectionBook;
	} // end selectionSort method
	
	
	// Part 5 - Implement 'Merge Sort' to alphabetically sort the contacts by last name
	// Code is inspired and referenced from:
	// http://www.codexpedia.com/java/java-merge-sort-implementation/
	public static ArrayList<PhoneBook> mergeSort(ArrayList<PhoneBook> original)
	{
		ArrayList<PhoneBook> mergeBook = new ArrayList<PhoneBook> ();
		
		// Copy all elements in original into a copy list
		for (int i = 0; i < original.size(); i++)
			mergeBook.add(original.get(i));
		
		// Create a left and right arraylist
		ArrayList<PhoneBook> leftMerge = new ArrayList<PhoneBook> ();
		ArrayList<PhoneBook> rightMerge = new ArrayList<PhoneBook> ();
		
		if (mergeBook.size() == 1)
			return mergeBook;
		else
		{
			int center = mergeBook.size() / 2;
			
			// copy left half of the original arraylist into the left
			for (int i = 0; i < center; i++)
				leftMerge.add(mergeBook.get(i));
			
			// copy right half of the original arraylist into the right
			for (int i = center; i < mergeBook.size(); i++)
				rightMerge.add(mergeBook.get(i));
			
			leftMerge = mergeSort(leftMerge);
			rightMerge = mergeSort(rightMerge);
			
			// merge items back into one arraylist
			merge(leftMerge, rightMerge, mergeBook);
		}
		
		return mergeBook;
	} // end mergeSort method
	
	public static void merge(ArrayList<PhoneBook> leftMerge, ArrayList<PhoneBook> rightMerge, ArrayList<PhoneBook> mergeBook)
	{
		// initialize variables
		int left_index = 0;
		int right_index = 0;
		int main_index = 0;
		
		while (left_index < leftMerge.size() && right_index < rightMerge.size())
		{
			PhoneBook left = leftMerge.get(left_index);
			PhoneBook right = rightMerge.get(right_index);
			
			if (left.getLastName().compareTo(right.getLastName()) < 0)
			{
				mergeBook.set(main_index, left);
				left_index++;
			} else {
				mergeBook.set(main_index, right);
				right_index++;
			}
			main_index++;
		} // end while loop
		
		ArrayList<PhoneBook> merge;
		int index;
		
		if (left_index >= leftMerge.size())
		{
			merge = rightMerge;
			index = right_index;
		} else {
			merge = leftMerge;
			index = left_index;
		}
		
		for (int i = index; i < merge.size(); i++)
		{
			mergeBook.set(main_index, merge.get(i));
			main_index++;
		} // end for loop
	} // end merge method
	
	
	// Part 6 - Check to see if phone book is alphabetically organized
	public static boolean verifySort(ArrayList<PhoneBook> original)
	{
		for (int i = 0; i < original.size() - 1; i++)
		{
			String name = original.get(i).getLastName();
			
			for (int j = i + 1; j < original.size(); j++)
			{
				String name2 = original.get(j).getLastName();
				
				if (name.compareTo(name2) > 0)
					return false;
			} // end j for loop
		} // end i for loop
		
		return true;
	} // end alphabetized method
	
	
	// Part 7 - Report the sorting time for 'Selection Sort' and 'Merge Sort' methods
	public static void sortingTime(ArrayList<PhoneBook> original)
	{
		// Selection sort run time
		long start = System.nanoTime();
		selectionSort(original);
		long end = System.nanoTime();
		double duration = (end - start) / 1000;
		System.out.printf("Selection Sort: %d%n", duration);
		
		// Merge sort run time
		start = System.nanoTime();
		mergeSort(original);
		end = System.nanoTime();
		duration = (end - start) / 1000;
		System.out.printf("Merge Sort: %d%n", duration);
		
	} // end sortingTime method
} // end PhoneBook class


/*
 * Selection Sort:
 * 		swap(a[j], a[iMin]) - is a method to swap elements within an array
 * 
 * Merge Sort:
 * 		MergeSort(arr[], 1, r)
 * 		if (r > 1) {
 * 			1. Find the middle point to divide the array into two halves:
 * 				middle m = (l+r)/2
 * 			2. Call mergeSort for first half:
 * 				Call mergeSort(arr, l, m)
 * 			3. Call mergeSort for second half:
 * 				Call mergeSort(arr, m+1, r)
 * 			4. Merge the two halves sorted in step 2 and 3:
 * 				Call merge(arr, l, m, r)
 * 		}
 */

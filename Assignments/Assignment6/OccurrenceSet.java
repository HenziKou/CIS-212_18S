import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T>
{
	HashMap<T, Integer> map = new HashMap<T, Integer> ();

	@Override
	public int size() {
		return map.size();
	} // end size method

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	} // end isEmpty method

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);

	} // end contains method

	@Override
	public Iterator<T> iterator() {
		// create a new arraylist
		// populate arraylist with keys from map
		// hashmap have a keyset method
		// use collections.sort to sort arraylist
		// look up collections documentation on sort method
		// return arraylist.iterator
		
		Set<Map.Entry<T, Integer>> entry = map.entrySet();
		ArrayList<Map.Entry<T, Integer>> arlist = new ArrayList<Map.Entry<T, Integer>>(entry);
		ArrayList<T> sorted = new ArrayList<T>();
		
		Collections.sort(arlist, new Comparator<Map.Entry<T, Integer>>() {

			public int compare(Map.Entry<T, Integer> obj1, Map.Entry<T, Integer> obj2) {
				return obj1.getValue().compareTo(obj2.getValue());
			}
		});
		
		for (Map.Entry<T, Integer> key : arlist) {
			sorted.add(key.getKey());
		}
		
		return sorted.iterator();
	} // end Iterator method

	@Override
	public Object[] toArray() {
		Iterator<T> iter = iterator();
		ArrayList<T> sorted = new ArrayList<T> ();
		
		while (iter.hasNext())
			sorted.add(iter.next());
			
		return sorted.toArray();
	} // end Object[] toArray() method

	@Override
	public <T> T[] toArray(T[] a) {
		@SuppressWarnings("unchecked")					// Suggested Eclipse fix method
		Iterator<T> iter = (Iterator<T>) iterator();
		ArrayList<T> sorted = new ArrayList<T> ();
		
		while (iter.hasNext())
			sorted.add(iter.next());
		
		return sorted.toArray(a);
	} // end T[] toArray() method

	@Override
	public boolean add(T e) {
		int val = 1;
		
		if (map.containsKey(e))
			val = map.get(e) + 1;
		
		return map.put(e, val) == null;
	} // end add method

	@Override
	public boolean remove(Object o) {
		return map.remove(o, map.get(o));
	} // end remove method

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean changed = false;
		
		for (Object e : c)
		{
			changed = contains(e);
		}
		return changed;
	} // end containsAll method

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean changed = false;
		
		for (T e : c)
		{
			changed = add(e);
		}
		return changed;
	} // end addAll method

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean changed = false;
		Iterator<T> e = iterator();
		
		while (e.hasNext())
		{
			if (!c.contains(map.get(e)))
			{
				map.remove(e);
				changed = true;
			}				
		} // end while loop
		
		return changed;
	} // end retainAll method

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean changed = false;
		
		for (Object e : c)
		{
			if (map.containsKey(e))
			{
				map.remove(e);
				changed = true;
			}
		}
		return changed;
	} // end removeAll method

	@Override
	public void clear() {
		map.clear();
	} // end clear method
	
	public String toString()
	{
		Iterator<T> iter = iterator();
		ArrayList<T> str = new ArrayList<T> ();
		
		while (iter.hasNext())
			str.add(iter.next());
			
		return "" + str + "";
	}
	
} // end OccurrenceSet method
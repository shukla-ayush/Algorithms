package sorters;

import java.util.Comparator;

/**
 * 
 * QuickSorter class gives object that
 * calls the sort function defined as per 
 * the interface, to sort generic data.
 * This class implements sort using
 * the quickSort algorithm.
 * 
 * @author ashuk
 */
public class QuickSorter implements Sorter{
	
	
	/**
	  * sort function sorts the list in non decreasing
	  * order
	  * 
	  * @param list the array that is to be sorted
	  * 
	  * @author ashuk
	  */
	public void sort(Comparable[] list) {
		int size = list.length;
		
		if(list.length == 0) {
			return;
		}
			
		sorterHelper(list, 0, size - 1);
	}	
	
	/**
	 * sorterHelper function finds the pivot to 
	 * partition the array and recursively sorts
	 * the array by divide and conquer.
	 * 
	 * @param list array that is to be sorted.
	 * 
	 * @param start starting index of array.
	 * 
	 * @param end last index of array.
	 */
	public <T> void sorterHelper(T list[], int start, int end)
	 {
	     
	     int i = start;
	     int j = end;

	     // Taking mid element of array as pivot.
	     T pivot = list[start+(end-start)/2];

	     while (i <= j) {
	    	 
	    	 // continue increasing i till object is smaller than pivot
	    	 while(compare(list[i], pivot) < 0) {
	    		 i++;
	    	 }
	    	 
	    	 // continue decreasing j till object is greater than pivot
	         while(compare(list[j], pivot) > 0) {
	    		 j--;
	    	 }
	    	 
	         // swap the elements at i and j.
	         if (i <= j) {
	        	 T temp = list[i];
	             list[i] = list[j];
	             list[j] = temp;
	             i++;
	             j--;
	         }
	      }
	     
	      if (start < j)
	         sorterHelper(list, start, j);
	      if (i < end)
	         sorterHelper(list , i, end);

	 }
	
	/**
	 * compares the two objects
	 * 
	 * @param o1 first object
	 * @param o2 second object
	 * @return 1, if first object is bigger, 0 if both
	 * are same, -1 otherwise
	 */
	public int compare(Object o1, Object o2) {
		// check if any or both objects to be
	    // compared are null.
	 	if (o1 == null) {
            if (o2 == null) {
                return 0;
            } else {
                return -1;
            }
        } else {
            if (o2 == null) {
                return 1;
            }
        }
	 	return ((Comparable) o1).compareTo(o2);
	}
	

}

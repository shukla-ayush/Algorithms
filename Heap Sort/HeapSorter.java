package sorters;

import java.util.Comparator;

/**
 * HeapSorter creates object that sorts the given
 * list in non decreasing order.
 * 
 * @author ashuk
 */

public class HeapSorter<T> implements Sorter{

	/**
	 * sort function sorts the given list
	 * in non decreasing order.
	 * 
	 * @param list that is to be sorted.
	 */
	public void sort(Comparable[] list) {
		
		int size = list.length;
		
        for (int i = (size/2) - 1; i >= 0; i--) {
        	heapify(list, i, size);	
        }
 
        for (int i = size - 1; i>=0; i--)
        {
            T tmp = (T) list[0];
            list[0] = list[i];
            list[i] = (Comparable) tmp;
 
            heapify(list, 0, i);
        }
	}

	/**
	 * heapify is the function that is use to
	 * maintain the heap property, while creating
	 * a heap, inserting or deleting elements from heap.
	 * 
	 * @param list list to be sorted.
	 * @param parent the parent node of the heap under consideration 
	 * @param size size of the heap
	 */
	public void heapify(Comparable[] list, int parent, int size){

		// largest value is initialized with parent
        int largest = parent;  
        
        // left child is initialized
        int leftChild = 2*parent + 1;
        
        // right child is initialized
        int rightChild = 2*parent + 2;   

        if (rightChild < size && (compare(list[rightChild], list[largest]) > 0)) {
        	largest = rightChild;
        }

        if (leftChild < size && (compare(list[leftChild], list[largest]) > 0)) {
        	largest = leftChild;
        }
        
    
        if (largest == leftChild || largest == rightChild)
        {
        	// exchange parent with child that is larger
            exchange(list, parent, largest);
 
            // recursively call back heapify
            heapify(list, largest, size);
        }
	}
	
	/**
	 * function to exchange two values.
	 * 
	 * @param list the list to be sorted
	 * @param parent parent node heap under consideration
	 * @param largest largest children of given parent
	 */
	public void exchange(Comparable[] list, int parent, int largest) {
		
		T tmp = (T) list[parent];
		list[parent] = list[largest];
		list[largest] = (Comparable) tmp;
		
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

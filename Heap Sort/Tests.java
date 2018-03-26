package tests3d;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import sorters.HeapSorter;
import sorters.Sorter;
import tests3d.Person;

public class Sorter2SampleTestsExtended {

	 /**
     * Method for creating a sorter. Modify this to use your own sorter.
     * @return
     */
    private static <T extends Comparable<T>> Sorter<T> createSorter(){
      return new HeapSorter<T>();
    }
  
  // -----------------------------------------------
  // sort a list with one String element
  
  @Test
  public void testOneElement(){ 
    Sorter<String> sorter = createSorter();
    String[] animals = { "dog" };
    sorter.sort(animals);
    String[] sorted = { "dog" };
    assertArrayEquals(animals, sorted);
  }
   
  // -----------------------------------------------
  // sort a list with multiple String elements
  
  @Test
  public void testMultipleElements(){
    Sorter<String> sorter = createSorter();
    String[] animals = { "dog", "cat", "pig", "cow", "horse" };
    sorter.sort(animals);
    String[] sorted = { "cat", "cow", "dog", "horse", "pig" };
    assertArrayEquals(animals, sorted);
  }
   
  // -----------------------------------------------
  // sort a list with ints
  
  @Test
  public void testints(){
    Sorter<Integer> sorter = createSorter();
    Integer[] ints = { 1, 4, 5, 3 };
    sorter.sort(ints);
    Integer[] sorted = { 1, 3, 4, 5 };
    assertArrayEquals(ints, sorted);
  }
   
  // -----------------------------------------------
  // sort an empty list (of strings)
  
  @Test
  public void testEmpty(){
    Sorter<String> sorter = createSorter();
    String[] animals = {  };
    sorter.sort(animals);
    String[] sorted = {  };
    assertArrayEquals(animals, sorted);
  }
  
  // -----------------------------------------------
  // sort list containing one element of a user-defined type
  
  @Test
  public void testOneUserDefinedType(){
    Sorter<Person> sorter = createSorter();
    Person[] people = { new Person ("Joe")};
    sorter.sort(people);
    Person[] sorted = { new Person ("Joe")};
    assertArrayEquals(people, sorted);
  }
  
  
  //-----------------------------------------------
  // sort list containing no element of a user-defined type
 
  @Test
  public void testNoUserDefinedType(){
    Sorter<Person> sorter = createSorter();
    Person[] people = { };
    sorter.sort(people);
    Person[] sorted = { };
    assertArrayEquals(people, sorted);
  }
  
 
  //-----------------------------------------------
  // sort list containing many element of a user-defined type

  @Test
  public void testMultipleUserDefinedType(){
    Sorter<Person> sorter = createSorter();
    Person[] people = { new Person ("Joe"), new Person ("Adam"), new Person ("Ron") };
    sorter.sort(people);
    Person[] sorted = { new Person ("Adam"), new Person ("Joe"), new Person ("Ron") };
    assertArrayEquals(people, sorted);
  }  
  
  
  // -----------------------------------------------
  // sort a very large list
  
  @Test
  public void testVeryLarge(){
    Sorter<Integer> sorter = createSorter();
    int VERY_LARGE = 10000000;
    Integer[] numbers = new Integer[VERY_LARGE];
    Integer[] sorted = new Integer[VERY_LARGE];
    for (int i=0; i < VERY_LARGE; i++){
      sorted[i] = i;
      numbers[VERY_LARGE-i-1] = i;
    }
    sorter.sort(numbers); 
    assertArrayEquals(numbers, sorted);
  }
   
  // -----------------------------------------------
  // sort a list with a null element
  
  @Test
  public void testNull(){ 
    Sorter<Integer> sorter = createSorter();
    Integer[] numbers = { 6, 2, null, 8 }; 
    Integer[] sorted =  { null, 2, 6, 8 };
    sorter.sort(numbers); 
    assertArrayEquals(numbers, sorted);
  }
  
  //-----------------------------------------------
  // sort a list with multiple null element
  @Test
  public void testMultipleNullWithIntegers() {
	 Sorter<Integer> sorter = createSorter();
	 Integer[] list = {1, null, 6, 3, 2, null};
	 Integer[] sorted = {null, null, 1, 2, 3, 6}; 
	 sorter.sort(list);
	 assertArrayEquals(list, sorted);
  }
	
}

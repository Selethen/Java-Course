package Testy;

import static org.junit.Assert.*;

import randomProgramy.Program;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
/**
 * Testy do programu zwracaj¹cego przednajwiêksza liczbê ca³kowit¹ z podanych
 * @author Selethen
 *
 */
public class programTest{

	/**
	 * Testowanie metody highestButOne w przypadku podania tylko liczb dodatnich
	 */
	@Test
	public void testHighestButOneLiczbyDodatnie() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		assertEquals("b³¹d w przypadku liczb dodatnich",
					 new Integer(9), Program.highestButOne(list1));
		
		List<Integer> list2 = Arrays.asList(111111, 111111, 111111, 111111, 111111, 111111, 111111,
											111111, 111111, 1111111);
		assertEquals("b³¹d w przypadku liczb dodatnich",
					 new Integer(111111), Program.highestButOne(list2));
		
		List<Integer> list3 = Arrays.asList(2000000000, 1000000000, 500000000, 4000000, 30000, 16,
											83, 412897, 491287, 287345, 37256, 219807);
		assertEquals("b³¹d w przypadku liczb dodatnich",
					 new Integer(1000000000), Program.highestButOne(list3));
		
		List<Integer> list4 = Arrays.asList(2147483647, 2147483646, 2147483645, 2147483644,
											2147483643, 2147483642, 2147483641, 2147483640,
											2147483639, 2147483638, 2147483637, 2147483636,
											2147483635, 2147483634, 2147483633, 2147483632);
		assertEquals("b³¹d w przypadku liczb dodatnich",
					 new Integer(2147483646), Program.highestButOne(list4));
	}
	
	/**
	 * Testowanie metody highestButOne w przypadku podania liczb dodatnich i/lub ujemnych
	 */
	@Test
	public void testHighestButOneLiczbyUjemneIDodatnie() {
		List<Integer> list1 = Arrays.asList(58, -487275, -6662, -489725, -24242424);
		assertEquals("b³ad w przypadku liczb dodatnich i ujemnych",
					 new Integer(-6662), Program.highestButOne(list1));
		
		List<Integer> list2 = Arrays.asList(-2222222, -2222222, -2222222, -2222222, -2222222, 
											-2222222, -2222222, -22222222);
		assertEquals("b³ad w przypadku liczb ujemnych",
					 new Integer(-2222222), Program.highestButOne(list2));
		
		List<Integer> list3 = Arrays.asList(-123456789, -12345678, -1234567, -123456, -12345, -1234,
											-123, -12, -1, 1, 12, 123, 1234, 12345, 123456, 1234567);
		assertEquals("b³ad w przypadku liczb dodatnich i ujemnych",
					 new Integer(123456), Program.highestButOne(list3));
		
		List<Integer> list4 = Arrays.asList(-2147483648, -2147483647, -2147483646, -2147483645,
											-2147483644, -2147483643, -2147483642, -2147483641,
											-2147483640, -2147483639, -2147483638, -2147483637,
											-2147483636, -2147483635, -2147483634, -2147483633);
		assertEquals("b³ad w przypadku liczb dodatnich i ujemnych",
					 new Integer(-2147483634), Program.highestButOne(list4));
	}
	
	/**
	 * Testowanie metody highestButOne w przypadku podania bardzo du¿ej iloœci danych
	 */
	@Test
	public void testHighestButOneALotOfData() {
		Random generator = new Random();
		
		List<Integer> list1 = new ArrayList<>();
		for(int i=0;i<10000;i++)
			list1.add(generator.nextInt(2147483647));
		assertNotNull("b³¹d w przypadku du¿ej iloœci liczb dodatnich", 
					  Program.highestButOne(list1));
		
		List<Integer> list2 = new ArrayList<>();
		for(int i=0;i<10000;i++)
			list2.add(generator.nextInt());
		assertNotNull("b³¹d w przypadku du¿ej iloœci liczb dodatnich i ujemnych", 
				  	  Program.highestButOne(list2));
	}
	
	/**
	 * Testowanie metody highestButOne w przypadku podania tylko jednej liczby lub wielokrotnie
	 * tej samej liczby
	 */
	@Test
	public void testHighestButOneSameNumbers() {
		List<Integer> list1 = Arrays.asList(0);
		assertNull("b³¹d w przypadku podania jednej liczby", Program.highestButOne(list1));
		
		List<Integer> list2 = Arrays.asList(2147483647);
		assertNull("b³¹d w przypadku podania jednej liczby", Program.highestButOne(list2));
		
		List<Integer> list3 = Arrays.asList(2147483646, 2147483646, 2147483646, 2147483646, 2147483646,
											2147483646, 2147483646, 2147483646, 2147483646, 2147483646);
		assertNull("b³¹d w przypadku podania wiele razy tej samej liczby", Program.highestButOne(list3));
		
		List<Integer> list4 = Arrays.asList(-123456, -123456, -123456, -123456, -123456, -123456, -123456
											-123456, -123456, -123456, -123456, -123456, -123456, -123456);
		assertNull("b³¹d w przypadku podania wiele razy tej samej liczby", Program.highestButOne(list4));
	}
}

package Testy;

import static org.junit.Assert.*;

import randomProgramy.Program;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;

public class programTest{

	@Test
	public void testHighestButOne() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		assertEquals(new Integer(9), Program.highestButOne(list1));
		
		List<Integer> list2 = Arrays.asList(1, 11, 111, 1111, 11111, 111111, 1111111, 11111111);
		assertEquals(new Integer(1111111), Program.highestButOne(list2));
		
		List<Integer> list3 = Arrays.asList(2000000000, 1000000000, 500000000, 4000000, 30000, 16,
											83, 412897, 491287, 287345, 37256, 219807);
		assertEquals(new Integer(1000000000), Program.highestButOne(list3));
		
		List<Integer> list4 = Arrays.asList(2147483647, 2147483646, 2147483645, 2147483644,
											2147483643, 2147483642, 2147483641, 2147483640,
											2147483639, 2147483638, 2147483637, 2147483636,
											2147483635, 2147483634, 2147483633, 2147483632);
		assertEquals(new Integer(2147483646), Program.highestButOne(list4));
		
		List<Integer> list5 = Arrays.asList(-412, -124, -74557, 4129, -4219876, -428917, -1);
		assertEquals(new Integer(-1), Program.highestButOne(list5));
		
		List<Integer> list6 = Arrays.asList(8, 8, 8, 8, 8, 8, 8, 8, 9);
		assertEquals(new Integer(8), Program.highestButOne(list6));
	}

}

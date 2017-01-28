package Testy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import pl.com.selethen.CalculatingException;
import pl.com.selethen.Program;

/**
 * Testy do programu zwracaj¹cego przednajwiêksza liczbê ca³kowit¹ z podanych
 * 
 * @author Selethen
 *
 */
public class ProgramTest {

	/**
	 * Testowanie metody highestButOne w przypadku podania tylko liczb dodatnich
	 * 
	 * @throws Exception
	 */

	public void testHighestButOnePositiveNumbers() throws Exception {
		List<Integer> list = Arrays.asList(1, 5, 8, 10);
		assertEquals("b³¹d w przypadku liczb dodatnich", new Integer(8), Program.highestButOne(list));

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		assertEquals("b³¹d w przypadku liczb dodatnich", new Integer(9), Program.highestButOne(list1));

		List<Integer> list2 = Arrays.asList(111111, 111111, 111111, 111111, 111111, 111111, 111111, 111111, 111111,
				1111111);
		assertEquals("b³¹d w przypadku liczb dodatnich", new Integer(111111), Program.highestButOne(list2));

		List<Integer> list3 = Arrays.asList(2000000000, 1000000000, 500000000, 4000000, 30000, 16, 83, 412897, 491287,
				287345, 37256, 219807);
		assertEquals("b³¹d w przypadku liczb dodatnich", new Integer(1000000000), Program.highestButOne(list3));

		List<Integer> list4 = Arrays.asList(2147483647, 2147483646, 2147483645, 2147483644, 2147483643, 2147483642,
				2147483641, 2147483640, 2147483639, 2147483638, 2147483637, 2147483636, 2147483635, 2147483634,
				2147483633, 2147483632);
		assertEquals("b³¹d w przypadku liczb dodatnich", new Integer(2147483646), Program.highestButOne(list4));
	}

	/**
	 * Testowanie metody highestButOne w przypadku podania liczb dodatnich i/lub
	 * ujemnych
	 */
	@Test
	public void testHighestButOnePositiveAndNegativeNumbers() throws Exception {
		List<Integer> list1 = Arrays.asList(58, -487275, -6662, -489725, -24242424);
		assertEquals("b³ad w przypadku liczb dodatnich i ujemnych", new Integer(-6662), Program.highestButOne(list1));

		List<Integer> list2 = Arrays.asList(-2222222, -2222222, -2222222, -2222222, -2222222, -2222222, -2222222,
				-22222222);
		assertEquals("b³ad w przypadku liczb ujemnych", new Integer(-22222222), Program.highestButOne(list2));

		List<Integer> list3 = Arrays.asList(-123456789, -12345678, -1234567, -123456, -12345, -1234, -123, -12, -1, 1,
				12, 123, 1234, 12345, 123456, 1234567);
		assertEquals("b³ad w przypadku liczb dodatnich i ujemnych", new Integer(123456), Program.highestButOne(list3));

		List<Integer> list4 = Arrays.asList(-2147483648, -2147483647, -2147483646, -2147483645, -2147483644,
				-2147483643, -2147483642, -2147483641, -2147483640, -2147483639, -2147483638, -2147483637, -2147483636,
				-2147483635, -2147483634, -2147483633);
		assertEquals("b³ad w przypadku liczb dodatnich i ujemnych", new Integer(-2147483634),
				Program.highestButOne(list4));
	}

	/**
	 * Testowanie metody highestButOne w przypadku podania bardzo du¿ej iloœci
	 * danych
	 */
	@Test
	public void testHighestButOneALotOfData() throws Exception {
		Random generator = new Random();

		List<Integer> list1 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list1.add(generator.nextInt(2147483647));
		}
		assertNotNull("b³¹d w przypadku du¿ej iloœci liczb dodatnich", Program.highestButOne(list1));

		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list2.add(generator.nextInt());
		}
		assertNotNull("b³¹d w przypadku du¿ej iloœci liczb dodatnich i ujemnych", Program.highestButOne(list2));
	}

	/**
	 * Testowanie metody highestButOne w przypadku podania tylko jednej liczby
	 */
	@Test(expected = CalculatingException.class)
	public void testHighestButOneOneNumber() throws Exception {
		List<Integer> list1 = Arrays.asList(0);
		assertNull("b³¹d w przypadku podania jednej liczby", Program.highestButOne(list1));

		List<Integer> list2 = Arrays.asList(2147483647);
		assertNull("b³¹d w przypadku podania jednej liczby", Program.highestButOne(list2));
	}

	/**
	 * Testowanie metody highestButOne w przypadku podania wielokrotnie tej
	 * samej liczby
	 */
	@Test(expected = CalculatingException.class)
	public void testHighestButOneSameNumbers() throws Exception {
		List<Integer> list1 = Arrays.asList(2147483646, 2147483646, 2147483646, 2147483646, 2147483646, 2147483646,
				2147483646, 2147483646, 2147483646, 2147483646);
		assertNull("b³¹d w przypadku podania wiele razy tej samej liczby dodatniej", Program.highestButOne(list1));

		List<Integer> list2 = Arrays.asList(-123456, -123456, -123456, -123456, -123456, -123456, -123456, -123456,
				-123456, -123456, -123456, -123456, -123456, -123456);
		assertNull("b³¹d w przypadku podania wiele razy tej samej liczby ujemnej", Program.highestButOne(list2));
	}

	/**
	 * Testowanie metody parseList w przypadku podania tylko liczb dodatnich
	 */
	@Test
	public void testParseListOnlyPositiveNumbers() throws Exception {
		List<Integer> list1 = Arrays.asList(123, 123456, 98573, 2147483646, 10, 1000, 100, 11111);
		String word1 = new String("123 123456 98573 2147483646 10 1000 100 11111");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego tylko liczby dodatnie", list1,
				Program.parseList(word1));

		List<Integer> list2 = Arrays.asList(1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111, 1111111111);
		String word2 = new String("1 11 111 1111 11111 111111 1111111 11111111 111111111 1111111111");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego tylko liczby dodatnie", list2,
				Program.parseList(word2));
	}

	/**
	 * Testowanie metody parseList w przypadku podania liczb dodatnich i/lub
	 * ujemnych
	 */
	@Test
	public void testParseListPositiveAndNegativeNumbers() throws Exception {
		List<Integer> list1 = Arrays.asList(-2147483636, -123456789, -1000, 1000, 123456789, 2147483637);
		String word1 = new String("-2147483636 -123456789 -1000 1000 123456789 2147483637");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego", list1, Program.parseList(word1));

		List<Integer> list2 = Arrays.asList(-1010101010, -101010101, -10101010, -1010101, -101010, -10101, -1010, -101,
				-10, -1);
		String word2 = new String("-1010101010 -101010101 -10101010 -1010101 -101010 -10101 -1010 -101 -10 -1");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego", list2, Program.parseList(word2));
	}

	/**
	 * Testowanie metody parseList w przypadku podania liczb z b³êdnymi znakami
	 */
	@Test(expected = CalculatingException.class)
	public void testParseListNumbersWithTokens() throws Exception {
		List<Integer> list1 = Arrays.asList(10101, -300);
		String word1 = new String("-12-23 17.53 10101 #123 & *123 1010+1 -300");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego liczby z b³êdnymi znakami", list1,
				Program.parseList(word1));

		List<Integer> list2 = Arrays.asList(1, 0, 199, 0, 888);
		String word2 = new String("1, 1, 1, 1 0 199 0 1%1 1- 15, 888");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego liczby z b³êdnymi znakami", list2,
				Program.parseList(word2));

	}

	/**
	 * Testowanie metody parseList w przypadku podania liter z liczbami
	 */
	@Test(expected = CalculatingException.class)
	public void testParseListNumbersAndLetters() throws Exception {
		List<Integer> list1 = Arrays.asList();
		String word1 = new String("sdgjh dfgjkhsdfg fdgjshkfgsdf fdgsdfg osdfigj");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego same litery", list1, Program.parseList(word1));

		List<Integer> list2 = Arrays.asList(123, 1000080);
		String word2 = new String("1o23 123 214564kki x0x 1000f0001 1000080 j4j4j4 412089r 1515j15");
		assertEquals("b³¹d w przypadku podania ³añcucha zawieraj¹cego litery i liczby", list2,
				Program.parseList(word2));
	}
}

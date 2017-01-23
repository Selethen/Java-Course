package randomProgramy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author Lukasz Parulski
 *
 *         Program do zwracania przednajwiekszej liczby calkowitej z podanych
 * 
 */
public class Program {

	static Logger log = Logger.getLogger(Program.class.getName());

	/**
	 * Funkcja main
	 */
	public static void main(String[] args) throws CalculatingException {
		log.info("Program startuje");
		try {
			String stringNumbers = in();
			List<Integer> numbers = parseList(stringNumbers);
			Integer number = highestButOne(numbers);
			out(number);
			log.info("Koñczenie dzia³ania programu");
		} catch (CalculatingException exception) {
			System.out.println("Nast¹pi³ b³¹d.");
			exception.printStackTrace();
		}
	}

	/**
	 * Funkcja przyjmuje liczby z wejscia i wpisuje je do listy
	 * 
	 * @return Zwraca ci¹g znaków, w którym s¹ liczby oddzielone spacjami
	 */
	public static String in() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj liczby: ");
		String allNumbers = sc.nextLine();
		log.debug("Wprowadzony ³añcuch znaków to: ");
		log.debug(allNumbers);
		return allNumbers;
	}

	/**
	 * Funkcja zamienia stringa na listê intów
	 * 
	 * @param allNumbers
	 * @return Zwraca listê liczb ca³kowitych
	 */
	public static List<Integer> parseList(String allNumbers) {
		List<String> numbers = new ArrayList<>();
		numbers = Arrays.asList(allNumbers.split("\\s"));
		List<Integer> indeedNumbers = new ArrayList<>();
		for (String numberAsString : numbers) {
			if (isNumber(numberAsString))
				indeedNumbers.add(Integer.parseInt(numberAsString));
		}
		log.debug("String po sparsowaniu na listê liczb wygl¹da nastêpuj¹co: " + indeedNumbers);
		return indeedNumbers;
	}

	/**
	 * Funkcja wypisuje przednajwieksza liczbe z podanych
	 * 
	 * @param numbers
	 */
	public static void out(Integer number) {
		log.debug("Zwracanie elementu " + number);
		System.out.println("Przednajwieksza liczba z podanych to: " + number);
	}

	/**
	 * Funkcja zwraca przednajwieksza z podanej listy liczb
	 * 
	 * @param list
	 * 
	 * @return Zwraca przednajwiêksz¹ liczbê z listy, lub null je¿eli
	 *         przednajwiêksza liczba nie istnieje
	 */
	public static Integer highestButOne(List<Integer> list) throws CalculatingException {
		Collections.sort(list);
		Collections.reverse(list);
		int i;
		if (list.size() == 2) {
			if (!list.get(0).equals(list.get(1))) {
				log.debug("Na liœcie znajduj¹ siê 2 ró¿ne elementy");
				return list.get(1);
			} else {
				log.debug("Na liœcie znajduj¹ siê 2 takie same elementy");
				throw new CalculatingException("Nie mo¿na wskazaæ przednajmniejszej liczby");
			}
		} else {
			for (i = 0; i < list.size() - 1; i++) {
				if (!(list.get(i).equals(list.get(i + 1)))) {
					log.debug("Z list¹ wszystko jest OK");
					return list.get(i + 1);
				}

			}
		}
		log.debug("Na liœcie jest tylko jeden element lub jest wiele tych samych elementów");
		throw new CalculatingException("Nie mo¿na wskazaæ przednajmniejszej liczby");
	}

	/**
	 * Funkcja sprawdza czy w danym stringu znajduj¹ siê tylko cyfry lub
	 * ewentualnie minus na pocz¹tku
	 * 
	 * @param s
	 * @return true kiedy s¹ tylko cyfry lub minus na pocz¹tku, false kiedy sa
	 *         inne znaki
	 */
	public static boolean isNumber(String s) {
		if ((s.charAt(0) < '0' || s.charAt(0) > '9') && s.charAt(0) != '-') {
			log.debug("Ci¹g znaków " + s + " nie jest liczb¹");
			return false;
		} else {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) < '0' || s.charAt(i) > '9') {
					log.debug("Ci¹g znaków " + s + " nie jest liczb¹");
					return false;
				}
			}
		}
		log.debug("Ci¹g znaków " + s + " jest liczb¹");
		return true;
	}
}
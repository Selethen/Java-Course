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
	public static void main(String[] args) {
		log.info("Program startuje");
		String stringNumbers = in();
		List<Integer> numbers = parseList(stringNumbers);
		Integer number = highestButOne(numbers);
		out(number);
		log.info("Ko�czenie dzia�ania programu");
	}

	/**
	 * Funkcja przyjmuje liczby z wejscia i wpisuje je do listy
	 * 
	 * @return Zwraca ci�g znak�w, w kt�rym s� liczby oddzielone spacjami
	 */
	public static String in() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj liczby: ");
		String allNumbers = sc.nextLine();
		log.debug("Wprowadzony �a�cuch znak�w to: ");
		log.debug(allNumbers);
		return allNumbers;
	}

	/**
	 * Funkcja zamienia stringa na list� int�w
	 * 
	 * @param allNumbers
	 * @return Zwraca list� liczb ca�kowitych
	 */
	public static List<Integer> parseList(String allNumbers) {
		List<String> numbers = new ArrayList<>();
		numbers = Arrays.asList(allNumbers.split("\\s"));
		List<Integer> indeedNumbers = new ArrayList<>();
		for (String numberAsString : numbers) {
			if (isNumber(numberAsString))
				indeedNumbers.add(Integer.parseInt(numberAsString));
		}
		log.debug("String po sparsowaniu na list� liczb wygl�da nast�puj�co: " + indeedNumbers);
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
	 * @return Zwraca przednajwi�ksz� liczb� z listy, lub null je�eli
	 *         przednajwi�ksza liczba nie istnieje
	 */
	public static Integer highestButOne(List<Integer> list) {
		Collections.sort(list);
		Collections.reverse(list);
		int i;
		if (list.size() == 2) {
			if (!list.get(0).equals(list.get(1))) {
				log.debug("Na li�cie znajduj� si� 2 r�ne elementy");
				return list.get(1);
			} else {
				log.debug("Na li�cie znajduj� si� 2 takie same elementy");
				return null;
			}
		} else {
			for (i = 0; i < list.size() - 1; i++) {
				if (!(list.get(i).equals(list.get(i + 1)))) {
					log.debug("Z list� wszystko jest OK");
					return list.get(i + 1);
				}

			}
		}
		log.debug("Na li�cie jest tylko jeden element lub jest wiele tych samych element�w");
		return null;
	}

	/**
	 * Funkcja sprawdza czy w danym stringu znajduj� si� tylko cyfry lub
	 * ewentualnie minus na pocz�tku
	 * 
	 * @param s
	 * @return true kiedy s� tylko cyfry lub minus na pocz�tku, false kiedy sa
	 *         inne znaki
	 */
	public static boolean isNumber(String s) {
		if ((s.charAt(0) < '0' || s.charAt(0) > '9') && s.charAt(0) != '-') {
			log.debug("Ci�g znak�w " + s + " nie jest liczb�");
			return false;
		} else {
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) < '0' || s.charAt(i) > '9') {
					log.debug("Ci�g znak�w " + s + " nie jest liczb�");
					return false;
				}
			}
		}
		log.debug("Ci�g znak�w " + s + " jest liczb�");
		return true;
	}
}
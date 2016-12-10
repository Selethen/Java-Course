package randomProgramy;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Lukasz Parulski
 *
 *         Program do zwracania przednajwiekszej liczby calkowitej z podanych
 * 
 */
public class Program {

	/**
	 * Funkcja main
	 */
	public static void main(String[] args) {
		String stringNumbers = in();
		List<Integer> numbers = parseList(stringNumbers);
		Integer number = highestButOne(numbers);
		out(number);
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
			indeedNumbers.add(Integer.parseInt(numberAsString));
		}
		return indeedNumbers;
	}

	/**
	 * Funkcja wypisuje przednajwieksza liczbe z podanych
	 * 
	 * @param numbers
	 */
	public static void out(Integer number) {
		System.out.println("Przednajwieksza liczba z podanych to: ");
		System.out.println(number);
	}

	/**
	 * Funkcja zwraca przednajwieksza z podanej listy liczb
	 * 
	 * @param list
	 * 
	 * @return Zwraca przednajwiêksz¹ liczbê z listy, lub null je¿eli przednajwiêksza liczba nie istnieje
	 */
	public static Integer highestButOne(List<Integer> list) {
		Collections.sort(list);
		Collections.reverse(list);
		int i;
		if (list.size() == 2)
			return list.get(1);
		else {
			for (i = 0; i < list.size() - 1; i++) {
				if (list.get(i) != list.get(i + 1)) {
					return list.get(i + 1);
				}

			}
		}
		return null;
	}
}
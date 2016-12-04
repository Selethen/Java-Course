package randomProgramy;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Program do zwracania
przednajwiekszej z podanych
liczb calkowitych.*/

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Podaj liczby: ");
		String allNumbers = sc.nextLine();
		List<String> numbers = new ArrayList<>();
		numbers = Arrays.asList(allNumbers.split("\\s"));
		List<Integer> indeedNumbers = new ArrayList<>();
		for (String numberAsString : numbers) {
			indeedNumbers.add(Integer.parseInt(numberAsString));
		}
		System.out.println(highestButOne(indeedNumbers));
	}

	/*
	 * Funkcja zwracajaca przednajwieksza liczbe z listy.
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

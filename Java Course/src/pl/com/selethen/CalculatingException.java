package pl.com.selethen;

/**
 * Klasa wyj�tku CaltulatinException kt�ra dziedziczy po klasie Exception
 * 
 * @author Selethen
 */
public class CalculatingException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Podstawowy konstruktor, kt�ry tworzy nowy wyj�tek
	 */
	public CalculatingException() {
	}

	/**
	 * Konstruktor, kt�ry tworzy wyj�tek zawieraj�cy wiadomos�
	 * 
	 * @param message
	 *            wiadomo�� na temat wyj�tku
	 */
	public CalculatingException(String message) {
		super(message);
	}
}

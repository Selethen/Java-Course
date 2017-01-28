package pl.com.selethen;

/**
 * Klasa wyj¹tku CaltulatinException która dziedziczy po klasie Exception
 * 
 * @author Selethen
 */
public class CalculatingException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Podstawowy konstruktor, który tworzy nowy wyj¹tek
	 */
	public CalculatingException() {
	}

	/**
	 * Konstruktor, który tworzy wyj¹tek zawieraj¹cy wiadomosæ
	 * 
	 * @param message
	 *            wiadomoœæ na temat wyj¹tku
	 */
	public CalculatingException(String message) {
		super(message);
	}
}

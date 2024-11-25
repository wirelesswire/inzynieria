package biznesowa;

import dane.*;

public interface Strategia {

	/**
	 * Przetwarza dane użytkownika i zwraca obiekt `pozyskaneDane`.
	 *
	 * @param uzytkownik użytkownik, którego dane mają zostać przetworzone
	 * @return obiekt `pozyskaneDane`
	 */
	pozyskaneDane przetworzDane(uzytkownik uzytkownik);
}
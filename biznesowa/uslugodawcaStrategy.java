package biznesowa;

import dane.*;

public class uslugodawcaStrategy implements Strategia {

	/**
	 * 
	 * @param dane
	 * @param uzytkownik
	 */
	@Override
	public pozyskaneDane przetworzDane(dane dane, uzytkownik uzytkownik) {
		if (!(uzytkownik instanceof uslugodawca)) {
			throw new IllegalArgumentException("Podany użytkownik nie jest usługodawcą.");
		}

		uslugodawca uslugodawca = (uslugodawca) uzytkownik;
		pozyskaneDane pozyskaneDane = new pozyskaneDane();

		// Wypełnianie danych specyficznych dla usługodawcy
		pozyskaneDane.uslugodawcy = new uslugodawca[] {uslugodawca};
		pozyskaneDane.uzytkownicy = new uzytkownik[] {uslugodawca};
		pozyskaneDane.oferty = uslugodawca.getDostepneOferty();

		return pozyskaneDane;
	}
}

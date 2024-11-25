package biznesowa;

import dane.*;

public class pracownikStrategy implements Strategia {

	@Override
	public pozyskaneDane przetworzDane(uzytkownik uzytkownik) {
		if (!(uzytkownik instanceof pracownik)) {
			throw new IllegalArgumentException("Podany użytkownik nie jest pracownikiem.");
		}

		pracownik prac = (pracownik) uzytkownik;
		pozyskaneDane pozyskaneDane = new pozyskaneDane();

		// Wypełnianie danych specyficznych dla pracownika
		pozyskaneDane.pracownicy = new pracownik[] {prac};
		pozyskaneDane.uzytkownicy = new uzytkownik[] {prac};

		return pozyskaneDane;
	}
}

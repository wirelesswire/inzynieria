package biznesowa;

import dane.*;

public class pracownikStrategy implements Strategia {

	/**
	 * 
	 * @param dane
	 * @param uzytkownik
	 */
	@Override
	public pozyskaneDane przetworzDane(dane dane, uzytkownik uzytkownik) {
		if (!(uzytkownik instanceof pracownik)) {
			throw new IllegalArgumentException("Podany uzytkownik nie jest pracownikiem.");
		}

		pracownik prac = (pracownik) uzytkownik;
		pozyskaneDane pozyskaneDane = new pozyskaneDane();

		// Wypełnianie danych specyficznych dla pracownika
		pozyskaneDane.pracownicy = dane.zwrocPracownikow();
		pozyskaneDane.uzytkownicy = dane.zwrocUzytkownikow();
		pozyskaneDane.problemy = dane.zwrocProblemy();
		return pozyskaneDane;
	}
}

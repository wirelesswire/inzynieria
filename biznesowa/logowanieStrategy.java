package biznesowa;

import dane.*;

public class logowanieStrategy implements Strategia {

	private dane daneBaza;

	// Konstruktor przyjmujący obiekt klasy dane (z dostępem do bazy)
	public logowanieStrategy(dane daneBaza) {
		this.daneBaza = daneBaza;
	}

	/**
	 * 
	 * @param dane
	 * @param uzytkownik
	 */
	@Override
	public pozyskaneDane przetworzDane(dane dane, uzytkownik uzytkownik) {
		// Tworzymy obiekt pozyskanych danych
		pozyskaneDane pozyskaneDane = new pozyskaneDane();

		// Pobieramy wszystkich użytkowników z bazy danych za pomocą klasy dane
		pozyskaneDane.uzytkownicy = daneBaza.zwrocUzytkownikow();

		// Zwracamy obiekt z pozyskanymi danymi
		return pozyskaneDane;
	}
}

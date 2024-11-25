package biznesowa;

import dane.*;

public class logowanieStrategy implements Strategia {

	private dane daneBaza;

	// Konstruktor przyjmujący obiekt klasy dane (z dostępem do bazy)
	public logowanieStrategy(dane daneBaza) {
		this.daneBaza = daneBaza;
	}

	@Override
	public pozyskaneDane przetworzDane(uzytkownik uzytkownik) {
		// Tworzymy obiekt pozyskanych danych
		pozyskaneDane dane = new pozyskaneDane();

		// Pobieramy wszystkich użytkowników z bazy danych za pomocą klasy dane
		dane.uzytkownicy = daneBaza.zwrocUzytkownikow();

		// Zwracamy obiekt z pozyskanymi danymi
		return dane;
	}
}

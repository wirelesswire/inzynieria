package biznesowa;

import dane.*;

public class pozyskiwaczDanych {

	private uzytkownik uzytkownik;
	private Strategia strategia;

	// Przechowywanie pozyskanych danych
	public pozyskaneDane pozyskaneDane;

	// Konstruktor
	public pozyskiwaczDanych(uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	// Ustawienie strategii
	public void setStrategia(Strategia strategia) {
		this.strategia = strategia;
	}

	// Metoda pozyskiwania danych
	public pozyskaneDane pozyskajDane() {
		if (strategia == null) {
			throw new IllegalStateException("Strategia nie została ustawiona.");
		}
		this.pozyskaneDane = strategia.przetworzDane(uzytkownik);
		return this.pozyskaneDane;
	}
}

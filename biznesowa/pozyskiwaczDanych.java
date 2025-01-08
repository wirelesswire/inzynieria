package biznesowa;

import dane.*;

public class pozyskiwaczDanych {

	private uzytkownik uzytkownik;
	private Strategia strategia;

	// Przechowywanie pozyskanych danych
	public pozyskaneDane pozyskaneDane;
	public dane dane;

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
			throw new IllegalStateException("Strategia nie zostala ustawiona.");
		}
		this.pozyskaneDane = strategia.przetworzDane(dane , uzytkownik);
		return this.pozyskaneDane;
	}



	public void operation() {
		// TODO - implement pozyskiwaczDanych.operation
		throw new UnsupportedOperationException();
	}
}

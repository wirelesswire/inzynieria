package biznesowa;

import dane.*;
import widok.*;

public class biznesowa implements przetwarzanieDanych {

	private uzytkownik uzytkownik;
	private edytorBazy edytorbazy;
	private pozyskiwaczDanych pozyskiwacz;
	public widok widok;

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	public daneDlaUzytkownika zaloguj(String login, String haslo) {
		// TODO - implement biznesowa.zaloguj
		throw new UnsupportedOperationException();
	}

	private daneDlaUzytkownika stworzDane() {
		// TODO - implement biznesowa.stworzDane
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param przycisk
	 * @param argumenty
	 */
	public void kliknietyPrzycisk(String przycisk, String[] argumenty) {
		// TODO - implement biznesowa.kliknietyPrzycisk
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param edytor
	 * @param widok
	 */
	public biznesowa(edytorBazy edytor, widok widok) {
		this.edytorbazy = edytor;
		this.pozyskiwacz = pozyskiwacz;
		// TODO - implement biznesowa.biznesowa
		throw new UnsupportedOperationException();
	}

}
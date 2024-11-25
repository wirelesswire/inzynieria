package biznesowa;

import dane.*;
import widok.*;

public class biznesowa implements przetwarzanieDanych {

	private uzytkownik uzytkownik;
	private edytorBazy edytorbazy;
	private pozyskiwaczDanych pozyskiwacz;
	public widok widok;
	private pozyskaneDane daneUzytkownika;

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
		switch (przycisk){
			case "zaloguj":

				break;
//			case ""
			default:
				System.out.println("lol");
		}

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

		czyIstnieje czy1 = new czyIstnieje();
		czyHasloSieZgadza czy2 = new czyHasloSieZgadza();
		czyJestAktywny czy3 = new czyJestAktywny();

		czy1.setNext(czy2);
		czy2.setNext(czy3);






//		 TODO - implement biznesowa.biznesowa
//		throw new UnsupportedOperationException();
	}

}
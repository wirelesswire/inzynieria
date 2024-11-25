package widok;
import java.io.*;
import biznesowa.daneDlaUzytkownika;

public class widok implements zmianaWidoku {

	private daneDlaUzytkownika dane;
	Console console;

	public widok(){
		console = System.console();
	}

	public void pokazLogowanie() {


		System.out.println("podaj login i hasło ");
		System.out.println("login :  ");

		String login  = console.readLine();

		System.out.println("hasło :  ");

		String haslo  = console.readLine();


		// TODO - implement widok.pokazLogowanie
		throw new UnsupportedOperationException();
	}

	private void zlecSprawdzenieDanych() {
		// TODO - implement widok.zlecSprawdzenieDanych
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dane
	 */
	private void wynikLogowania(daneDlaUzytkownika dane) {
		// TODO - implement widok.wynikLogowania
		throw new UnsupportedOperationException();
	}

	public void wyswietlWiadomosc() {
		// TODO - implement widok.wyswietlWiadomosc
		throw new UnsupportedOperationException();
	}

	private void wyswietlPomocTechniczna() {
		// TODO - implement widok.wyswietlPomocTechniczna
		throw new UnsupportedOperationException();
	}

	private void wyswietlBlokowanieKonta() {
		// TODO - implement widok.wyswietlBlokowanieKonta
		throw new UnsupportedOperationException();
	}

	private void wyswietlPrzegladanieKlientow() {
		// TODO - implement widok.wyswietlPrzegladanieKlientow
		throw new UnsupportedOperationException();
	}

	private void wyswietlDodawanieOferty() {
		// TODO - implement widok.wyswietlDodawanieOferty
		throw new UnsupportedOperationException();
	}

	private void wyswietlUsuwanieOferty() {
		// TODO - implement widok.wyswietlUsuwanieOferty
		throw new UnsupportedOperationException();
	}

	private void wyswietlAnulowanieUslugi() {
		// TODO - implement widok.wyswietlAnulowanieUslugi
		throw new UnsupportedOperationException();
	}

	private void wyswietlZaplacenieZaUsluge() {
		// TODO - implement widok.wyswietlZaplacenieZaUsluge
		throw new UnsupportedOperationException();
	}

	private void wyswietlPrzegladanieHistoriiUslug() {
		// TODO - implement widok.wyswietlPrzegladanieHistoriiUslug
		throw new UnsupportedOperationException();
	}

	private void wyswietlOcenaUslugodawcy() {
		// TODO - implement widok.wyswietlOcenaUslugodawcy
		throw new UnsupportedOperationException();
	}

	public boolean poprosOPotwierdzenie() {
		// TODO - implement widok.poprosOPotwierdzenie
		throw new UnsupportedOperationException();
	}

	public void wyswietlWidokKlienta() {
		// TODO - implement widok.wyswietlWidokKlienta
		throw new UnsupportedOperationException();
	}

	public void wyswietlWidokPracownika() {
		// TODO - implement widok.wyswietlWidokPracownika
		throw new UnsupportedOperationException();
	}

	public void wyswietlWidokUslugodawcy() {
		// TODO - implement widok.wyswietlWidokUslugodawcy
		throw new UnsupportedOperationException();
	}








}
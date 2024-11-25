package biznesowa;

import widok.*;

import java.util.Objects;
import java.util.Scanner;

public class widok implements zmianaWidoku {

	private daneDlaUzytkownika dane;
	public biznesowa warstwaBiznesowa;
	Scanner scanner;

	public widok(){
		scanner = new Scanner(System.in);
	}

	public void pokazLogowanie() {
		System.out.println("podaj login i hasło ");
		System.out.println("login :  ");

		String login  = scanner.nextLine();

		System.out.println("hasło :  ");

		String haslo  = scanner.nextLine();

		zlecSprawdzenieDanych(login,haslo);
	}
	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	private void zlecSprawdzenieDanych(String login, String haslo) {
		warstwaBiznesowa.kliknietyPrzycisk("zaloguj",new String[]{login,haslo});
//
//		// TODO - implement widok.zlecSprawdzenieDanych
//		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dane
	 */
	private void wynikLogowania(daneDlaUzytkownika dane) {
		wyswietlWiadomosc(dane.wiadomosc);


//		// TODO - implement widok.wynikLogowania
//		throw new UnsupportedOperationException();
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
		System.out.println("Potwierdz wybraną operację  [tak/NIE]");
		String line = scanner.nextLine();
		if(Objects.equals(line, "tak")){
			System.out.println("potwierdzono");
			return  true ;
		}
		return false  ;
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

	@Override
	public void wyswietlWiadomosc(wiadomosc wiadomosc) {
		if(wiadomosc.tresc == null || wiadomosc.kolor == null ){
			System.out.println("wiadomosc debug ");
		return;
		}

		System.out.println(wiadomosc.kolor + wiadomosc.tresc);
	}



}
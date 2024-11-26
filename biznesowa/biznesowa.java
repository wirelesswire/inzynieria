package biznesowa;

import dane.*;
import widok.*;

public class biznesowa implements przetwarzanieDanych {

	private uzytkownik uzytkownik;
	private edytorBazy edytorbazy;
	private pozyskiwaczDanych pozyskiwacz;
	public widok widok;
	private pozyskaneDane daneUzytkownika;
	private czyIstnieje obslugaLogowania;
	public dane dane;

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
				pozyskiwaczDanych p = new pozyskiwaczDanych(null); // null tylko tutaj w reszcie zapewne błąd
				Strategia s = new logowanieStrategy(this.dane);
				p.setStrategia(s);
				p.pozyskajDane();
				wiadomosc x = obslugaLogowania.sprawdz(argumenty[0],argumenty[1],p);
				if(x.tresc == null ){
					this.uzytkownik = obslugaLogowania.user;
				}
				else{
					widok.wyswietlWiadomosc(x);
				}
//				sendBaseView();
				break;
			case "dodanieoferty":
				widok.wyswietlWiadomosc(new wiadomosc("wybrałeś dodanie oferty "));
				break;
			case "usunecieoferty":
				widok.wyswietlWiadomosc(new wiadomosc("wybrałeś usuniecie oferty "));

				break;
			case "pomoc":
				widok.wyswietlWiadomosc(new wiadomosc("wybrałeś udzielenie pomocy  "));

				break;
			case "blokada":
				widok.wyswietlWiadomosc(new wiadomosc("wybrałeś blokade konta  "));

				break;
			case "wyloguj":
				this.uzytkownik = null ;
				widok.pokazLogowanie();
				return;
//				break;

			default:
				System.out.println("lol");
		}
		sendBaseView();

	}
	public void sendBaseView(){
		if(this.uzytkownik instanceof pracownik){
			widok.wyswietlWidokPracownika();
//					System.out.println("jest pracowanikiem ");
		}
		if(this.uzytkownik instanceof uslugodawca){
			widok.wyswietlWidokUslugodawcy();
//					System.out.println("jest uslugodawca  ");
		}
		if(this.uzytkownik instanceof klient){
			widok.wyswietlWidokKlienta();
//					System.out.println("jest klientem ");
		}
	}
	/**
	 * 
	 * @param edytor
	 * @param widok
	 */
	public biznesowa(edytorBazy edytor, widok widok) {
		this.edytorbazy = edytor;
		this.pozyskiwacz = pozyskiwacz;
		this.widok = widok;
		czyIstnieje czy1 = new czyIstnieje();
		czyHasloSieZgadza czy2 = new czyHasloSieZgadza();
		czyJestAktywny czy3 = new czyJestAktywny();

		czy1.setNext(czy2);
		czy2.setNext(czy3);

		this.obslugaLogowania = czy1;

	}

}
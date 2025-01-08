package biznesowa;

import dane.*;
import widok.*;
//import daneDlaUzytkownika;
public class biznesowa implements przetwarzanieDanych {

	private uzytkownik uzytkownik;
	public  edytorBazy edytorbazy;
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
	public boolean zaloguj(String login, String haslo) {

		pozyskiwacz  = new pozyskiwaczDanych(null); // null tylko tutaj w reszcie zapewne błąd
		Strategia s = new logowanieStrategy(this.dane);
		pozyskiwacz.setStrategia(s);
		pozyskaneDane d =  pozyskiwacz.pozyskajDane();
		wiadomosc x = obslugaLogowania.sprawdz(login , haslo ,pozyskiwacz);// ?a?cuch daje r�?ne wiadomo?ci

		if(x.tresc == null ){
			this.uzytkownik = obslugaLogowania.user;
//					pozyskaneDane  d = pozyskajDane();
			return  true ;
		}
		else{
			widok.wyswietlWiadomosc(x);
		}
		return  false ;

//		throw new UnsupportedOperationException();

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
				boolean logowanieUdane = zaloguj(argumenty[0],argumenty[1]);
				if( ! logowanieUdane){
					break;
				}
				pozyskiwacz  = new pozyskiwaczDanych(this.uzytkownik);
				pozyskiwacz.dane= dane ;
				Strategia s = null ;
				if(this.uzytkownik instanceof pracownik ){
					s = new pracownikStrategy();
				}
				else if(this.uzytkownik instanceof uslugodawca){
					s = new uslugodawcaStrategy();
				}
				else if(this.uzytkownik instanceof klient){
					s = new klientStrategy();
				}
				else{
					System.out.println("Blad");
				}
				if(s != null){
					pozyskiwacz.setStrategia(s);

				}
				break;
			case "dodanieoferty":
				edytorbazy.dodajOferte(argumenty, uzytkownik);
				widok.wyswietlWiadomosc(new wiadomosc("wybrano dodanie oferty "));
				break;
			case "usunecieoferty":
				edytorbazy.usunOferte(argumenty,uzytkownik);
				widok.wyswietlWiadomosc(new wiadomosc("wybrano usuniecie oferty "));
				break;
			case "pomoc":
				widok.wyswietlWiadomosc(new wiadomosc("wybrano udzielenie pomocy  "));
//				pracownikStrategy p = new pracownikStrategy();
//				pozyskiwacz.setStrategia(p);
				edytorbazy.pomozTechnicznie(Integer.parseInt( argumenty[0]));

				break;
			case "blokada":
				widok.wyswietlWiadomosc(new wiadomosc("wybrano blokade konta  "));
				edytorbazy.zablokujKonto(Integer.parseInt( argumenty[0]));
				break;
			case "wyloguj":
				this.uzytkownik = null ;
				widok.pokazLogowanie();
				return;
			default:
				System.out.println("lol");
		}
		wyswietlWidok();

	}
	public void wyswietlWidok(){

		pozyskaneDane pDane = pozyskajDane();
		daneDlaUzytkownika d = stworzWidok(pDane,uzytkownik);

		if(this.uzytkownik instanceof pracownik ){
			widok.wyswietlWidokPracownika((daneDlaPracownika)d);
		}
		else if(this.uzytkownik instanceof uslugodawca){
			widok.wyswietlWidokUslugodawcy((daneDlaUslugodawcy) d);
		}
		else if(this.uzytkownik instanceof klient){
			widok.wyswietlWidokKlienta((daneDlaKlienta) d);
		}
		else {
			widok.pokazLogowanie();
		}
	}



	/**
	 * 
	 * @param pozyskaneDane
	 * @param uzytkownik
	 */
	public daneDlaUzytkownika stworzWidok(pozyskaneDane pozyskaneDane, uzytkownik uzytkownik) {

		tworcaWidoku tw = new tworcaWidoku();
		daneDlaUzytkownika  d =tw.stworzWidok(pozyskaneDane,uzytkownik);
		return  d ;
	}

	/**
	 * 
	 * @param edytor
	 * @param widok
	 */
	public biznesowa(edytorBazy edytor, widok widok) {
		this.edytorbazy = edytor;
//		this.pozyskiwacz = pozyskiwacz;
		this.widok = widok;

		czyIstnieje czy1 = new czyIstnieje();
		czyHasloSieZgadza czy2 = new czyHasloSieZgadza();
		czyJestAktywny czy3 = new czyJestAktywny();

		czy1.setNext(czy2);
		czy2.setNext(czy3);

		this.obslugaLogowania = czy1;

	}

	public pozyskaneDane pozyskajDane() {
		return   pozyskiwacz.pozyskajDane();
	}



}
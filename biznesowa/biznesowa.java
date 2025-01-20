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

	public void setUzytkownik(uzytkownik u ){
		this.uzytkownik = u ;
	}

	public pozyskiwaczDanych getPozyskiwacz(){
		return pozyskiwacz;
	}
	public uzytkownik getUzytkownik(){
		return uzytkownik;
	}
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
			return  true ;
		}
		else{
			widok.wyswietlWiadomosc(x);
		}
		return  false ;


	}

	private daneDlaUzytkownika stworzDane() {
		// TODO - implement biznesowa.stworzDane
		throw new UnsupportedOperationException();
	}

public void zalogowano(){

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
	wyswietlWidok();
}
	/**
	 *
	 * @param przycisk
	 * @param argumenty
	 */
	public void kliknietyPrzycisk(String przycisk, String[] argumenty) {
		boolean potwierdzenie = false;
		switch (przycisk){
			case "zaloguj":
				boolean logowanieUdane = zaloguj(argumenty[0],argumenty[1]);
				if( ! logowanieUdane){
					break;
				}
				zalogowano();
				return;
//				break;
			case "dodanieoferty":
				potwierdzenie =  widok.poprosOPotwierdzenie();
				if(!potwierdzenie){
					break;
				}
				edytorbazy.dodajOferte(argumenty, uzytkownik);
				widok.wyswietlWiadomosc(new wiadomosc("wybrano dodanie oferty "));
				break;
			case "usunecieoferty":
				 potwierdzenie =  widok.poprosOPotwierdzenie();
				if(!potwierdzenie){
					break;
				}
				edytorbazy.usunOferte(argumenty,uzytkownik);
				widok.wyswietlWiadomosc(new wiadomosc("wybrano usuniecie oferty "));
				break;
			case "pomoc":
				potwierdzenie =  widok.poprosOPotwierdzenie();
				if(!potwierdzenie){
					break;
				}
				widok.wyswietlWiadomosc(new wiadomosc("wybrano udzielenie pomocy  "));
				edytorbazy.pomozTechnicznie(Integer.parseInt( argumenty[0]));
				break;
			case "blokada":
				potwierdzenie =  widok.poprosOPotwierdzenie();
				if(!potwierdzenie){
					break;
				}
				widok.wyswietlWiadomosc(new wiadomosc("wybrano blokade konta  "));
				edytorbazy.zablokujKonto(Integer.parseInt( argumenty[0]));
				break;
			case "wyloguj":
				wyloguj();
				widok.pokazLogowanie();

				return;
			default:
				System.out.println("lol");
		}
		wyswietlWidok();


	}

	public void wyloguj(){
		this.uzytkownik = null ;
		throw new UnsupportedOperationException();

	}

	public void wyswietlWidok(){
		pozyskaneDane pozyskaneDane = pozyskajDane();
		daneDlaUzytkownika daneDlaUzytkownika= stworzWidok(pozyskaneDane);

		if(this.uzytkownik instanceof pracownik ){
			widok.wyswietlWidokPracownika((daneDlaPracownika)daneDlaUzytkownika);
		}
		else if(this.uzytkownik instanceof uslugodawca){
			widok.wyswietlWidokUslugodawcy((daneDlaUslugodawcy) daneDlaUzytkownika);
		}
		else if(this.uzytkownik instanceof klient){
			widok.wyswietlWidokKlienta((daneDlaKlienta) daneDlaUzytkownika);
		}
		else {
			widok.pokazLogowanie();
		}
	}
	/**
	 * 
	 * @param pozyskaneDane
//	 * @param uzytkownik
	 */
	public daneDlaUzytkownika stworzWidok(pozyskaneDane pozyskaneDane) {
		tworcaWidoku tworcaWidoku = new tworcaWidoku();
		daneDlaUzytkownika  daneDlaUzytkownika =tworcaWidoku.stworzWidok(pozyskaneDane,this.uzytkownik);
		return  daneDlaUzytkownika;
	}
	/**
	 * 
	 * @param edytor
	 * @param widok
	 */
	public biznesowa(edytorBazy edytor, widok widok) {
		this.edytorbazy = edytor;
		this.pozyskiwacz = new pozyskiwaczDanych(null);
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
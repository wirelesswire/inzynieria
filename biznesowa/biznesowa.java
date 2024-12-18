package biznesowa;

import dane.*;
import widok.*;

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
				pozyskiwacz  = new pozyskiwaczDanych(null); // null tylko tutaj w reszcie zapewne błąd
				Strategia s = new logowanieStrategy(this.dane);
				pozyskiwacz.setStrategia(s);
				pozyskiwacz.pozyskajDane();
				wiadomosc x = obslugaLogowania.sprawdz(argumenty[0],argumenty[1],pozyskiwacz);
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
				pracownikStrategy p = new pracownikStrategy();
				pozyskiwacz.setStrategia(p);

				edytorbazy.pomozTechnicznie(Integer.parseInt( argumenty[0]));

//				pozyskaneDane pd = pozyskiwacz.pozyskajDane();

				break;
			case "blokada":
				widok.wyswietlWiadomosc(new wiadomosc("wybrałeś blokade konta  "));

				edytorbazy.zablokujKonto(Integer.parseInt( argumenty[0]));


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

		tworcaWidoku tw = new tworcaWidoku();




		daneDlaUzytkownika  d =tw.stworzWidok(dane,uzytkownik);


		if(this.uzytkownik instanceof pracownik ){
//			daneDlaPracownika d =  tw.stworzWidok(dane );
			widok.wyswietlWidokPracownika((daneDlaPracownika)d);
//					System.out.println("jest pracowanikiem ");
		}
		else if(this.uzytkownik instanceof uslugodawca){
			widok.wyswietlWidokUslugodawcy((daneDlaUslugodawcy) d);
//					System.out.println("jest uslugodawca  ");
		}
		else if(this.uzytkownik instanceof klient){
			widok.wyswietlWidokKlienta((daneDlaKlienta) d);
//					System.out.println("jest klientem ");
		}
		else {
			System.out.println("KRYTYCZXNY B�?ĄD  ");
			return;
		}
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

}
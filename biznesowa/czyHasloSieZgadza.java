package biznesowa;

import dane.uzytkownik;

import java.util.Objects;

public class czyHasloSieZgadza implements obslugaLogowania {
	private obslugaLogowania next;
	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param pozyskiwaczDanych
	 */
	public wiadomosc sprawdz(String login, String haslo, pozyskiwaczDanych pozyskiwaczDanych) {
		wiadomosc w = new wiadomosc("taki uzytkownik nie istnieje");

		for (int i = 0; i < pozyskiwaczDanych.pozyskaneDane.uzytkownicy.length ; i++) {
			uzytkownik tmpUser = pozyskiwaczDanych.pozyskaneDane.uzytkownicy[i];
			if(Objects.equals(tmpUser.getLogin(), login)){
				if(Objects.equals(tmpUser.getHaslo(), haslo)){
//					w.tresc="zalogowano pomyslnie";
					w.tresc = null;
				}
				else {
					w.tresc="bledne haslo";
					return  w;
				}
				break;
			}
		}

		if(next != null && w.tresc == null){
			return  next.sprawdz(login, haslo, pozyskiwaczDanych);
		}

//		w.tresc = "błąd krytyczny(tu nie powinno nigdy dojsc )";
		return w ;
	}
	/**
	 * 
	 * @param next
	 */
	public void setNext(obslugaLogowania next) {
		this.next = next;
	}
}
package biznesowa;

import dane.uzytkownik;

import java.util.Objects;

public class czyIstnieje implements obslugaLogowania {

	private obslugaLogowania next;
	public uzytkownik user;

	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param pozyskiwaczDanych
	 */
	public wiadomosc sprawdz(String login, String haslo, pozyskiwaczDanych pozyskiwaczDanych) {
		wiadomosc w = new wiadomosc();

		boolean exists = false ;
		for (int i = 0; i < pozyskiwaczDanych.pozyskaneDane.uzytkownicy.length ; i++) {
			uzytkownik tmpuser = pozyskiwaczDanych.pozyskaneDane.uzytkownicy[i];
			if(Objects.equals(tmpuser.getLogin(), login)){
				exists = true;
				this.user =tmpuser;
				break;
			}
		}
		if(exists){
			if(next == null){
				return w ;
			}
			return next.sprawdz(login, haslo, pozyskiwaczDanych);
		}
		else {
			w.tresc = "konto o podanym loginie nie istnieje";
		}

//
//		if(w.tresc == null){
//			if()
//		}
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
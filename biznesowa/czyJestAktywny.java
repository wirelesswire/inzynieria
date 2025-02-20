package biznesowa;

import dane.uzytkownik;

import java.util.Objects;

public class czyJestAktywny implements obslugaLogowania {

	public obslugaLogowania next;

	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param pozyskiwaczDanych
	 */
	public wiadomosc sprawdz(String login, String haslo, pozyskiwaczDanych pozyskiwaczDanych) {
		wiadomosc w = new wiadomosc();
		for (int i = 0; i < pozyskiwaczDanych.pozyskaneDane.uzytkownicy.length ; i++) {
			uzytkownik tmpUser = pozyskiwaczDanych.pozyskaneDane.uzytkownicy[i];
			if(Objects.equals(tmpUser.getLogin(), login)){
				if(Objects.equals(tmpUser.getStatus(), "aktywny")){
//					w.tresc = "";
					break;
				}
				else if(Objects.equals(tmpUser.getStatus(), "nieaktywny")){
					w.tresc = "uzytkownik nieaktywny";
				}
				else if (Objects.equals(tmpUser.getStatus(), "zablokowany")) {
					w.tresc = "uzytkownik zablokowany";
				}
				else if(Objects.equals(tmpUser.getStatus(), null)){
					throw new  NullPointerException();
				}
				else{
					w.tresc = "wystapil blad ";
				}
			}
		}
		if(next != null  && w.tresc == null){
			return next.sprawdz(login, haslo, pozyskiwaczDanych);
		}
		return  w ;
	}
	/**
	 * 
	 * @param next
	 */
	public void setNext(obslugaLogowania next) {
		this.next = next;
	}
}
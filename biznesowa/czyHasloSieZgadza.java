package biznesowa;

public class czyHasloSieZgadza implements obslugaLogowania {

	private obslugaLogowania next;

	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param pozyskiwaczDanych
	 */
	public wiadomosc sprawdz(String login, String haslo, pozyskiwaczDanych pozyskiwaczDanych) {
		wiadomosc w = new wiadomosc();

		for (int i = 0; i < pozyskiwaczDanych.pozyskaneDane.uzytkownicy.length ; i++) {
			if(pozyskiwaczDanych.pozyskaneDane.uzytkownicy[i].getLogin() == login){
				if(pozyskiwaczDanych.pozyskaneDane.uzytkownicy[i].getHaslo() == haslo){
//					w.tresc="zalogowano pomyslnie";
				}
				w.tresc="błędne haslo";
				return  w;
			}

		}
		if(w.tresc == null){

			if(next != null){
				return  next.sprawdz(login, haslo, pozyskiwaczDanych);
			}
			else{
				return  null ;
			}
		}
		w.tresc = "błąd krytyczny(tu nie powinno nigdy dojsc )";
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
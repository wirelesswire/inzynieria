package biznesowa;

public class czyIstnieje implements obslugaLogowania {

	private obslugaLogowania next;

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
			if(pozyskiwaczDanych.pozyskaneDane.uzytkownicy[i].getLogin() == login){

			}

		}
		if(exists){
			if(next == null){
				return w ;
			}
			return next(login);
		}
		else {
			w.tresc = "konto o podanym loginie nie istenije";
		}

//
//		if(w.tresc == null){
//			if()
//		}
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
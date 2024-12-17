package biznesowa;

import dane.*;

public interface Strategia {

	/**
	 * 
	 * @param dane
	 * @param uzytkownik
	 */
	pozyskaneDane przetworzDane(dane dane, uzytkownik uzytkownik);
}
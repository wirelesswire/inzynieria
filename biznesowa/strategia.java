package biznesowa;

import dane.dane;
import dane.*;

public interface Strategia {


	/**
	 * 
	 * @param uzytkownik
	 */
	pozyskaneDane przetworzDane(uzytkownik uzytkownik);


}
package biznesowa;
import  dane.*;
public class tworcaKlienta extends tworcaWidoku {

	/**
	 * 
	 * @param dane
	 */
	public daneDlaKlienta stworzDane(dane dane) {

		daneDlaKlienta d = new daneDlaKlienta();
		d.oferty = dane.zwrocOferty();


		return d ;

		}

}
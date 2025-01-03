package biznesowa;
import  dane.*;
public class tworcaKlienta extends tworcaWidoku {

	/**
	 * 
	 * @param pozyskaneDane
	 */
	public daneDlaKlienta stworzDane(pozyskaneDane pozyskaneDane) {
		daneDlaKlienta d = new daneDlaKlienta();
		d.oferty = pozyskaneDane.oferty;
		return d ;
	}

}
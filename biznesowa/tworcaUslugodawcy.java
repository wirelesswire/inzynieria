package biznesowa;

import  dane.*;

public class tworcaUslugodawcy extends tworcaWidoku {

//
//	/**
//	 *
//	 * @param dane
//	 */
//	public daneDlaUslugodawcy stworzDane(dane dane) {
////		// TODO - implement tworcaUslugodawcy.stworzDane
////		throw new UnsupportedOperationException();
//	}

	/**
	 * 
	 * @param pozyskaneDane
	 */
	public daneDlaUslugodawcy stworzDane(pozyskaneDane pozyskaneDane) {
		daneDlaUslugodawcy d = new daneDlaUslugodawcy();
		d.uzytkownicy = pozyskaneDane.uzytkownicy;
		d.oferty = pozyskaneDane.oferty;

		return d ;
//		throw new UnsupportedOperationException();
	}



}
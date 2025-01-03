package biznesowa;
import  dane.*;

public class tworcaPracownika extends tworcaWidoku {





	/**
	 * 
	 * @param pozyskaneDane
	 */
	public daneDlaPracownika stworzDane(pozyskaneDane pozyskaneDane) {
		daneDlaPracownika d =  new daneDlaPracownika();
		d.problemy = pozyskaneDane.problemy;
		d.uzytkownicy = pozyskaneDane.uzytkownicy;
		return d ;
	}



}
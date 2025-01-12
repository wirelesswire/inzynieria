package biznesowa;
import  dane.*;

public class tworcaPracownika extends tworcaWidoku {





	/**
	 * 
	 * @param pozyskaneDane
	 */
	public daneDlaPracownika stworzDane(pozyskaneDane pozyskaneDane) {
		daneDlaPracownika daneDlaPracownika =  new daneDlaPracownika();
		daneDlaPracownika.problemy = pozyskaneDane.problemy;
		daneDlaPracownika.uzytkownicy = pozyskaneDane.uzytkownicy;
		return daneDlaPracownika;
	}



}
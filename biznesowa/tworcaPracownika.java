package biznesowa;
import  dane.*;

public class tworcaPracownika extends tworcaWidoku {



	/**
	 * 
	 * @param dane
	 */
	public daneDlaPracownika stworzDane(dane dane) {
		daneDlaPracownika d =  new daneDlaPracownika();
		d.problemy = dane.zwrocProblemy();
		d.uzytkownicy = dane.zwrocUzytkownikow();
		return d ;
	}



}
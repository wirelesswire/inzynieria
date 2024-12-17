package biznesowa;
import  dane.*;
public class tworcaWidoku {


	/**
	 *
	 * @param dane
	 */
	public daneDlaUzytkownika stworzWidok(dane dane,uzytkownik uzytkownik) {

		daneDlaUzytkownika d = null ;
		tworcaWidoku tw  ;
		if(uzytkownik instanceof pracownik){
			 d = new tworcaPracownika().stworzDane(dane);
		}
		else if(uzytkownik instanceof uslugodawca){
			d = new tworcaUslugodawcy().stworzDane(dane);
		}
		else if(uzytkownik instanceof klient){
			d = new tworcaKlienta().stworzDane(dane);
		}
		else {
			System.out.println("KRYTYCZXNY BŁĄD  ");
		}


	return d ;
	}

}
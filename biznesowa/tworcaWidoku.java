package biznesowa;
import  dane.*;
public class tworcaWidoku {

	/**
	 * 
	 * @param pozyskaneDane
	 * @param uzytkownik
	 */
	public daneDlaUzytkownika stworzWidok(pozyskaneDane pozyskaneDane, uzytkownik uzytkownik) {
		daneDlaUzytkownika d = null ;
		tworcaWidoku tw  ;
		if(uzytkownik instanceof pracownik){
			d = new tworcaPracownika().stworzDane(pozyskaneDane);
		}
		else if(uzytkownik instanceof uslugodawca){
			d = new tworcaUslugodawcy().stworzDane(pozyskaneDane);
		}
		else if(uzytkownik instanceof klient){
			d = new tworcaKlienta().stworzDane(pozyskaneDane);
		}
		else {
			System.out.println("(brak widoku )");
		}


		return d ;
	}

}
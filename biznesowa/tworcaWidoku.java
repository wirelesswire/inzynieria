package biznesowa;
import  dane.*;
public class tworcaWidoku {

	/**
	 * 
	 * @param pozyskaneDane
	 * @param uzytkownik
	 */
	public daneDlaUzytkownika stworzWidok(pozyskaneDane pozyskaneDane, uzytkownik uzytkownik) {
		daneDlaUzytkownika daneDlaUzytkownika = null ;

		if(uzytkownik instanceof pracownik){
			tworcaPracownika tworcaPracownika = new tworcaPracownika();
			daneDlaUzytkownika  =  tworcaPracownika.stworzDane(pozyskaneDane);
		}
		else if(uzytkownik instanceof uslugodawca){
			tworcaUslugodawcy tworcaUslugodawcy = new tworcaUslugodawcy();
			daneDlaUzytkownika  = tworcaUslugodawcy.stworzDane(pozyskaneDane);
		}
		else if(uzytkownik instanceof klient){
			tworcaKlienta tworcaKlienta  = new tworcaKlienta();
			daneDlaUzytkownika   =  tworcaKlienta.stworzDane(pozyskaneDane);
		}



		return daneDlaUzytkownika   ;
	}

}
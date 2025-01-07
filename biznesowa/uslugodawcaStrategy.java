package biznesowa;

import dane.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class uslugodawcaStrategy implements Strategia {

	/**
	 * 
	 * @param dane
	 * @param uzytkownik
	 */
	@Override
	public pozyskaneDane przetworzDane(dane dane, uzytkownik uzytkownik) {
		if (!(uzytkownik instanceof uslugodawca)) {
			throw new IllegalArgumentException("Podany użytkownik nie jest usługodawcą.");
		}

		uslugodawca uslugodawca = (uslugodawca) uzytkownik;
		pozyskaneDane pozyskaneDane = new pozyskaneDane();

		// Wypełnianie danych specyficznych dla usługodawcy
		pozyskaneDane.uslugodawcy = new uslugodawca[] {uslugodawca};
		pozyskaneDane.uzytkownicy = new uzytkownik[] {uslugodawca};
//		pozyskaneDane.oferty = uslugodawca.getDostepneOferty();
		List<oferta> listaOfert = new ArrayList<>();
		oferta [] a =dane.zwrocOferty();
		for (int i = 0; i < a.length ; i++) {
			oferta o = a[i];
			if(o.getDostawca()==uzytkownik){
				listaOfert.add(o);

			}
		}



		usluga[] x = dane.zwrocUslugi();
		List<uzytkownik> listaUzytkownikow = new ArrayList<>();
		for (int i = 0; i < x.length ; i++) {
			usluga u = x[i];
			if(u.getUsluga().getDostawca()==uzytkownik){
				listaUzytkownikow.add(u.getOdbiorca());

			}
		}
		pozyskaneDane.uzytkownicy = listaUzytkownikow.toArray(new uzytkownik[0]);
		pozyskaneDane.oferty = listaOfert.toArray(new oferta[0]);
		return pozyskaneDane;
	}
}

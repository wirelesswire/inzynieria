package biznesowa;

import dane.*;

public interface dostepDoDanych {

	uzytkownik[] zwrocUzytkownikow();

	pracownik[] zwrocPracownikow();

	klient[] zwrocKlientow();

	uslugodawca[] zwrocUslugodawcow();

	oferta[] zwrocOferty();

	problem[] zwrocProblemy();

	baza zwrocBaze();

	/**
	 * 
	 * @param baza
	 */
	void ustawBaze(baza baza);

}
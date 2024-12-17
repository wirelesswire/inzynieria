package widok;

import biznesowa.wiadomosc;
import biznesowa.*;

public interface zmianaWidoku {

	/**
	 * 
	 * @param dane
	 */
	void wyswietlWidokKlienta(daneDlaUzytkownika dane);

	/**
	 * 
	 * @param dane
	 */
	void wyswietlWidokUslugodawcy(daneDlaUzytkownika dane);

	/**
	 * 
	 * @param dane
	 */
	void wyswietlWidokPracownika(daneDlaUzytkownika dane);

	public boolean poprosOPotwierdzenie();

	public void wyswietlWiadomosc(wiadomosc wiadomosc);
}
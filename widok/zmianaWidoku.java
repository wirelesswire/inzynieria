package widok;

import biznesowa.wiadomosc;
import biznesowa.*;

public interface zmianaWidoku {

	/**
	 * 
	 * @param dane
	 */
	void wyswietlWidokKlienta(daneDlaKlienta dane);

	/**
	 * 
	 * @param dane
	 */
	void wyswietlWidokUslugodawcy(daneDlaUslugodawcy dane);

	/**
	 * 
	 * @param dane
	 */
	void wyswietlWidokPracownika(daneDlaPracownika dane);

	public boolean poprosOPotwierdzenie();

	public void wyswietlWiadomosc(wiadomosc wiadomosc);
}
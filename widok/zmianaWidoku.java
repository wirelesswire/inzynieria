package widok;

import biznesowa.wiadomosc;

public interface zmianaWidoku {

	public void wyswietlWidokKlienta();

	public void wyswietlWidokUslugodawcy();

	public void wyswietlWidokPracownika();

	public boolean poprosOPotwierdzenie();

	public void wyswietlWiadomosc(wiadomosc wiadomosc);
}
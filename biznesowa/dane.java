package biznesowa;

import dane.*;

public class dane implements dostepDoDanych {

	private baza baza;

	public uzytkownik[] zwrocUzytkownikow() {
		return  baza.uzytkownicy;
		// TODO - implement dane.pobierzUzytkownikow
		throw new UnsupportedOperationException();
	}

	public pracownik[] zwrocPracownikow() {
		// TODO - implement dane.pobierzPracownikow
		return baza.pracownicy;
		throw new UnsupportedOperationException();
	}

	public klient[] zwrocKlientow() {
		// TODO - implement dane.pobierzKlientow
		return baza.klienci;
		throw new UnsupportedOperationException();
	}
22222
	public uslugodawca[] zwrocUslugodawcow() {
		return baza.uslugodawcy;
		// TODO - implement dane.pobierzUslugodawcow
		throw new UnsupportedOperationException();
	}

	public oferta[] zwrocOferty() {
		return baza.oferty;
		// TODO - implement dane.pobierzOferty
		throw new UnsupportedOperationException();
	}

	public problem[] zwrocProblemy() {
		return  baza.problemy;
		// TODO - implement dane.pobierzProblemy
		throw new UnsupportedOperationException();
	}

	public baza zwrocBaze() {
		return baza ;
		// TODO - implement dane.zwrocBaze
		throw new UnsupportedOperationException();
	}

	public usluga[] zwrocUslugi() {
		return baza.uslugi;
		// TODO - implement dane.zwrocUslugi
		throw new UnsupportedOperationException();
	}

}
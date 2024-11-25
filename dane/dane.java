package dane;

import biznesowa.dostepDoDanych;

public class dane implements dostepDoDanych {

	private baza baza;

	public uzytkownik[] zwrocUzytkownikow() {
		return  baza.uzytkownicy;
		// TODO - implement dane.pobierzUzytkownikow
	}

	public pracownik[] zwrocPracownikow() {
		// TODO - implement dane.pobierzPracownikow
		return baza.pracownicy;
	}

	public klient[] zwrocKlientow() {
		// TODO - implement dane.pobierzKlientow
		return baza.klienci;
	}

	public uslugodawca[] zwrocUslugodawcow() {
		return baza.uslugodawcy;
		// TODO - implement dane.pobierzUslugodawcow
	}

	public oferta[] zwrocOferty() {
		return baza.oferty;
		// TODO - implement dane.pobierzOferty
	}

	public problem[] zwrocProblemy() {
		return  baza.problemy;
		// TODO - implement dane.pobierzProblemy
	}

	public baza zwrocBaze() {
		return baza ;
		// TODO - implement dane.zwrocBaze
	}

	@Override
	public void ustawBaze(baza baza) {
		return;
	}

	public usluga[] zwrocUslugi() {
		return baza.uslugi;
		// TODO - implement dane.zwrocUslugi
	}

}
package dane;

import biznesowa.dostepDoDanych;

public class dane implements dostepDoDanych {

	private baza baza;

	public uzytkownik[] zwrocUzytkownikow() {
		return  baza.uzytkownicy;
	}

	public pracownik[] zwrocPracownikow() {
		return baza.pracownicy;
	}

	public klient[] zwrocKlientow() {
		return baza.klienci;
	}

	public uslugodawca[] zwrocUslugodawcow() {
		return baza.uslugodawcy;
	}

	public oferta[] zwrocOferty() {
		return baza.oferty;
	}

	public problem[] zwrocProblemy() {
		return  baza.problemy;
	}

	public baza zwrocBaze() {
		return baza ;
	}
	@Override
	public void ustawBaze(baza baza) {
		this.baza = baza;
	}

	public usluga[] zwrocUslugi() {
		return baza.uslugi;
	}

}
package dane;

public class baza {

	public pracownik[] pracownicy;
	public klient[] klienci;
	public uslugodawca[] uslugodawcy;
	public usluga[] uslugi;
	public uzytkownik[] uzytkownicy;
	public problem[] problemy;
	public oferta[] oferty;

	// Konstruktor inicjalizujący bazę
	public baza(pracownik[] pracownicy , klient[] klienci, uslugodawca[] uslugodawcy , usluga[] uslugi, uzytkownik[] uzytkownicy , problem[] problemy, oferta[] oferty ){
		this.pracownicy = pracownicy;
		this.klienci = klienci;
		this.uslugodawcy = uslugodawcy;
		this.uzytkownicy = uzytkownicy;
		this.problemy =problemy;
		this.oferty = oferty;
		this.uslugi = uslugi;


	}


}

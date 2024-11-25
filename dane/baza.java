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
	public baza() {
		// Tworzenie pracowników
		pracownicy = new pracownik[] {
				new pracownik("Anna", "Kowalska", "anna.kowalska", "haslo123", "aktywny"),
				new pracownik("Marek", "Nowak", "marek.nowak", "bezpiecznehaslo", "aktywny")
		};

		// Tworzenie klientów
		klienci = new klient[] {
				new klient("Jan", "Kowalski", "jan.kowalski", "haslo456", "aktywny", uslugi),
				new klient("Ewa", "Nowak", "ewa.nowak", "haslo789", "zablokowany", null)
		};

		// Tworzenie usługodawców
		uslugodawcy = new uslugodawca[] {
				new uslugodawca("Karol", "Wiśniewski", "karol.wisniewski", "haslo101", "aktywny", oferty, uslugi, new int[] {5, 4, 5})
		};

		// Tworzenie ofert
		oferty = new oferta[] {
				new oferta(100.0f, "Naprawa komputerów", uslugodawcy[0], "Szybka naprawa sprzętu komputerowego", new float[] {90.0f, 95.0f, 100.0f}),
				new oferta(300.0f, "Szkolenie IT", uslugodawcy[0], "Podstawy programowania w Java", new float[] {280.0f, 290.0f, 300.0f})
		};

		// Tworzenie usług
		uslugi = new usluga[] {
				new usluga(oferty[0], klienci[0]),
				new usluga(oferty[1], klienci[1])
		};

		// Przypisanie usług do klientów
		klienci[0].setUslugiBrane(new usluga[] {uslugi[0]});
		klienci[1].setUslugiBrane(new usluga[] {uslugi[1]});

		// Tworzenie problemów
		problemy = new problem[] {
				new problem("Brak dostępu do internetu", "internet", klienci[0]),
				new problem("Problem z logowaniem", "logowanie", klienci[1])
		};

		// Tworzenie zbiorczej listy użytkowników
		uzytkownicy = new uzytkownik[pracownicy.length + klienci.length + uslugodawcy.length];
		System.arraycopy(pracownicy, 0, uzytkownicy, 0, pracownicy.length);
		System.arraycopy(klienci, 0, uzytkownicy, pracownicy.length, klienci.length);
		System.arraycopy(uslugodawcy, 0, uzytkownicy, pracownicy.length + klienci.length, uslugodawcy.length);
	}


}

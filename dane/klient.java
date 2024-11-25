package dane;

public class klient extends uzytkownik {
	private usluga[] uslugiBrane;

	// Konstruktor
	public klient(String imie, String nazwisko, String login, String haslo, String status, usluga[] uslugiBrane) {
		super(imie, nazwisko, login, haslo, status);
		this.uslugiBrane = uslugiBrane;
	}

	// Getter i setter
	public usluga[] getUslugiBrane() {
		return uslugiBrane;
	}

	public void setUslugiBrane(usluga[] uslugiBrane) {
		this.uslugiBrane = uslugiBrane;
	}
}

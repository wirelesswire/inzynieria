package dane;

public class problem {

	private String opis;
	private String nazwa;
	private uzytkownik zglaszajacy;

	// Konstruktor z argumentami dla wszystkich pól
	public problem(String opis, String nazwa, uzytkownik zglaszajacy) {
		this.opis = opis;
		this.nazwa = nazwa;
		this.zglaszajacy = zglaszajacy;
	}

	// Getter i Setter dla pola opis
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	// Getter i Setter dla pola nazwa
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	// Getter i Setter dla pola zglaszajacy
	public uzytkownik getZglaszajacy() {
		return zglaszajacy;
	}

	public void setZglaszajacy(uzytkownik zglaszajacy) {
		this.zglaszajacy = zglaszajacy;
	}
}

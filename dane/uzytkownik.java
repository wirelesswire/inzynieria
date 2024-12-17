package dane;

public class uzytkownik {
	private String imie;
	private String nazwisko;
	private String login;
	private String haslo;
	private String status;

	// Konstruktor
	public uzytkownik(String imie, String nazwisko, String login, String haslo, String status) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.login = login;
		this.haslo = haslo;
		this.status = status;
	}

	@Override
	public String toString() {
		return "uzytkownik{" +
				"imie='" + imie + '\'' +
				", nazwisko='" + nazwisko + '\'' +
				", status='" + status + '\'' +
				'}';
	}

	// Gettery i settery
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getHaslo() {
		return haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

package dane;

public class uslugodawca extends uzytkownik {
	private usluga[] uslugiDawane;
	private oferta[] dostepneOferty;
	private int[] oceny;

	// Konstruktor
	public uslugodawca(String imie, String nazwisko, String login, String haslo, String status, oferta[] dostepneOferty, usluga[] uslugiDawane, int[] oceny) {
		super(imie, nazwisko, login, haslo, status);
		this.uslugiDawane = uslugiDawane;
		this.dostepneOferty = dostepneOferty;
		this.oceny = oceny;
	}

	// Gettery i settery
	public usluga[] getUslugiDawane() {
		return uslugiDawane;
	}

	public void setUslugiDawane(usluga[] uslugiDawane) {
		this.uslugiDawane = uslugiDawane;
	}

	public int[] getOceny() {
		return oceny;
	}

	public void setOceny(int[] oceny) {
		this.oceny = oceny;
	}

	public oferta[] getDostepneOferty() {
		return dostepneOferty;
	}

	public void setDostepneOferty(oferta[] dostepneOferty) {
		this.dostepneOferty = dostepneOferty;
	}
}

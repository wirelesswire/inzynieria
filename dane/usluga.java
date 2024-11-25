package dane;

public class usluga {
	private oferta usluga;
	private klient odbiorca;

	// Konstruktor
	public usluga(oferta usluga, klient odbiorca) {
		this.usluga = usluga;
		this.odbiorca = odbiorca;
	}

	// Gettery i settery
	public oferta getUsluga() {
		return usluga;
	}

	public void setUsluga(oferta usluga) {
		this.usluga = usluga;
	}

	public klient getOdbiorca() {
		return odbiorca;
	}

	public void setOdbiorca(klient odbiorca) {
		this.odbiorca = odbiorca;
	}
}

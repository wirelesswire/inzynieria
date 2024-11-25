package dane;

public class oferta {
	private float cena;
	private String nazwa;
	private uslugodawca dostawca;
	private String opis;
	private float[] historiaCen;

	// Konstruktor
	public oferta(float cena, String nazwa, uslugodawca dostawca, String opis, float[] historiaCen) {
		this.cena = cena;
		this.nazwa = nazwa;
		this.dostawca = dostawca;
		this.opis = opis;
		this.historiaCen = historiaCen;
	}

	// Gettery i settery
	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public uslugodawca getDostawca() {
		return dostawca;
	}

	public void setDostawca(uslugodawca dostawca) {
		this.dostawca = dostawca;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public float[] getHistoriaCen() {
		return historiaCen;
	}

	public void setHistoriaCen(float[] historiaCen) {
		this.historiaCen = historiaCen;
	}
}

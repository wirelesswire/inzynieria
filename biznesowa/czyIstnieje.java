package biznesowa;

public class czyIstnieje implements obslugaLogowania {

	private obslugaLogowania next;

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	public wiadomosc sprawdz(string login, string haslo) {
		// TODO - implement czyIstnieje.sprawdz
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param next
	 */
	public void setNext(obslugaLogowania next) {
		this.next = next;
	}

}
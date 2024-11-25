package biznesowa;

public class czyIstnieje implements obslugaLogowania {

	private obslugaLogowania next;

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	public wiadomosc sprawdz(String login, String haslo) {
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
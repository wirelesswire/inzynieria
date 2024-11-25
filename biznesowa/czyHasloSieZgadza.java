package biznesowa;

public class czyHasloSieZgadza implements obslugaLogowania {

	private obslugaLogowania next;

	/**
	 *
	 * @param login
	 * @param haslo
	 */
	public wiadomosc sprawdz(string login, string haslo) {
		// TODO - implement czyHasloSieZgadza.sprawdz
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
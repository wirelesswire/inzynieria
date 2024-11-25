package biznesowa;

public class czyJestAktywny implements obslugaLogowania {

	private obslugaLogowania next;

	/**
	 * 
	 * @param login
	 * @param haslo
	 * @param pozyskiwaczDanych
	 */
	public wiadomosc sprawdz(String login, String haslo, pozyskiwaczDanych pozyskiwaczDanych) {
		// TODO - implement czyJestAktywny.sprawdz
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
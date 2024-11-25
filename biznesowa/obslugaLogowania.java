package biznesowa;

public interface obslugaLogowania {

	/**
	 * 
	 * @param next
	 */
	void setNext(obslugaLogowania next);

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	wiadomosc sprawdz(String login, String haslo);

}
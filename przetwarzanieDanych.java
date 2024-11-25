import biznesowa.daneDlaUzytkownika;

public interface przetwarzanieDanych {

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	daneDlaUzytkownika zaloguj(String login, String haslo);

	/**
	 * 
	 * @param przycisk
	 * @param argumenty
	 */
	void kliknietyPrzycisk(String przycisk, String[] argumenty);

}
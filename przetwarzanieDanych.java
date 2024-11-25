public interface przetwarzanieDanych {

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	daneDlaUzytkownika zaloguj(string login, string haslo);

	/**
	 * 
	 * @param przycisk
	 * @param argumenty
	 */
	void kliknietyPrzycisk(string przycisk, string[] argumenty);

}
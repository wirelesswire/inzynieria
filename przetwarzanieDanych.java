public interface przetwarzanieDanych {

	/**
	 * 
	 * @param login
	 * @param haslo
	 */
	daneDlaUzytkownika zaloguj(string login, string haslo);

	void przekazDane();

	/**
	 * 
	 * @param przycisk
	 */
	void kliknietyPrzycisk(string przycisk);

}
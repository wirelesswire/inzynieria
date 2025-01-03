package biznesowa;

import widok.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import dane.*;

public class widok implements zmianaWidoku {

	private daneDlaUzytkownika dane;
	public biznesowa warstwaBiznesowa;
	Scanner scanner;

	public widok(){
		scanner = new Scanner(System.in);
	}

	public void pokazLogowanie() {

		System.out.println("podaj login i hasło ");
		System.out.println("login :  ");

		String login  = scanner.nextLine();

		System.out.println("hasło :  ");

		String haslo  = scanner.nextLine();

		zlecSprawdzenieDanych(login,haslo);
	}
	/**
	 *
	 * @param login
	 * @param haslo
	 */
	private void zlecSprawdzenieDanych(String login, String haslo) {
		warstwaBiznesowa.kliknietyPrzycisk("zaloguj",new String[]{login,haslo});
//
//		// TODO - implement widok.zlecSprawdzenieDanych
//		throw new UnsupportedOperationException();
	}
	/**
	 *
	 * @param dane
	 */
	private void wynikLogowania(daneDlaUzytkownika dane) {
		wyswietlWiadomosc(dane.wiadomosc);


//		// TODO - implement widok.wynikLogowania
//		throw new UnsupportedOperationException();
	}

	private void wyswietlPomocTechniczna(problem[] problemy) {
		if (problemy == null || problemy.length == 0) {
			System.out.println("Brak zgłoszonych problemów.");
			return;
		}

		System.out.println("--- Zgłoszenia do Pomocy Technicznej ---");
//
//		// Wariant 1: Proste wyświetlanie z toString()
//		System.out.println("\n--- Wariant 1: toString() ---");
//		Arrays.stream(problemy).forEach(System.out::println);


		// Wariant 2: Formatowany wypis
		System.out.println("\n--- Wariant 2: Formatowany wypis ---");
		for (int i = 0; i < problemy.length; i++) {
			problem problem = problemy[i];
			System.out.println("Zgłoszenie #" + (i + 1) + ":");
			System.out.println("  Nazwa: " + problem.getNazwa());
			System.out.println("  Opis: " + problem.getOpis());

			System.out.println("  Zgłaszający: " + problem.getZglaszajacy().toString());
			System.out.println("--------------------");
		}

//		// Wariant 3: Tabela (dla bardziej zaawansowanego formatowania można użyć bibliotek zewnętrznych)
//		System.out.println("\n--- Wariant 3: Tabela (uproszczona) ---");
//		System.out.println("Nazwa\t\tOpis\t\tZgłaszający");
//		System.out.println("--------------------------------------------------");
//		for (problem problem : problemy) {
//			System.out.println(problem.getNazwa() + "\t\t" + problem.getOpis().substring(0, Math.min(problem.getOpis().length(), 10)) + "...\t\t" + problem.getZglaszajacy()); // Skracanie opisu dla czytelności tabeli
//		}
	}

	/**
	 *
	 * @param uzytkownicy
	 */
	private void wyswietlBlokowanieKonta(uzytkownik[] uzytkownicy) {
		// TODO - implement widok.wyswietlBlokowanieKonta
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param klienci
	 */
	private void wyswietlPrzegladanieKlientow(klient[] klienci) {
		// TODO - implement widok.wyswietlPrzegladanieKlientow
		throw new UnsupportedOperationException();
	}

	private void wyswietlDodawanieOferty() {
		// TODO - implement widok.wyswietlDodawanieOferty
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param oferty
	 */
	private void wyswietlUsuwanieOferty(oferta[] oferty) {
		// TODO - implement widok.wyswietlUsuwanieOferty
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param uslugi
	 */
	private void wyswietlAnulowanieUslugi(usluga[] uslugi) {
		// TODO - implement widok.wyswietlAnulowanieUslugi
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param uslugi
	 */
	private void wyswietlZaplacenieZaUsluge(usluga[] uslugi) {
		// TODO - implement widok.wyswietlZaplacenieZaUsluge
		throw new UnsupportedOperationException();
	}

	/**
	 *
	 * @param uslugi
	 */
	private void wyswietlPrzegladanieHistoriiUslug(usluga[] uslugi) {
		// TODO - implement widok.wyswietlPrzegladanieHistoriiUslug
		throw new UnsupportedOperationException();
	}

	private void wyswietlOcenaUslugodawcy() {
		// TODO - implement widok.wyswietlOcenaUslugodawcy
		throw new UnsupportedOperationException();
	}

	public boolean poprosOPotwierdzenie() {
		System.out.println("Potwierdz wybraną operację  [tak/NIE]");
		String line = scanner.nextLine();
		if(Objects.equals(line, "tak")){
			System.out.println("potwierdzono");
			return  true ;
		}
		return false  ;
	}
	/**
	 *
	 * @param dane
	 */
	public void wyswietlWidokKlienta(daneDlaKlienta dane) {
		System.out.println("widok klienta ");



	}

	/**
	 *
	 * @param dane
	 */
	public void wyswietlWidokPracownika(daneDlaPracownika dane) {
		System.out.println("widok pracownika");

		System.out.println("wybierz opcje 1.udzielanie pomocy  technicznej  2.zablokuj konto ");

		String przycisk = "";
		String[] argumenty = new String[]{};
		int index = wyborIndexu(1,2); // opcje 1 i 2
		if(index == -1 ){
			przycisk = "wyloguj";
			warstwaBiznesowa.kliknietyPrzycisk(przycisk, argumenty);
			return;
		}
		if(index == 1 ){
			przycisk="pomoc";
			wyswietlPomocTechniczna(dane.problemy);

			System.out.println("wybierz problem do rozwiązania ");
			int indexProblemu = wyborIndexu(1,dane.problemy.length)-1;//indexy problemów
			argumenty = new String[]{""+indexProblemu};
		}
		else if (index == 2) {
			przycisk = "blokada";
			wyswietlBlokowanieKonta(dane.uzytkownicy);

			System.out.println("Wybierz konto do zablokowania:");
			int indexKonta = wyborIndexu(1,dane.uzytkownicy.length)-1;//indexy kont

			if (!poprosOPotwierdzenie()) {
				return;
			}

			argumenty = new String[]{""+indexKonta};
		}
		warstwaBiznesowa.kliknietyPrzycisk(przycisk, argumenty);
	}


	/**
	 * 
	 * @param dane
	 */
	public void wyswietlWidokUslugodawcy(daneDlaUslugodawcy dane) {

		if(!(dane instanceof daneDlaUzytkownika)){
			System.out.println("BŁĄAD BOŻY");

			return ;
		}
		System.out.println("widok usługodawcy ");

		System.out.println("wyswietlam listę klientów ");

		System.out.println("wybierz opcje 1.dodaj ofertę  2.usun ofertę  ");

		String przycisk = "";
		String[] argumenty = new String[]{};
		int index = wyborIndexu(1,2); // opcje 1 i 2
		if(index == -1 ){
			przycisk = "wyloguj";
			warstwaBiznesowa.kliknietyPrzycisk(przycisk, argumenty);
			return;
		}
		if(index == 1 ){
			przycisk="dodanieoferty";
			System.out.println("wprowadz dane oferty  ");
			argumenty = wprowadzStringi(3,new String[]{"cena","nazwa","opis"});

		}
		else if (index ==2 ){
			przycisk = "usunecieoferty";
			System.out.println("wybierz index oferty do usunięcia ");
			int indexoferty  = wyborIndexu(0,3);//indexy kont
			argumenty = new String[]{""+indexoferty};
		}

		warstwaBiznesowa.kliknietyPrzycisk(przycisk, argumenty);


	}

	@Override
	public void wyswietlWiadomosc(wiadomosc wiadomosc) {
	if(wiadomosc.kolor == null){
		System.out.println( wiadomosc.tresc);
		return;
	}
		System.out.println(wiadomosc.kolor + wiadomosc.tresc);
	}


	public int  wyborIndexu(int min , int max ){ // -1 to wyloguj

		while(true){
			System.out.println("wybierz index od "+min+ " do " + max +" lub " +(max+1) +" aby się wylogowac" );

			int  input =Integer.parseInt( scanner.nextLine());
			if(input == max+1){
				return -1;
			}

			if(input >=min && input <= max ){
				return  input ;
			}
			else {
				System.out.println("wybrano niepoprawny index ");
			}
		}
	}
	public String[] wprowadzStringi(int ile,String[] nazwy  ){

		if(nazwy.length != ile){
			System.out.println("NIE DZIAŁA POPRAWNIE,ZŁE DANE ");
		}
		String[] ret = new String[ile];

		for (int i = 0; i <ile ; i++) {
			System.out.println("podaj"+nazwy[i]);
			ret[i] = scanner.nextLine();
		}

		return  ret;
	}




}
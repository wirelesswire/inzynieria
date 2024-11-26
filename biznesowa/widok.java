package biznesowa;

import widok.*;

import java.util.Objects;
import java.util.Scanner;

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

	private void wyswietlPomocTechniczna() {
		// TODO - implement widok.wyswietlPomocTechniczna
		throw new UnsupportedOperationException();
	}

	private void wyswietlBlokowanieKonta() {
		// TODO - implement widok.wyswietlBlokowanieKonta
		throw new UnsupportedOperationException();
	}

	private void wyswietlPrzegladanieKlientow() {
		// TODO - implement widok.wyswietlPrzegladanieKlientow
		throw new UnsupportedOperationException();
	}

	private void wyswietlDodawanieOferty() {
		// TODO - implement widok.wyswietlDodawanieOferty
		throw new UnsupportedOperationException();
	}

	private void wyswietlUsuwanieOferty() {
		// TODO - implement widok.wyswietlUsuwanieOferty
		throw new UnsupportedOperationException();
	}

	private void wyswietlAnulowanieUslugi() {
		// TODO - implement widok.wyswietlAnulowanieUslugi
		throw new UnsupportedOperationException();
	}

	private void wyswietlZaplacenieZaUsluge() {
		// TODO - implement widok.wyswietlZaplacenieZaUsluge
		throw new UnsupportedOperationException();
	}

	private void wyswietlPrzegladanieHistoriiUslug() {
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
	public void wyswietlWidokKlienta() {
		System.out.println("widok klienta ");



	}

	public void wyswietlWidokPracownika() {
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
			System.out.println("wybierz problem do rozwiązania ");
			int indexProblemu = wyborIndexu(0,3);//indexy problemów
			argumenty = new String[]{""+indexProblemu};
		}
		else if (index ==2 ){
			przycisk = "blokada";
			System.out.println("wybierz konto  do zablokowania ");
			int indexkonta  = wyborIndexu(0,3);//indexy kont
			argumenty = new String[]{""+indexkonta};
			if(!poprosOPotwierdzenie()){
				return;
			}
		}

		warstwaBiznesowa.kliknietyPrzycisk(przycisk, argumenty);


	}


	public void wyswietlWidokUslugodawcy() {
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
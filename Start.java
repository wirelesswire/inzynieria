import dane.*;
//import widok.*;
import biznesowa.*;


public  class Start {


    public static void main (String[] args ){

        widok widok = new widok();

        edytorBazy edytorBazy = new edytorBazy();
        biznesowa biznesowa = new biznesowa(edytorBazy,widok) ;

        widok.warstwaBiznesowa = biznesowa;

        dane dane= new dane();
        baza b = createBaza();
        dane.ustawBaze(b);
        biznesowa.dane = dane;
        biznesowa.edytorbazy.dane=dane;
        widok.pokazLogowanie();







    }

    public static baza  createBaza(){

        // Tworzenie pracowników
        pracownik[] pracownicy = new pracownik[] {
                new pracownik("Anna", "Kowalska", "anna.kowalska", "haslo123", "aktywny"),
                new pracownik("Marek", "Nowak", "marek.nowak", "bezpiecznehaslo", "aktywny")
        };

        // Tworzenie klientów
        klient[] klienci = new klient[] {
                new klient("Jan", "Kowalski", "jan.kowalski", "haslo456", "aktywny", null),
                new klient("Ewa", "Nowak", "ewa.nowak", "haslo789", "zablokowany", null)
        };

        // Tworzenie usługodawców
        uslugodawca[] uslugodawcy = new uslugodawca[] {
                new uslugodawca("Karol", "Wiśniewski", "karol.wisniewski", "haslo101", "aktywny", null, null, new int[] {5, 4, 5})
        };

        // Tworzenie ofert
        oferta[] oferty = new oferta[] {
                new oferta(100.0f, "Naprawa komputerów", uslugodawcy[0], "Szybka naprawa sprzętu komputerowego", new float[] {90.0f, 95.0f, 100.0f}),
                new oferta(300.0f, "Szkolenie IT", uslugodawcy[0], "Podstawy programowania w Java", new float[] {280.0f, 290.0f, 300.0f})
        };

        // Tworzenie usług
        usluga[] uslugi = new usluga[] {
                new usluga(oferty[0], klienci[0]),
                new usluga(oferty[1], klienci[1])
        };

        // Przypisanie usług do klientów
        klienci[0].setUslugiBrane(new usluga[] {uslugi[0]});
        klienci[1].setUslugiBrane(new usluga[] {uslugi[1]});

        // Tworzenie problemów
        problem[] problemy = new problem[] {
                new problem("Brak dostępu do internetu", "internet", klienci[0]),
                new problem("Problem z logowaniem", "logowanie", klienci[1])
        };

        // Tworzenie zbiorczej listy użytkowników
        uzytkownik[] uzytkownicy = new uzytkownik[pracownicy.length + klienci.length + uslugodawcy.length];
        System.arraycopy(pracownicy, 0, uzytkownicy, 0, pracownicy.length);
        System.arraycopy(klienci, 0, uzytkownicy, pracownicy.length, klienci.length);
        System.arraycopy(uslugodawcy, 0, uzytkownicy, pracownicy.length + klienci.length, uslugodawcy.length);


        baza baza = new baza(pracownicy,klienci,uslugodawcy,uslugi,uzytkownicy, problemy,oferty);
        return  baza ;


    }




}

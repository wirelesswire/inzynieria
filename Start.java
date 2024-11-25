import dane.*;
//import widok.*;
import biznesowa.*;


public  class Start {


    public static void main (String[] args ){

        widok widok = new widok();

//        widok.pokazLogowanie();
        wiadomosc w = new wiadomosc();
        w.kolor = "\033[0;31m";
        w.tresc = "tresc ";
        widok.wyswietlWiadomosc(w);


        biznesowa biznesowa = new biznesowa() ;
        biznesowa.widok = widok;
        widok.warstwaBiznesowa = biznesowa;


        dane dane = new dane();


    }
}

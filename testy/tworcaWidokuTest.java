package testy;//package biznesowa;

import biznesowa.*;
import dane.dane;
import dane.pracownik;
import dane.uzytkownik;
import dane.klient;
import dane.uslugodawca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class tworcaWidokuTest implements TestExecutionExceptionHandler{

//    pozyskiwaczDanych pozyskiwacz ;

    private static dane daneTestowe;

    @BeforeEach
    void setup(){
        biznesowaTestDane.setup();
        daneTestowe = biznesowaTestDane.dane;
    }

    @ExtendWith(tworcaWidokuTest.class)
    @Test
    @Order(1)
    void uslugodawcaWidok(){
        uzytkownik a = new uslugodawca("jan","kowal","j.k","haslo","aktywny",null,null,null);
        pozyskiwaczDanych pozyskiwacz = new pozyskiwaczDanych(a);
        Strategia p = new uslugodawcaStrategy();
        pozyskiwacz.dane = daneTestowe;
        pozyskiwacz.setStrategia(p);
        pozyskiwacz.pozyskajDane();
        tworcaWidoku tworca = new tworcaWidoku();
        daneDlaUzytkownika d = tworca.stworzWidok(pozyskiwacz.pozyskaneDane,a);
        assertEquals(daneDlaUslugodawcy.class, d.getClass());
    }
    @ExtendWith(tworcaWidokuTest.class)
    @Test
    @Order(2)
    void pracownikWidok(){
        uzytkownik a = new pracownik("jan","kowal","j.k","haslo","aktywny");
        pozyskiwaczDanych pozyskiwacz = new pozyskiwaczDanych(a);
        Strategia p = new pracownikStrategy();
        pozyskiwacz.dane = daneTestowe;
        pozyskiwacz.setStrategia(p);
        pozyskiwacz.pozyskajDane();
        tworcaWidoku tworca = new tworcaWidoku();
        daneDlaUzytkownika d = tworca.stworzWidok(pozyskiwacz.pozyskaneDane,a);
        assertEquals(daneDlaPracownika.class, d.getClass());
    }
    @ExtendWith(tworcaWidokuTest.class)
    @Test
    @Order(3)
    void klientWidok(){
        uzytkownik a = new klient("jan","kowal","j.k","haslo","aktywny",null);
        pozyskiwaczDanych pozyskiwacz = new pozyskiwaczDanych(a);
        Strategia p = new klientStrategy();
        pozyskiwacz.dane = daneTestowe;
        pozyskiwacz.setStrategia(p);
        pozyskiwacz.pozyskajDane();
        tworcaWidoku tworca = new tworcaWidoku();
        daneDlaUzytkownika d = tworca.stworzWidok(pozyskiwacz.pozyskaneDane,a);
        assertEquals(daneDlaKlienta.class, d.getClass());
    }

    @Override //wyjątku IllegalFormatCodePointException przez metodę wykonajProdukt
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof NullPointerException) {
            System.out.println("handled");
        }
        else throw throwable;
    }


}
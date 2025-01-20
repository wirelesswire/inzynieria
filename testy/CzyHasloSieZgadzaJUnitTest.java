package testy;

import biznesowa.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import dane.*;
//import mockit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;


@TestMethodOrder(OrderAnnotation.class)
public class CzyHasloSieZgadzaJUnitTest implements TestExecutionExceptionHandler  {

    private czyHasloSieZgadza czyHasloSieZgadza;
    private czyJestAktywny czyJestAktywny;
    private static dane daneTestowe;

    @BeforeAll
    static void przygotujDaneTestowe() {
        biznesowaTestDane.setup();
        daneTestowe = biznesowaTestDane.dane;
    }

    @BeforeEach
    void setUp() {
        czyHasloSieZgadza = new czyHasloSieZgadza();
        czyJestAktywny = new czyJestAktywny();
        czyHasloSieZgadza.setNext(czyJestAktywny);
        daneTestowe = biznesowaTestDane.dane;
    }


    @Test
    @Order(1)
    @ExtendWith(CzyHasloSieZgadzaJUnitTest.class)
    @Tag("haslo")
    void sprawdzPoprawneHaslo() {
        pozyskiwaczDanych pozyskiwaczDanych = new pozyskiwaczDanych(null);
        pozyskiwaczDanych.setStrategia(new logowanieStrategy(daneTestowe));
        pozyskiwaczDanych.pozyskajDane();
        uzytkownik a =  new pracownik("Anna", "Kowalska", "anna.kowalska", "haslo123", "aktywny"); // dobre haslo
        uzytkownik b =  new pracownik("Marek", "Nowak", "marek.nowak", "bezpiecznehaslo", "zablokowany");
        uzytkownik c =  new pracownik("Marek", "Nowak", "marko.nowak", "bezpiecznehaso", null); // zle haslo

        assertNull(czyHasloSieZgadza.sprawdz(a.getLogin(),a.getHaslo(),pozyskiwaczDanych).tresc);
        assertNull(czyHasloSieZgadza.sprawdz(b.getLogin(),b.getHaslo(),pozyskiwaczDanych).tresc);
        assertEquals("bledne haslo",czyHasloSieZgadza.sprawdz(c.getLogin(),c.getHaslo(),pozyskiwaczDanych).tresc );



    }

    //k1.2 – definicja zachowania metody testowej testWykonajProdukt podczas testowania generowania
    @Override //wyjątku IllegalFormatCodePointException przez metodę wykonajProdukt
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof Exception) {
            System.out.println("handled");
        }
        else throw throwable;
    }
    @Test
    @Order(3)
    @Tag("haslo")
    @ExtendWith(CzyHasloSieZgadzaJUnitTest.class)
    void sprawdzBrakUzytkownika() {
        pozyskiwaczDanych pozyskiwaczDanych = new pozyskiwaczDanych(null);
        pozyskiwaczDanych.setStrategia(new logowanieStrategy(daneTestowe));
        pozyskiwaczDanych.pozyskajDane();
        wiadomosc wiadomosc = czyHasloSieZgadza.sprawdz("nieistniejacyLogin", "haslo", pozyskiwaczDanych);
//        assertNull(wiadomosc.tresc);
        assertEquals(wiadomosc.tresc,"taki uzytkownik nie istnieje");
    }


}
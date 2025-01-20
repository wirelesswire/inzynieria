

package testy;


import biznesowa.*;
import dane.*;
//import mockit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
public class CzyJestAktywnyJUnitTest implements TestExecutionExceptionHandler {

    private czyJestAktywny czyJestAktywny;
    private static dane daneTestowe;

    @BeforeAll
    static void przygotujDaneTestowe() {
        biznesowaTestDane.setup();
        daneTestowe = biznesowaTestDane.dane;
    }

    @BeforeEach
    void setUp() {
        czyJestAktywny = new czyJestAktywny();
        daneTestowe = biznesowaTestDane.dane;
    }
    private static Stream<uzytkownik> uzytkownicyProvider() {

        return Stream.of(daneTestowe.zwrocUzytkownikow());

    }

    @ParameterizedTest
    @MethodSource("uzytkownicyProvider")
    @ExtendWith(CzyJestAktywnyJUnitTest.class)
    @Order(1)
    @Tag("aktywnosc")
    void sprawdzStatusUzytkownika(final uzytkownik uzytkownik) {

        pozyskiwaczDanych pozyskiwaczDanych = new pozyskiwaczDanych(null);
        pozyskiwaczDanych.setStrategia(new logowanieStrategy(daneTestowe));
        pozyskiwaczDanych.pozyskajDane();
        wiadomosc wiadomosc = new wiadomosc(null);
            wiadomosc = czyJestAktywny.sprawdz(uzytkownik.getLogin(), uzytkownik.getHaslo(), pozyskiwaczDanych);
            if ("aktywny".equals(uzytkownik.getStatus())) {
                assertNull(wiadomosc.tresc);
            } else if ("nieaktywny".equals(uzytkownik.getStatus())) {
                assertEquals("uzytkownik nieaktywny", wiadomosc.tresc);
            } else if ("zablokowany".equals(uzytkownik.getStatus())) {
                assertEquals("uzytkownik zablokowany", wiadomosc.tresc);
            }
            else {
                assertEquals("wystapil blad ", wiadomosc.tresc);
            }
    }
    //k1.2 – definicja zachowania metody testowej testWykonajProdukt podczas testowania generowania
    @Override //wyjątku IllegalFormatCodePointException przez metodę wykonajProdukt
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof NullPointerException) {
            System.out.println("handled");
        }
        else throw throwable;
    }
    @Test
    @Order(2)
    @Tag("aktywnosc")

    @ExtendWith(CzyJestAktywnyJUnitTest.class)
    void sprawdzBrakUzytkownika() {
        pozyskiwaczDanych pozyskiwaczDanych = new pozyskiwaczDanych(null);
        pozyskiwaczDanych.setStrategia(new logowanieStrategy(daneTestowe));
        pozyskiwaczDanych.pozyskajDane();
        wiadomosc wiadomosc = czyJestAktywny.sprawdz("nieistniejacyLogin", "haslo", pozyskiwaczDanych);
        assertNull(wiadomosc.tresc);
    }

    @Test
    @Order(3)
    @Tag("aktywnosc")

    @ExtendWith(CzyJestAktywnyJUnitTest.class)
    void testTextOk() {
        pozyskiwaczDanych pozyskiwaczDanych = new pozyskiwaczDanych(null);
        pozyskiwaczDanych.setStrategia(new logowanieStrategy(daneTestowe));
        pozyskiwaczDanych.pozyskajDane();
        wiadomosc w = czyJestAktywny.sprawdz("test", "test", pozyskiwaczDanych);// nie istnieje
        assertNull(w.tresc);
        w = czyJestAktywny.sprawdz("anna.kowalska", "haslo123", pozyskiwaczDanych);//aktywny
        assertNull(w.tresc);
        w = czyJestAktywny.sprawdz("ewa.nowak", "haslo789", pozyskiwaczDanych); // zablokowany
        assertNotNull(w.tresc);
    }

    @Test
    @Order(4)
    @Tag("aktywnosc")

    @ExtendWith(CzyJestAktywnyJUnitTest.class)
    void testSetsNextCorrectly(){
        pozyskiwaczDanych pozyskiwaczDanych = new pozyskiwaczDanych(null);
        pozyskiwaczDanych.setStrategia(new logowanieStrategy(daneTestowe));
        pozyskiwaczDanych.pozyskajDane();
        czyIstnieje c = new czyIstnieje();

        Assertions.assertEquals(null , czyJestAktywny.next);
        czyJestAktywny.setNext(c);
        Assertions.assertEquals(c,czyJestAktywny.next);


    }


}
















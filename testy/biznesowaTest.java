package testy;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import biznesowa.*;
//import mockit.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class biznesowaTest implements TestExecutionExceptionHandler {
    biznesowa biznesowa;


    @BeforeEach
    void setup(){
        System.out.println("aaa");
        biznesowaTestDane.setup();
        biznesowa = biznesowaTestDane.b;
        if(biznesowa == null ){
            System.out.println("jaest null ");
        }
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
    @Order(1)
    @Tag("logowanie")
    @ExtendWith(biznesowaTest.class)

    void zaloguj() {

        assertTrue(biznesowa.zaloguj("anna.kowalska","haslo123"));
        assertFalse(biznesowa.zaloguj("zle","haslo123"));
    }


    @Test
    @Order(2)
    @ExtendWith(biznesowaTest.class)
    @Tag("pozyskiwanie")

    void pozyskajDaneBezUzytkownika() {
        pozyskiwaczDanych p = biznesowa.getPozyskiwacz();
        assertNull(p.pozyskaneDane);
        Strategia s = new klientStrategy();
        p.setStrategia(s);
        biznesowa.pozyskajDane();
        assertNull(biznesowa.getPozyskiwacz().pozyskaneDane);
    }
    @Test
    @Order(3)
    @ExtendWith(biznesowaTest.class)
    @Tag("pozyskiwanie")
    void pozyskajDaneZUzytkownikiem() {
        pozyskiwaczDanych p = biznesowa.getPozyskiwacz();
        assertNull(p.pozyskaneDane);
        biznesowa.zaloguj("anna.kowalska","haslo123");
        biznesowa.pozyskajDane();
        assertNotNull(biznesowa.getPozyskiwacz().pozyskaneDane);
    }

    @Test
    @Order(4)
    @ExtendWith(biznesowaTest.class)
    @Tag("logowanie")
    void wylogujTest(){
        pozyskiwaczDanych p = biznesowa.getPozyskiwacz();
        assertNull(biznesowa.getUzytkownik());
        biznesowa.zaloguj("anna.kowalska","haslo123");
        assertNotNull(biznesowa.getUzytkownik());
        biznesowa.wyloguj();
        assertNull(biznesowa.getUzytkownik());
    }



}
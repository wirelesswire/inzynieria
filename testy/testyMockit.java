package testy;
import  biznesowa.*;
import dane.klient;
import dane.pracownik;
import dane.uzytkownik;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Verifications;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class testyMockit {



        @Mocked
        biznesowa biznesowa;

        @Mocked
        pozyskiwaczDanych pozyskiwaczDanych;
        @Mocked
        edytorBazy edytorBazy;

        @BeforeEach
        void setup() {
            biznesowaTestDane.setup();
            biznesowa = biznesowaTestDane.b;
            if (biznesowa == null) {
                System.out.println("jest null");
            }
        }

        @Test
        @Order(1)
        @Tag("logowanie")
        void zaloguj() {
            //  zapisu
            new Expectations() {{
                biznesowa.zaloguj("anna.kowalska", "haslo123"); result = true;
                biznesowa.zaloguj("zle", "haslo123"); result = false;
            }};

            //  odtwarzania
            boolean wynikPoprawny = biznesowa.zaloguj("anna.kowalska", "haslo123");
            boolean wynikNiepoprawny = biznesowa.zaloguj("zle", "haslo123");

            //  sprawdzenia
            new Verifications() {{
                biznesowa.zaloguj("anna.kowalska", "haslo123"); times = 1;
                biznesowa.zaloguj("zle", "haslo123"); times = 1;
            }};

            assertTrue(wynikPoprawny);
            assertFalse(wynikNiepoprawny);
        }

        @Test
        @Order(2)
        @Tag("pozyskiwanie")
        void pozyskajDaneBezUzytkownika() {
            //  zapisu
            new Expectations() {{
                biznesowa.getPozyskiwacz(); result = pozyskiwaczDanych;
                pozyskiwaczDanych.pozyskaneDane = null;
            }};
            // Faza odtwarzania
            pozyskiwaczDanych p = biznesowa.getPozyskiwacz();
            Strategia strategia = new klientStrategy();
            p.setStrategia(strategia);
            biznesowa.pozyskajDane();
            // Faza sprawdzenia
            new Verifications() {{
                biznesowa.getPozyskiwacz(); times = 1;
                p.setStrategia(strategia); times = 1;
                biznesowa.pozyskajDane(); times = 1;
            }};
            assertNull(p.pozyskaneDane);
        }

        @Test
        @Order(3)
        @Tag("pozyskiwanie")
        void pozyskajDaneZUzytkownikiem() {
            // Faza zapisu
            new Expectations() {{
                biznesowa.zaloguj("anna.kowalska", "haslo123"); result = true;
                biznesowa.pozyskajDane();result =  new pozyskaneDane();

            }};
            // Faza odtwarzania
            biznesowa.zaloguj("anna.kowalska", "haslo123");
            pozyskaneDane p = biznesowa.pozyskajDane();
            // Faza sprawdzenia
            new Verifications() {{
                biznesowa.zaloguj("anna.kowalska", "haslo123"); times = 1;
                biznesowa.pozyskajDane(); times = 1;
            }};
            assertNotNull(p);
        }

        @Test
        @Order(4)
        @Tag("logowanie")
        void wylogujTest() {
            // Faza zapisu
            new Expectations() {{
                biznesowa.zaloguj("anna.kowalska", "haslo123"); result = true;
                biznesowa.getUzytkownik(); result = new pracownik("Anna", "Kowalska", "anna.kowalska", "haslo123", "aktywny");
//                biznesowa.wyloguj();
            }};

            // Faza odtwarzania
            biznesowa.zaloguj("anna.kowalska", "haslo123");
            uzytkownik uzytkownikPrzedWylogowaniem = biznesowa.getUzytkownik();

            // Faza sprawdzenia
            new Verifications() {{
                biznesowa.zaloguj("anna.kowalska", "haslo123"); times = 1;
            }};


            new Expectations() {{
                biznesowa.getUzytkownik(); result = null;
            }};

            biznesowa.wyloguj();
            uzytkownik uzytkownikPoWylogowaniu = biznesowa.getUzytkownik();

            // Faza sprawdzenia
            new Verifications() {{
                biznesowa.wyloguj(); times = 1;
            }};

            assertNotNull(uzytkownikPrzedWylogowaniem);
            assertNull(uzytkownikPoWylogowaniu);
        }
    }



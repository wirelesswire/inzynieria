package biznesowa;

import dane.*;

import java.util.Arrays;

public class edytorBazy {

	public dane dane;

	public void pomozTechnicznie(int index ) {
		baza b = dane.zwrocBaze();
		problem[] arr_new = new problem[b.problemy.length-1];

		for(int i=0, k=0;i<b.problemy.length;i++){
			if(i!=index){
				arr_new[k]=b.problemy[i];
				k++;
			}
		}
		b.problemy=arr_new;

//		b.problemy = p ;
//		dane.ustawBaze(b);
//		// TODO - implement edytorBazy.pomozTechnicznie
//		throw new UnsupportedOperationException();
	}

	public void zablokujKonto(int index)
	{
		uzytkownik[] uzytkownicy = dane.zwrocUzytkownikow();
		uzytkownicy[index].setStatus("zablokowany");

		baza b = dane.zwrocBaze();
		b.uzytkownicy = uzytkownicy;
		dane.ustawBaze(b);

	}

	public void dodajOferte() {
		// TODO - implement edytorBazy.dodajOferte
		throw new UnsupportedOperationException();
	}

	public void usunOferte() {
		// TODO - implement edytorBazy.usunOferte
		throw new UnsupportedOperationException();
	}

	public void anulujUsluge() {
		// TODO - implement edytorBazy.anulujUsluge
		throw new UnsupportedOperationException();
	}

	public void zaplacZaUsluge() {
		// TODO - implement edytorBazy.zaplacZaUsluge
		throw new UnsupportedOperationException();
	}

	public void ocenUslugodawce() {
		// TODO - implement edytorBazy.ocenUslugodawce
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void pomozTechnicznie(String[] argumenty) {
		// TODO - implement edytorBazy.pomozTechnicznie
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void zablokujKonto(String[] argumenty) {
		// TODO - implement edytorBazy.zablokujKonto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void dodajOferte(String[] argumenty) {
		// TODO - implement edytorBazy.dodajOferte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void usunOferte(String[] argumenty) {
		// TODO - implement edytorBazy.usunOferte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void anulujUsluge(String[] argumenty) {
		// TODO - implement edytorBazy.anulujUsluge
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void zaplacZaUsluge(String[] argumenty) {
		// TODO - implement edytorBazy.zaplacZaUsluge
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param argumenty
	 */
	public void ocenUslugodawce(String[] argumenty) {
		// TODO - implement edytorBazy.ocenUslugodawce
		throw new UnsupportedOperationException();
	}

}
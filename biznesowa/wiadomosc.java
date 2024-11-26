package biznesowa;

public class wiadomosc {
	public String tresc;
	public String kolor;
	public wiadomosc(String tresc,String kolor ){
		this.tresc = tresc;
		this.kolor=kolor;
	}
	public wiadomosc( ){
	}
	public wiadomosc(String tresc ){
		this.tresc = tresc;
	}
}
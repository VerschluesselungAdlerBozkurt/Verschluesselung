package adlerbozkurt.test;
import static org.junit.Assert.*;
import org.junit.Test;
import adlerbozkurt.cipher.*;

/**
 * �berpr�fung der Klasse KeywordCipher mittels JUnit-Test
 * @author H�seyin Bozkurt
 * @version 2014-04-04
 */


public class TestKeyWordCipher {


	/**
	 * Diese Methode �berpr�ft den Konstruktor, hier wird eine Fehlermeldung erwartet den das �bergebene Level ist kleiner als 1
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test
	public void KeywordCipher1() throws BadParamException{
		try{
			KeywordCipher m = new KeywordCipher("bozkurt");
		}catch(BadParamException f){
			throw new BadParamException("TranspositionCipher-KonstruktorFail erwartet den das �bergebene Level ist kleiner 1");
		}
	}



	/**
	 * Diese Methode �berpr�ft den Konstruktor, hier wird eine Fehlermeldung erwartet den das �bergebene Level ist keine Zahl
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void KeywordCipher2() throws BadParamException{
		try{
			String s = null;
			KeywordCipher m = new KeywordCipher(s);
		}catch(NumberFormatException f){
			throw new BadParamException();
		}
	}



	/**
	 * Diese Methode �berpr�ft den Konstruktor
	 * dabei sollte alles klappen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test
	public void TranspositionCipher3() throws BadParamException{
		try{
			KeywordCipher m = new KeywordCipher("bozkurt");
		}catch(BadParamException f){
			fail("Transposition-Konstruktor fail");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setKeyword, dabei wird eine Zahl als String �bergeben
	 * ==> sollte Exception werden
	 * @throws BadParamException falsche eingabe des Users
	 */
	@Test(expected=BadParamException.class)
	public void setKeyword1() throws BadParamException{
		try{
			KeywordCipher m = new KeywordCipher("Bozkurt");
			m.setKeyword("");
		}catch(BadParamException f){
			throw new BadParamException("KeywordCipher-das setzen des Schl�sselwortes entspricht nicht den Bedingungen");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setKeyword, wobei der Param den Wert null hat
	 * ==> sollte Exception werfen
	 * @throws BadParamException falsche Eingabe des Users
	 */
	@Test(expected=BadParamException.class)
	public void setKeyword2() throws BadParamException{
		try{
			KeywordCipher m = new KeywordCipher("bozkurt");
			m.setKeyword(null);
		}catch(NumberFormatException f){
			throw new BadParamException();
		}
	}

	/**
	 * Diese Methode �berpr�ft eine Variante von encrypt, dabei wird ein Parameter �bergeben
	 * der den Wert null hat
	 * ==> sollte BadParamException werfen
	 * @throws BadParamException falsche Eingabe des Users
	 */
	@Test(expected=BadParamException.class)
	public void encrypt1() throws BadParamException{
		KeywordCipher m = new KeywordCipher("BOZKURT");
		try{
			m.encrypt(null);
		}catch(NullPointerException f){
			throw new BadParamException("Keyword-encrypt fail da der �bergebene Parameter null ist");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von encrypt, dabei wird ein richtiger Parameter �bergeben
	 * der die Kriterien erf�llt
	 */
	@Test
	public void encrypt2(){
		try {
			KeywordCipher m = new KeywordCipher("hallo");
			if(!(m.encrypt("BOZKURT").equals("OTBRZ Z U "))){
				fail("Keword-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("Keyword-encrypt fail");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von decrypt, wobei der Para den Wert null hat
	 * ==> sollte eine BadParamException werfen
	 * @throws BadParamException Falsche Eingabe des Users
	 */
	@Test
	public void decrypt1() throws BadParamException{
		KeywordCipher m = new KeywordCipher("BOZKURT");
		try{
			m.decrypt("Hallo");
		}catch(NullPointerException f){
			throw new BadParamException("Keyword-decrypt fail da der �bergebene Parameter null ist");
		}
	}
}
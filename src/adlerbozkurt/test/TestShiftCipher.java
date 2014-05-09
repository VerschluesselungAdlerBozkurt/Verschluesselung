package adlerbozkurt.test;

import static org.junit.Assert.fail;

import org.junit.Test;

import adlerbozkurt.cipher.BadParamException;
import adlerbozkurt.cipher.KeywordCipher;
import adlerbozkurt.cipher.ShiftCipher;

/**
 * �berpr�fung der Klasse ShiftCipher mittels JUnit-Test
 * @author H�seyin Bozkurt
 * @version 2014-04-04
 */


public class TestShiftCipher {


	/**
	 * Diese Methode �berpr�ft den Konstruktor, hier wird eine Fehlermeldung erwartet den das �bergebene Level ist kleiner als 1
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void ShiftCipher1() throws BadParamException{
		try{
			ShiftCipher m = new ShiftCipher(0);
		}catch(BadParamException f){
			throw new BadParamException("ShiftCipher-Konstruktor Fail erwartet den das �bergebene Level ist kleiner 1");
		}
	}



	/**
	 * Diese Methode �berpr�ft den Konstruktor, hier wird eine Fehlermeldung erwartet den das �bergebene Level ist keine Zahl
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void ShiftCipher2() throws BadParamException{
		try{
			ShiftCipher m = new ShiftCipher(Integer.parseInt(null));
		}catch(NumberFormatException f){
			throw new BadParamException();
		}
	}



	/**
	 * Diese Methode �berpr�ft den Konstruktor
	 * dabei sollte alles klappen
	 * @throws BadParamException falsche Eingabe des Users
	 */
	@Test
	public void ShiftCipher3() throws BadParamException{
		try{
			ShiftCipher m = new ShiftCipher(1);
		}catch(BadParamException f){
			fail("Shift-Konstruktor fail");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setShiftAmount
	 * @throws BadParamException falsche eingabe des Users
	 */
	@Test(expected=BadParamException.class)
	public void setShiftAmount1() throws BadParamException{
		try{
			ShiftCipher m = new ShiftCipher(1);
			m.setShiftAmount(2);
		}catch(BadParamException f){
			throw new BadParamException("ShiftAmount-das setzen der Verschiebungsweite des Alphabetes entspricht nicht den Bedingungen");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setShiftAmount, wobei der Param den Wert null hat
	 * ==> sollte Exception werfen
	 * @throws BadParamException falsche Eingabe des Users
	 */
	@Test(expected=BadParamException.class)
	public void setShiftAmount2() throws BadParamException{
		try{
			ShiftCipher m = new ShiftCipher(1);
			m.setShiftAmount(Integer.parseInt(null));
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
		ShiftCipher m = new ShiftCipher(1);
		try{
			m.encrypt(null);
		}catch(NullPointerException f){
			throw new BadParamException("Shift-encrypt fail da der �bergebene Parameter null ist");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von encrypt, dabei wird ein richtiger Parameter �bergeben
	 * der die Kriterien erf�llt
	 */
	@Test
	public void encrypt2(){
		try {
			ShiftCipher m = new ShiftCipher(1);
			if(!(m.encrypt("BOZKURT").equals("OTBRZ Z U"))){
				fail("Shift-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("Shift-encrypt fail");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von decrypt, wobei der Para den Wert null hat
	 * ==> sollte eine BadParamException werfen
	 * @throws BadParamException Falsche Eingabe des Users
	 */
	@Test(expected=BadParamException.class)
	public void decrypt1() throws BadParamException{
		ShiftCipher m = new ShiftCipher(1);
		try{
			m.decrypt(null);
		}catch(NullPointerException f){
			throw new BadParamException("Shift-decrypt fail da der �bergebene Parameter null ist");
		}
	}
}

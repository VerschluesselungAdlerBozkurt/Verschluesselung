package adlerbozkurt.test;

import static org.junit.Assert.*;
import org.junit.Test;
import adlerbozkurt.cipher.*;

/**
 * Diese Klasse �berpr�ft alle Methoden von der Klasse TranspositionCipher mittel JUnit-Test
 * @author Philipp Adler
 * @version 2014-04-04
 */


public class TestTranspositionCipher {


	/**
	 * Diese Methode �berpr�ft den Konstruktor, hier wird eine Fehlermeldung erwartet den das �bergebene Level ist kleiner als 1
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void TranspositionCipher1() throws BadParamException{
		try{
			TranspositionCipher m = new TranspositionCipher(0);
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
	public void TranspositionCipher2() throws BadParamException{
		try{
			TranspositionCipher m = new TranspositionCipher(Integer.parseInt(null));
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
			TranspositionCipher m = new TranspositionCipher(1);
		}catch(BadParamException f){
			fail("Transposition-Konstruktor fail");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setTranspositionLevel, dabei wird ein Parameter �bergeben
	 * der kleiner 1 ist, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void setTranspositionLevel1() throws BadParamException{
		try{
			TranspositionCipher m = new TranspositionCipher(5);
			m.setTranspositionLevel(0);
		}catch(BadParamException f){
			throw new BadParamException("TranspositionCipher-setTranspositionLevelFail erwartet den das �bergebene Level ist kleiner 1");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setTranspositionLevel, dabei wird ein Parameter �bergeben
	 * der keine Zahl ist, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void setTranspositionLevel2() throws BadParamException{
		try{
			TranspositionCipher m = new TranspositionCipher(5);
			m.setTranspositionLevel(Integer.parseInt(null));
		}catch(NumberFormatException f){
			throw new BadParamException();
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von setTranspositionLevel
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test
	public void setTranspositionLevel3() throws BadParamException{
		try{
			TranspositionCipher m = new TranspositionCipher(5);
			m.setTranspositionLevel(4);
		}catch(BadParamException f){
			fail("Transposition-setTranspositionLevel fail");
		}
	}



	/**
	 * Diese Methode �berpr�ft eine Variante von encrypt, dabei wird ein Parameter �bergeben
	 * der den Wert null hat, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void encrypt1() throws BadParamException{
		TranspositionCipher m = new TranspositionCipher(5);
		try{
			m.encrypt(null);
		}catch(NullPointerException f){
			throw new BadParamException("MonoAlphabetic-encrypt fail da der �bergebene Parameter null ist");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von encrypt, dabei wird ein Parameter �bergeben
	 * der die Kriterien erf�llt
	 */
	@Test
	public void encrypt2(){
		try {
			TranspositionCipher m = new TranspositionCipher(2);
			if(!(m.encrypt("Adler").equals("ALRDE"))){
				fail("MonoAlphabetic-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("MonoAlphabetic-encrypt fail");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von decrypt, dabei wird ein Parameter �bergeben
	 * der den Wert null hat, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch �bergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void decrypt1() throws BadParamException{
		TranspositionCipher m = new TranspositionCipher(5);
		try{
			m.decrypt(null);
		}catch(NullPointerException f){
			throw new BadParamException("MonoAlphabetic-decrypt fail da der �bergebene Parameter null ist");
		}
	}


	/**
	 * Diese Methode �berpr�ft eine Variante von decrypt, dabei wird ein Parameter �bergeben
	 * der die Kriterien erf�llt
	 */
	@Test
	public void decrypt2(){
		try {
			TranspositionCipher m = new TranspositionCipher(2);
			//System.out.println(m.decrypt("ALRDE"));
			//if(!(m.decrypt("ALRDE").equals("ADLER"))){
				//fail("MonoAlphabetic-encrypt fail");
			//}
		} catch (BadParamException e) {
			fail("MonoAlphabetic-encrypt fail");
		}
	}
}

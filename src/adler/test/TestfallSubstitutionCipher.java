package adler.test;

import static org.junit.Assert.*;
import org.junit.Test;
import adler.cipher.BadParamException;

/**
 * Diese Klasse überprüft alle Methoden von der Klasse SubstitutionCipher mittel JUnit-Test
 * @author Philipp Adler
 * @version 2014-04-04
 */


public class TestfallSubstitutionCipher {

	
	/**
	 * Diese Methode überprüft eine Variante von dem Konstruktor,
	 * dabei wird ein Parameter übergeben der den Wert null hat, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void SubstitutionCipher1() throws BadParamException{
		try{
			adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher(null);
		}catch(BadParamException f){
			throw new BadParamException();
		}
	}

	
	/**
	 * Diese Methode überprüft eine Variante von Konstruktor, dabei wird ein Parameter übergeben
	 * der nicht alle Buchstaben des Alphabets beinhaltet, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void SubstitutionCipher2() throws BadParamException{
		try{
			adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("AABCDEFGHIJKLMNOPQRSTUVWXYZÄÜÖ");
		}catch(BadParamException f){
			throw new BadParamException("SubstitutionCipher-KonstruktorFail erwartet den es sind nicht alle Buchstaben vorhanden");
		}
	}

	
	/**
	 * Diese Methode überprüft eine Variante vom Konstruktor, dabei wird ein Parameter übergeben
	 * der mehr als 31 Buchstaben beinhaltet, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void SubstitutionCipher3() throws BadParamException{
		try{
			adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("AABCDEFGHIJKLMNOPQRSTUVWXYZÄÜÖß");
		}catch(BadParamException f){
			throw new BadParamException("SubstitutionCipher-KonstruktorFail den es ist ein Buchstabe zu viel");
		}
	}

	
	/**
	 * Diese Methode überprüft eine Variante vom Konstruktor, dabei wird ein Parameter übergeben
	 * der die Kriterien erfüllt
	 */
	@Test
	public void setSecretAlphabet4(){
		try{
			adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		}catch(BadParamException f){
			fail("SubstitutionCipher-Konstruktor fail");
		}
	}
	
	
	/**
	 * Diese Methode überprüft die getSecretAlphabet, diese gibt das geheim Alphabet zurück,
	 * dabei sollte alles klappen
	 */
	@Test
	public void getSecretAlphabet() throws BadParamException{
		adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		if(!s.getSecretAlphabet().equals("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM")){
			fail("SubstitutionCipher-getSecretAlphabet fail");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von encrypt, dabei wird ein Parameter übergeben
	 * der den Wert null hat, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void encrypt1() throws BadParamException{
		adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try{
			s.encrypt(null);
		}catch(BadParamException f){
			throw new BadParamException("SubstitutionCipher-encrypt fail da der übergebene Parameter null ist");
		}
	}
	
	/**
	 * Diese Methode überprüft eine Variante von encrypt, dabei wird ein Parameter übergeben
	 * der die Kriterien erfüllt
	 */
	@Test
	public void encrypt2() throws BadParamException{
		adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try {
			s.setSecretAlphabet("QWERTZßUIOPÜÄÖLKJHGFDSAYXCVBNM");
			if(!(s.encrypt("bcd!").equals("WER!"))){
				fail("SubstitutionCipher-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("SubstitutionCipher-encrypt fail");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von decrypt, dabei wird ein Parameter übergeben
	 * der den Wert null hat, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void decrypt1() throws BadParamException{
		adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try{
			s.decrypt(null);
		}catch(BadParamException f){
			throw new BadParamException("SubstitutionCipher-decrypt fail da der übergebene Parameter null ist");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von decrypt, dabei wird ein Parameter übergeben
	 * der die Kriterien erfüllt
	 */
	@Test
	public void decrypt2() throws BadParamException{
		adler.cipher.SubstitutionCipher s = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try {
			s.setSecretAlphabet("QWERTZßUIOPÜÄÖLKJHGFDSAYXCVBNM");
			if(!(s.decrypt("WQE!").equals("bac!"))){
				fail("SubstitutionCipher-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("SubstitutionCipher-encrypt fail");
		}
	}
}

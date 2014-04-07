package adler.test;

import static org.junit.Assert.*;
import org.junit.Test;
import adler.cipher.BadParamException;

/**
 * Diese Klasse überprüft alle Methoden von der Klasse MonoAlphabeticCipher mittel JUnit-Test
 * @author Philipp Adler
 * @version 2014-04-04
 */


public class TestfallMonoAlphabeticCipher {
	
	
	/**
	 * Diese Methode überprüft den Konstruktor, dieser erzeugt ein default-geheim-Alphabet,
	 * dabei sollte alles klappen
	 */
	@Test
	public void MonoAlphabeticCipher(){
		adler.cipher.MonoAlphabeticCipher m = new adler.cipher.MonoAlphabeticCipher();
		if(m.getSecretAlphabet().equals(null)){
			fail("MonoAlphabeticCipher-Konstruktor fail");
		}
	}
	
	
	/**
	 * Diese Methode überprüft die getSecretAlphabet, diese gibt das geheim Alphabet zurück,
	 * dabei sollte alles klappen
	 */
	@Test
	public void getSecretAlphabet(){
		adler.cipher.MonoAlphabeticCipher m = new adler.cipher.MonoAlphabeticCipher();
		if(m.getSecretAlphabet().equals(null)){
			fail("MonoAlphabeticCipher-getSecretAlphabet fail");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von setSecretAlphabet, dabei wird ein Parameter übergeben
	 * der den Wert null hat, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void setSecretAlphabet1() throws BadParamException{
		adler.cipher.SubstitutionCipher m = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try{
			m.setSecretAlphabet(null);
		}catch(BadParamException f){
			throw new BadParamException();
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von setSecretAlphabet, dabei wird ein Parameter übergeben
	 * der nicht alle Buchstaben des Alphabets beinhaltet, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void setSecretAlphabet2() throws BadParamException{
		adler.cipher.SubstitutionCipher m = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try{
			m.setSecretAlphabet("AABCDEFGHIJKLMNOPQRSTUVWXYZÄÜÖ");
		}catch(BadParamException f){
			throw new BadParamException("MonoAlphabeticCipher-setSecretAlphabetFail erwartet den es sind nicht alle Buchstaben vorhanden");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von setSecretAlphabet, dabei wird ein Parameter übergeben
	 * der mehr als 31 Buchstaben beinhaltet, sollte eine BadParamException werfen
	 * @throws BadParamException gibt eine Fehlermeldung aus welche den Benutzer darauf anspricht, 
	 * das er was falsch übergeben hat
	 */
	@Test(expected=BadParamException.class)
	public void setSecretAlphabet3() throws BadParamException{
		adler.cipher.SubstitutionCipher m = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		try{
			m.setSecretAlphabet("AABCDEFGHIJKLMNOPQRSTUVWXYZÄÜÖß");
		}catch(BadParamException f){
			throw new BadParamException("MonoAlphabeticCipher-setSecretAlphabetFail den es ist ein Buchstabe zu viel");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von setSecretAlphabet, dabei wird ein Parameter übergeben
	 * der die Kriterien erfüllt
	 */
	@Test
	public void setSecretAlphabet4(){
		try{
			adler.cipher.SubstitutionCipher m = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
			m.setSecretAlphabet("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		}catch(BadParamException f){
			fail("MonoAlphabeticCipher-setSecretAlphabet fail");
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
		adler.cipher.MonoAlphabeticCipher m = new adler.cipher.MonoAlphabeticCipher();
		try{
			m.encrypt(null);
		}catch(BadParamException f){
			throw new BadParamException("MonoAlphabetic-encrypt fail da der übergebene Parameter null ist");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von encrypt, dabei wird ein Parameter übergeben
	 * der die Kriterien erfüllt
	 */
	@Test
	public void encrypt2(){
		try {
			adler.cipher.SubstitutionCipher m = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
			m.setSecretAlphabet("QWERTZßUIOPÜÄÖLKJHGFDSAYXCVBNM");
			if(!(m.encrypt("bcd!").equals("WER!"))){
				fail("MonoAlphabetic-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("MonoAlphabetic-encrypt fail");
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
		adler.cipher.MonoAlphabeticCipher m = new adler.cipher.MonoAlphabeticCipher();
		try{
			m.decrypt(null);
		}catch(BadParamException f){
			throw new BadParamException("MonoAlphabetic-decrypt fail da der übergebene Parameter null ist");
		}
	}
	
	
	/**
	 * Diese Methode überprüft eine Variante von decrypt, dabei wird ein Parameter übergeben
	 * der die Kriterien erfüllt
	 */
	@Test
	public void decrypt2(){
		try {
			adler.cipher.SubstitutionCipher m = new adler.cipher.SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
			m.setSecretAlphabet("QWERTZßUIOPÜÄÖLKJHGFDSAYXCVBNM");
			if(!(m.decrypt("WQE!").equals("bac!"))){
				fail("MonoAlphabetic-encrypt fail");
			}
		} catch (BadParamException e) {
			fail("MonoAlphabetic-encrypt fail");
		}
	}
}

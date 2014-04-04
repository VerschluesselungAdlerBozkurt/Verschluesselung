package adler.cipher;


/**
 * Diese Klasse stellt ein Interface dar, welches 2 Methoden beinhaltet welche einen Text ver- und entschl�sseln
 * @author Philipp Adler
 * @version 2014-04-04
 */

public interface Cipher {
	
	
	
	/**
	 * Diese Methode ist f�r die Verschl�sselung zust�ndig, also sie nimmt die Benutzereingabe entgegen und
	 * wandelt diese mit Hilfe des Geheimalphabet in eine Sprache die nur der betreffende Benutzer versteht um
	 * @param text die Benutzereingabe welche verschl�sselt werden soll
	 * @return gibt den verschl�sselten, geheimen Text zur�ck
	 * @throws BadParamException 
	 */
	public String encrypt(String text) throws BadParamException;
	
	
	
	/**
	 * Diese Methode ist f�r die Entschl�sselung zust�ndig, also sie nimmt die Benutzereingabe entgegen und
	 * wandelt diese mit Hilfe des Geheimalphabet in eine Sprache die wieder jeder versteht um
	 * @param text die Benutzereingabe welche entschl�sselt werden soll
	 * @return gibt den entschl�sselten, normalen Text zur�ck
	 * @throws BadParamException
	 */
	public String decrypt(String text) throws BadParamException;

}

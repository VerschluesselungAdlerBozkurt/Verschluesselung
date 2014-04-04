package adler.cipher;


/**
 * Diese Klasse stellt ein Interface dar, welches 2 Methoden beinhaltet welche einen Text ver- und entschlüsseln
 * @author Philipp Adler
 * @version 2014-04-04
 */

public interface Cipher {
	
	
	
	/**
	 * Diese Methode ist für die Verschlüsselung zuständig, also sie nimmt die Benutzereingabe entgegen und
	 * wandelt diese mit Hilfe des Geheimalphabet in eine Sprache die nur der betreffende Benutzer versteht um
	 * @param text die Benutzereingabe welche verschlüsselt werden soll
	 * @return gibt den verschlüsselten, geheimen Text zurück
	 * @throws BadParamException 
	 */
	public String encrypt(String text) throws BadParamException;
	
	
	
	/**
	 * Diese Methode ist für die Entschlüsselung zuständig, also sie nimmt die Benutzereingabe entgegen und
	 * wandelt diese mit Hilfe des Geheimalphabet in eine Sprache die wieder jeder versteht um
	 * @param text die Benutzereingabe welche entschlüsselt werden soll
	 * @return gibt den entschlüsselten, normalen Text zurück
	 * @throws BadParamException
	 */
	public String decrypt(String text) throws BadParamException;

}

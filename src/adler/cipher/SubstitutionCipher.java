package adler.cipher;


/**
 * Diese Klasse erbt von MonoAlphabeticCipher, diese Klasse erlaubt es einen Text zu verschlüsseln und zu entschlüsseln
 * @author Philipp Adler
 * @version 2014-04-04
 */

public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	
	
	/**
	 * Der Konstruktor übergibt den Parameter an den super.Konstruktor, also der darüberliegende und
	 * speichert sich dem Paramter als Geheimalphabet
	 * @param secretAlphabet
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder größer als 30 ist kommt es zu einer Fehlermeldung
	 */
	public SubstitutionCipher(String secretAlphabet) throws BadParamException{
		super();//aufruf des Konstruktors der darüberliegenden, also der Erberklasse
		this.setSecretAlphabet(secretAlphabet);//gibt den Parameter an die Methode setSecretAlphabet weiter welches den Parameter als neues geheim Alphabet speichert
	}
	
	
	
	/**
	 * Diese Methode nimmt als Parameter das geheime Alphabet entgegen, übergibt es die darüberliegende Klasse MonoAöphabeticCipher,
	 * welches das Alphabet als neues geheim Alphabet speichert 
	 * @param secretAlphabet das neue Geheimalphabet welches gespeichert wird und mit dem gearbeitet wird
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder größer als 30 ist kommt es zu einer Fehlermeldung
	 */
	@Override
	public void setSecretAlphabet(String secretAlphabet) throws BadParamException{
		super.setSecretAlphabet(secretAlphabet);//aufruf der Methode setSecretAlphabet, also der darüberliegenden Erbeklasse
	}
}

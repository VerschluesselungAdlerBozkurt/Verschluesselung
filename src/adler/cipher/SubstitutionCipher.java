package adler.cipher;


/**
 * Diese Klasse erbt von MonoAlphabeticCipher, diese Klasse erlaubt es einen Text zu verschl�sseln und zu entschl�sseln
 * @author Philipp Adler
 * @version 2014-04-04
 */

public class SubstitutionCipher extends MonoAlphabeticCipher{
	
	
	
	/**
	 * Der Konstruktor �bergibt den Parameter an den super.Konstruktor, also der dar�berliegende und
	 * speichert sich dem Paramter als Geheimalphabet
	 * @param secretAlphabet
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder gr��er als 30 ist kommt es zu einer Fehlermeldung
	 */
	public SubstitutionCipher(String secretAlphabet) throws BadParamException{
		super();//aufruf des Konstruktors der dar�berliegenden, also der Erberklasse
		this.setSecretAlphabet(secretAlphabet);//gibt den Parameter an die Methode setSecretAlphabet weiter welches den Parameter als neues geheim Alphabet speichert
	}
	
	
	
	/**
	 * Diese Methode nimmt als Parameter das geheime Alphabet entgegen, �bergibt es die dar�berliegende Klasse MonoA�phabeticCipher,
	 * welches das Alphabet als neues geheim Alphabet speichert 
	 * @param secretAlphabet das neue Geheimalphabet welches gespeichert wird und mit dem gearbeitet wird
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder gr��er als 30 ist kommt es zu einer Fehlermeldung
	 */
	@Override
	public void setSecretAlphabet(String secretAlphabet) throws BadParamException{
		super.setSecretAlphabet(secretAlphabet);//aufruf der Methode setSecretAlphabet, also der dar�berliegenden Erbeklasse
	}
}

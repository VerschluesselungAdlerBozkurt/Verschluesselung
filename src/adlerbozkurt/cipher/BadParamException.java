package adlerbozkurt.cipher;


/**
 * Diese Klasse erbt von Exception, um meine eigene Exception zu erzeugen
 * @author Philipp Adler
 * @version 2014-04-04
 */

public class BadParamException extends Exception{


	
	/**
	 * Das ist der Default-Konstruktor dieser Klasse welche eine vordefinierte Fehlermeldung zur Folge hat
	 */
	public BadParamException(){
		super("Der übergebene Parameter entspricht nicht den Anforderungen");//aufruf des Super-Konstruktor
	}


	
	/**
	 * Das der Parameter-Konstruktor welcher einen Benutzerdefinierten Text entgegen nimmt und diesen als Fehlermeldung ausgibt
	 * @param message der Benutzerdefinierte Text welcher ausgegeben wird
	 */
	public BadParamException(String message){
		super(message);//aufruf des Super-Konstruktor mit Parameter
	}
}

package adlerbozkurt.cipher;


/**
 * Diese Klasse erbt von MonoAlphabeticCipher, diese Klasse verschlüsselt den Text mittels Verschiebung des Alphabets
 * @author Philipp Adler
 * @version 2013-04-16
 */

public class ShiftCipher extends MonoAlphabeticCipher{



	/**
	 * Dieser Konstruktor hat als Parameter eine Zahl, welche angibt um wieviel das Alphabet nach rechts verschoben werden soll
	 * @param value Wert der Verschiebung
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder größer als 30 ist kommt es zu einer Fehlermeldung
	 */
	public ShiftCipher(int value) throws BadParamException{
		super();//aufruf des Konstruktors der darüberliegenden, also der Erberklasse
		this.setShiftAmount(value);//gibt den Parameter an die Methode setSecretAlphabet weiter welches den Parameter als neues geheim Alphabet speichert
	}



	/**
	 * Diese Methode verschiebt das Alphabet um den übergebenen Parameter
	 * @param shiftvalue Wert der Verschiebung, wie weit das Geheimalphabet nach rechts verschoben werden soll
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder größer als 30 ist kommt es zu einer Fehlermeldung
	 */
	public void setShiftAmount(int shiftvalue) throws BadParamException{
		while(shiftvalue > 30){//falls der übergebene größer 30 ist wird er um 30 subtrahiert, weil 31 ist gleich wie 1
			shiftvalue -= 30;
		}
		if(shiftvalue < 0){//falls der übergebene Parameter negativ wird eine Fehlermeldung ausgegeben
			throw new BadParamException("Der übergebene Parameter ist im negativen Bereich"+
					"\n"+"Bitte geben Sie den Parameter erneuert ein, aber diesmal im positiven Bereich!!!");//wirft eine Exception mit einer benutzerbasierten Meldung

		}
		String geheim = super.getSecretAlphabet();//das Standard-Alphabet welches verschoben wird
		String speicher="";//speichervariabel wo das Geheimalphabet gespeichert werden soll
		for(int i=0; i<geheim.length(); i++){
			if((shiftvalue+i) >= geheim.length()){//falls der Wert größer oder gleich 30 ist
				speicher += geheim.charAt(shiftvalue+i-geheim.length());//speichert den neuen Buchstaben in die Zwischenvariable
			}else{//wenn kleiner 30
				speicher += geheim.charAt(shiftvalue+i);//speichert den neuen Buchstaben in die Zwischenvariable
			}
		}
		try {
			super.setSecretAlphabet(speicher);//übergibt das Geheimalphabet an die Elternklasse und speichert es dort
		} catch (BadParamException e) {//falls mit dem übergebenen Parameter etwas nicht stimmt kommt es zu einer Fehlermeldung
			e.printStackTrace();
		}
	}
}

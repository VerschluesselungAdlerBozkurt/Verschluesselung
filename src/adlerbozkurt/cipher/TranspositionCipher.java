package adlerbozkurt.cipher;

/**
 * Die Klasse für das Gartenzaun-Verschlüsselungssystem
 * @author Hüseyin Bozkurt
 * @version 2014-05-03
 *
 */
public class TranspositionCipher implements Cipher {
	private int transpositionlvl; 

	//METHODS 
	public TranspositionCipher(int translvl) throws BadParamException{
		this.setTranspositionLevel(translvl);
	}

	public void setTranspositionLevel(int lvl) throws BadParamException{
		if(lvl > 0) {
			this.transpositionlvl = lvl;
		}else{
			throw new BadParamException("Das Level muss mehr als 0 sein bitte geben sie das Level erneuert ein");
		}
	}
	/**
	 * Die encrypt-Methode, die den Text der als parameter übergeben wird, per Gartenzaun-Verschlüsselung verschlüsselt
	 * Der Text wird als erstes in Großbuchstaben umgewandelt mit toUpperCase,
	 * danach werden alle Lücken(Spaces) geschlossen mit replaceAll.
	 * Das String Array wird vorerst mit "" gefüllt,
	 * wobei die Richtigen buchstaben per modulo (%) eingefügt werden.
	 * Bei der Ausgabe werden einfach die einzelnen Stellen des String-Arrays
	 * in einen normalen String geschrieben.
	 * @param text 
	 * @return decryptText
	 */
	@Override
	public String encrypt(String text) throws BadParamException {
		//Nur Großbuchstaben
		String largeText = text.toUpperCase();

		//Array, Jede Stelle für eine Zeile, Füllen mit "" wert
		String[] crypt = new String[transpositionlvl];
		for(int i = 0; i < crypt.length; i++) {
			crypt[i] = "";
		}

		//Holen der Buchstaben ins richtige Array
		for(int i = 0; i < largeText.length(); i++) {
			crypt[i%crypt.length] += largeText.charAt(i);
		}

		//Ausgabe
		String cryptText = "";
		for(String subCrypt:crypt) {
			cryptText += subCrypt;
		}

		return cryptText;
	}
	/**
	 * Die decrypt-Methode, die den Gartenzaun-text wieder lesbar macht.
	 * Als erstes wird mit der .split Methode der ganze Text in Zeilen unterteilt,
	 * danach jeder einzelne Buchstabe in ein 2D-char-Array durch die toCharArray-Methode
	 * welches dann im letzten Schritt ausgelesen wird.
	 * @param text 
	 * @return decryptText
	 */
	@Override
	public String decrypt(String text) throws BadParamException {
		//Array, Jede Stelle f�r eine Zeile, F�llen mit "" wert 
 		String[] decrypt = new String[transpositionlvl]; 
		String[] crypt = new String[transpositionlvl]; 
		
		for(int i = 0; i < crypt.length; i++) {
			decrypt[i] = "";
		}
		for(int i = 0; i < text.length(); i++) {
			decrypt[i%decrypt.length] += text.charAt(i);
		}
		int zahl = 0;
		int zahl1 = 0;
		for(int i = 0;i < crypt.length; i++){
			zahl = zahl1;
			zahl1 += decrypt[i].length();
			crypt[i] = text.substring(zahl,zahl1);
		}
		
		//Char Array, Jede Stelle ein Zeichen (Haupt Array W�rter) 
		char[][] cryptChars = new char[crypt.length][]; 
		for(int i = 0; i < crypt.length; i++) { 
			cryptChars[i] = crypt[i].toCharArray(); 
		} 
		//Auslesen des Char Arrays in umgekehrter Reihenfolge (Zuerst Inner und dann Outer Array) 
		String decryptText = ""; 
		for(int i = 0; i < cryptChars[0].length; i++) 
			for(int j = 0; j < cryptChars.length; j++) 
				if(i < cryptChars[j].length) { 
					decryptText += cryptChars[j][i]; 
				} 
		return decryptText; 
	}
}
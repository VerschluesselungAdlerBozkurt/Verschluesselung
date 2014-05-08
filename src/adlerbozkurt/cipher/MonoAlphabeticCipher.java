package adlerbozkurt.cipher;


/**
 * Diese Klasse stellt einen Cipher, also eine Ent- und Verschluesselung von einem Text, dar
 * @author Philipp Adler
 * @version 2014-04-04
 */

public class MonoAlphabeticCipher implements Cipher{
	private String secretAlphabet;//dieses Attribut speichert sich das Geheimalphabet


	
	/**
	 * Der Konstruktor speichert sich als Standard-Alphabet als Geheimalphabet
	 */
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß";//speichert das Standartalphabet in das Attribut secretAlphabet
	}


	
	/**
	 * Diese Methode ist eine getter-Methode welche das Geheimalphabet zurückgibt
	 * @return das geheime Alphabet als Text
	 */
	public String getSecretAlphabet(){
		return this.secretAlphabet;//gibt das geheime Alphabet zurück
	}


	
	/**
	 * Diese Methode nimmt als Parameter das geheime Alphabet entgegen, welches als neues Alphabet gespeichert wird 
	 * @param secretAlphabet das neue Geheimalphabet welches gespeichert wird und mit dem gearbeitet wird
	 * @throws BadParamException falls das Alphabet nicht den Erwartungen entspricht, also kleiner oder größer als 30 ist kommt es zu einer Fehlermeldung
	 */
	protected void setSecretAlphabet(String secretAlphabet) throws BadParamException{
		try{//hier wird überprüft ob der übergebene Parameter null ist
			secretAlphabet = secretAlphabet.replace('ß', '*');//wenn man das ß in Großbuchstaben umwandelt passiert es das es zu SS wird
		}
		catch(NullPointerException f){
			throw new BadParamException("Der übergebene Parameter ist null"+
					"\n"+"Bitte geben Sie das Geheimalphabet erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
		}
		secretAlphabet = secretAlphabet.toUpperCase();//wandelt die Buchstaben vom übergebenen Text in Großbuchstaben
		secretAlphabet = secretAlphabet.replace('*', 'ß');//wenn man das ß in Großbuchstaben umwandelt passiert es das es zu SS wird
		int anzahl = 0;//überprüft ob alle 30 Buchstaben im Text stehen
		for(int i = 0, buchstabe = 65; i <= 30; i++, buchstabe++){//sollten 30 Durchläufe sein um jeden Buchstaben zu überprüfen
			switch (buchstabe) {//falls alle alphabetischen Buchstaben schon überprüft wurden kommen wir zu den Umlauten
			case 91://nach Z
				buchstabe = 223;//ß
				break;//verlässt die switch-case Anweisung

			case 224://nach ß
				buchstabe = 196;//Ä
				break;//verlässt die switch-case Anweisung

			case 197://nach Ä
				buchstabe = 214;//Ö
				break;//verlässt die switch-case Anweisung

			case 215://nach Ö
				buchstabe = 220;//Ü
				break;//verlässt die switch-case Anweisung

			default:
				break;//verlässt die switch-case Anweisung
			}
			for(int j = 0; j < secretAlphabet.length(); j++){//geht jeden Buchstaben vom übergebenen Parameter durch
				if(secretAlphabet.charAt(j) == (char)buchstabe){//hier wird überprüft ob jeder Buchstabe vorkommt
					anzahl ++;//erhöht die Anzahl um zu sagen wieviele einmalige Buchstaben im secret Alphabet stehen
					j = secretAlphabet.length();//beendet die Schleife
				}
			}
		}

		if(secretAlphabet.length() == 30 && anzahl == 30){//wenn das geheime Alphabet alle 30 Buchstaben enthält wird es gespeichert
			this.secretAlphabet = secretAlphabet;//speichert das neue geheime Alphabet in das Attribut
		}
		else if(secretAlphabet.length() != 30){//falls das neue Alphabet mehr oder weniger als 30 Buchstabe enthält kommt es zu einer Fehlermeldung
			throw new BadParamException("Der übergebene Parameter ist zu lang oder zu kurz"+
					"\n"+"Bitte geben Sie das Geheimalphabet erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
		}
		else if(anzahl != 30){//falls das neue Alphabet nicht alle 30 Buchstaben enthält sei es es kommt ein Buchstabe doppelt kommt es zu einer Fehlermeldung
			throw new BadParamException("Der übergebene Parameter enthält nicht alle Buchstaben"+
					"\n"+"Bitte geben Sie das Geheimalphabet erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
		}
	}


	
	@Override
	public String encrypt(String text) throws BadParamException{
		try{//hier wird überprüft ob der übergebene Parameter null ist
			text=text.toLowerCase();//wandelt die Eingabe in Kleinbuchstaben um
		}
		catch(NullPointerException f){
			throw new BadParamException("Der übergebene Parameter ist null"+
					"\n"+"Bitte geben Sie einen geeigneten Text der verschlüsselt werden ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
		}

		String verschluesselt = "";//Speichervariable in dem der verschlüsselte Text gespeichert wird
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";//das Standard Alphabet zur Verschlüsselung
		for(int i = 0; i < text.length(); i++){//geht jeden Buchstaben vom normalen Text durch
			for(int j = 0; j < this.secretAlphabet.length(); j++){//Geht jeden Geheim Buchstabe vom Alphabet durch
				if(alphabet.charAt(j) == text.charAt(i)){//Wenn Text Buchstabe gleich Buchstabe vom Alphabet
					verschluesselt += this.secretAlphabet.charAt(j);//nimmt den Index vom Geheimalphabet und speichert es in die Speichervariable
					j = this.secretAlphabet.length();//beendet die Schleife vorzeitig da ja der Buchstabe gefunden wurde
				}
				if(j == this.secretAlphabet.length()-1){//falls es sich um ein Zeichen handelt welches nicht im Geheimalphabet drin steht
					verschluesselt += text.charAt(i);//übernimmt das Zeichen vom Parameter
				}
			}
		}
		return verschluesselt;//gibt den verschlüsselten Text aus
	}

	
	
	@Override
	public String decrypt(String text) throws BadParamException{
		try{//hier wird uebrprüft ob der übergebene Parameter null ist
			text = text.replace('ß', '*');//wenn man das ß in Großbuchstaben umwandelt passiert es das es zu SS wird
			text = text.toUpperCase();//die Geheimsprache beinhaltet nur Großbuchstaben
			text = text.replace('*', 'ß');//wenn man das ß in Großbuchstaben umwandelt passiert es das es zu SS wird
		}
		catch(NullPointerException f){
			throw new BadParamException("Der übergebene Parameter ist null"+
					"\n"+"Bitte geben Sie einen geeigneten Text der entschlüsselt werden ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
		}

		String entschluesselt = "";//Speichervariable in dem der entschlüsselte Text gespeichert wird
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";//das Standard Alphabet zur Entschlüsselung

		for(int i = 0; i < text.length(); i++){//geht jeden Buchstaben vom geheim Text durch
			for(int j = 0; j < this.secretAlphabet.length(); j++){//Geht jeden Geheim Buchstabe vom Alphabet durch
				if(this.secretAlphabet.charAt(j) == text.charAt(i)){//wenn Geheim Alphabet gleich geheim Buchstabe wird es entschlüsselt
					entschluesselt += alphabet.charAt(j);//speichert den entschlüsselten Buchstaben in die Speichervaribale
					j = this.secretAlphabet.length();//beendet die Schleife vorzeitig da ja der Buchstabe gefunden wurde
				}
				if(j == this.secretAlphabet.length()-1){//falls es sich um ein Zeichen handelt welches nicht im Geheimalphabet drin steht
					entschluesselt += text.charAt(i);//übernimmt das Zeichen vom Parameter
				}
			}
		}
		return entschluesselt;//gibt den entschlüsselten Text aus
	}
}

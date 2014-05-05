package adlerbozkurt.cipher;

import java.util.*;


/**
 * Diese Klasse erstellt anhand eines Schl�sselwortes ein Geheimalphabet
 * @author Philipp Adler
 * @version 2014-04-16
 */

public class KeywordCipher extends MonoAlphabeticCipher{
	private String keyword;


	/**
	 * Der Konstruktor bekommt als Parameter ein Schl�sselwort, mit dem wir uns dann eine Tabelle erstellen,
	 * wo das Alphabet nach den Kritieren des Schl�sselwortes eingef�gt werden und sp�ter wieder zu einem Geheimalphabet zusammengesetzt wird.
	 * @param keyword das Schl�sselwort welches f�r die Verschl�sselung zust�ndig ist
	 */
	public KeywordCipher(String keyword) throws BadParamException{
		super();//Ruft den Konstruktor der Elternklasse auf
		this.setKeyword(keyword);//�bergibt der Methode setKeyword das Schl�sselwort
	}

	@Override
	public String decrypt(String text) throws BadParamException {
		String keyword = this.keyword;
		String keyword1 = this.keyword;//speichern des Schl�sselwortes in einer Zwischenvariabele
		String text1 = text;
		String geheim = text1;//das Geheimtext
		int rows;
		try{
			rows = geheim.length() / keyword.length();//berechnung der Zeilen von der Tabelle
			if(geheim.length() % keyword.length() != 0)rows++;
		}catch(NullPointerException f){
			throw new BadParamException("Der �bergebene Parameter ist null"+
					"\n"+"Bitte geben Sie den Parameter erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung

		}
		Character[][] table = new Character[keyword.length()][rows];//erzeugen eine Character Tabelle
		//Anzahl der Buchstaben aus dem Schl�sselwort ergeben die Spalten
		TreeMap<Integer, Character> liste = new TreeMap<Integer, Character>();//erzeugen einer Sortierten Map
		for(int i = 0, indexMin = 0 , zahler = 1; i<keyword.length(); zahler++){
			for(int j = 0; j<keyword.length(); j++){
				if(keyword.charAt(j) < keyword.charAt(indexMin)){//es wird der niedrigste Buchstabe gesucht
					indexMin = j;
				}
			}
			liste.put(zahler, keyword.charAt(indexMin));//f�gt den niedrigsten Buchstaben mit einer Zahl als Value in die Map z.B. 1 A, 2 B,..  
			keyword = keyword.replaceFirst(keyword.charAt(indexMin)+"", "");//l�scht den Buchstaben aus dem Schl�sselwort
			indexMin = 0;
		}

		HashMap<Character,Integer> liste1 = new HashMap<Character,Integer>();//erstellen einer unsortierten Map
		for(int i = 0; i<keyword1.length(); i++){
			liste1.put(liste.get(i+1),(i+1));//f�gt die Value von der Sortierten Map nun als Key in die unsortierte Map
		}

		//f�gt das Alphabet in die Character-Table Zeile f�r Zeile 
		for(int i = 0, j = 0, zahler=0; i<rows; i++){
			try{
				table[keyword1.indexOf(liste.get(j+1))][i] = geheim.charAt(zahler);
			}catch(java.lang.StringIndexOutOfBoundsException f){
				table[j][i] = ' ';
			}
			zahler++;

			if(i == rows-1){
				i = -1;
				j++;
				if(j == keyword1.length())break;
			}
		}

		//liest die Tabelle aus, in einer gewissen Reihenfolge der Spalten
		String geheimalphabet = "";//diese Variable speichert sich Geheimalphabet
		for(int i = 0; i<rows; i++){
			for(int j = 0; j<keyword1.length(); j++){
				geheimalphabet += table[j][i];//nimmt die Buchstaben von Zeile zu Zeile und speichert es in das Attribut wo das Geheimalphabet gespeichert wird
			}
		}
		return geheimalphabet;
	}

	@Override
	public String encrypt(String text) throws BadParamException {
		String keyword = this.keyword;
		String keyword1 = this.keyword;//speichern des Schl�sselwortes in einer Zwischenvariabele
		String text1 = text;
		String geheim = text1;//das Geheimtext
		int rows;
		try{
			rows = geheim.length() / keyword.length();//berechnung der Zeilen von der Tabelle
			if(geheim.length() % keyword.length() != 0)rows++;
		}catch(NullPointerException f){
			throw new BadParamException("Der �bergebene Parameter ist null"+
					"\n"+"Bitte geben Sie den Parameter erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung

		}
		Character[][] table = new Character[keyword.length()][rows];//erzeugen eine Character Tabelle
		//Anzahl der Buchstaben aus dem Schl�sselwort ergeben die Spalten
		TreeMap<Integer, Character> liste = new TreeMap<Integer, Character>();//erzeugen einer Sortierten Map
		for(int i = 0, indexMin = 0 , zahler = 1; i<keyword.length(); zahler++){
			for(int j = 0; j<keyword.length(); j++){
				if(keyword.charAt(j) < keyword.charAt(indexMin)){//es wird der niedrigste Buchstabe gesucht
					indexMin = j;
				}
			}
			liste.put(zahler, keyword.charAt(indexMin));//f�gt den niedrigsten Buchstaben mit einer Zahl als Value in die Map z.B. 1 A, 2 B,..  
			keyword = keyword.replaceFirst(keyword.charAt(indexMin)+"", "");//l�scht den Buchstaben aus dem Schl�sselwort
			indexMin = 0;
		}

		HashMap<Character,Integer> liste1 = new HashMap<Character,Integer>();//erstellen einer unsortierten Map
		for(int i = 0; i<keyword1.length(); i++){
			liste1.put(liste.get(i+1),(i+1));//f�gt die Value von der Sortierten Map nun als Key in die unsortierte Map
		}

		//f�gt das Alphabet in die Character-Table Zeile f�r Zeile  
		for(int i = 0, j = 0, zahler = 0; i<keyword1.length(); i++, zahler++){
			try{
				table[i][j] = geheim.charAt(zahler);
			}catch(java.lang.StringIndexOutOfBoundsException f){
				table[i][j] = ' ';
			}

			if(i == keyword1.length()-1){
				i = -1;
				j++;
				if(j == rows)break;
			}
		}
		//liest die Tabelle aus, in einer gewissen Reihenfolge der Spalten
		String geheimalphabet = "";//diese Variable speichert sich Geheimalphabet
		for(int i = 0; i<keyword1.length(); i++){
			for(int j = 0; j<rows; j++){
				geheimalphabet += table[keyword1.indexOf(liste.get(i+1)+"")][j];//nimmt die Buchstaben von Zeile zu Zeile und speichert es in das Attribut wo das Geheimalphabet gespeichert wird
			}
		}
		return geheimalphabet;
	}

	/**
	 * Diese Klasse erstellt anhand des Schl�sselworts das Geheimalphabet welches in einer Tabelle generiert wird
	 * @param keyword das Schl�sselwort welches f�r die Verschl�sselung zust�ndig ist
	 */
	@Override
	public void setKeyword(String keyword) throws BadParamException{
		this.keyword = keyword.toUpperCase();
	}

	public static void main(String[] args) throws BadParamException{
		KeywordCipher k = new KeywordCipher("ADLER");
		System.out.println(k.encrypt("BUY SOME MILK AND EGGS"));
		System.out.println(k.decrypt(k.encrypt("BUY SOME MILK AND EGGS")));
	}
}

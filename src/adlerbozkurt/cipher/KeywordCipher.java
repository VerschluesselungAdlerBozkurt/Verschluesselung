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

	
	
	/**
	 * Diese Methode ist eine setter-Methode welche sich das �bergebene Keyword in ein Attribut speichert
	 * damit es dauerhaft abrufbar ist
	 * @param keyword das Keyword welches f�r die entschl�sselung verwendet wird
	 * @throws BadParamException falls �bergebene Parameter nicht die Vorstellungen erf�llt kommt es zu einer Fehlermeldung 
	 */
	public void setKeyword(String keyword) throws BadParamException{
		try{
			if(!(keyword.equals(""))){//falls der Parameter nicht leer ist
				this.keyword = keyword.toUpperCase();//das Keyword wird in gro�buchstaben umgewandelt
			}else{//falls der Parameter leer ist kommt es zu einer Fehlermeldung
				throw new BadParamException("Der �bergebene Parameter ist leer"+
						"\n"+"Bitte geben Sie das Keyword erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
			}
		}catch(java.lang.NullPointerException f){//falls der Parameter null ist kommt es zu einer Fehlermeldung
			throw new BadParamException("Der �bergebene Parameter ist null"+
					"\n"+"Bitte geben Sie das Keyword erneuert ein!!!");//wirft eine Exception mit einer benutzerbasierten Meldung
		}
	}
	
	
	
	/**
	 * Diese Methode wird von MonoAlphabeticCipher geerbt welche in dieser Klasse �berschrieben wird
	 * @param text der Text der entschl�sselt werden soll
	 * @return der entschl�sselte Text wird zur�ckgegeben
	 * @throws BadParamException falls �bergebene Parameter nicht die Vorstellungen erf�llt kommt es zu einer Fehlermeldung
	 */
	@Override
	public String decrypt(String text) throws BadParamException {
		String keyword = this.keyword;//das Keyword wird an eine Variable �bertragen
		String keyword1 = this.keyword;//speichern des Schl�sselwortes in einer Zwischenvariabele
		String geheim = text;//das Geheimtext der entschl�sselt werden soll
		int rows;//Zeilen f�r die Tabelle
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

	
	
	/**
	 * Diese Methode wird von MonoAlphabeticCipher geerbt welche in dieser Klasse �berschrieben wird
	 * @param text der Text der verschl�sselt werden soll
	 * @return der verschl�sselte Text wird zur�ckgegeben
	 * @throws BadParamException falls �bergebene Parameter nicht die Vorstellungen erf�llt kommt es zu einer Fehlermeldung
	 */
	@Override
	public String encrypt(String text) throws BadParamException {
		String keyword = this.keyword;
		String keyword1 = this.keyword;//speichern des Schl�sselwortes in einer Zwischenvariabele
		String geheim = text;//das Geheimtext
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
}
package adlerbozkurt.gui;

import adlerbozkurt.cipher.BadParamException;


/**
 * Diese Klasse startet denn Controller welche die GUI für Cipher startet
 * @author Philipp Adler
 * @version 06-05-2014
 */


public class StartCipher {
	public static void main(String[] args) throws BadParamException{
		CipherController c = new CipherController();
	}
}

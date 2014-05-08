package adlerbozkurt.gui;

import java.awt.event.*;
import javax.swing.JTextArea;
import adlerbozkurt.cipher.*;


/**
 * Diese Klasse stellt den Controller der GUI dar, also er enthält alle Listener für die GUI Elemente
 * @author Philipp Adler
 * @version 06-05-2014
 */


public class CipherController implements ActionListener{
	private MonoAlphabeticCipher m;
	private CipherGui g;
	public CipherController() throws BadParamException{
		this.g = new CipherGui(this);
	}

	/**
	 * Diese Methode ist der ActionListener welcher z.B beim drücken des Buttons ausgelöst wird
	 * @param e das Event welches beim Drücken es Button erzeugt wird.
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		JTextArea[] felder = this.g.textfelder();
		if(e.getActionCommand().equals("encrypt")){//beim drücken des encrypt Button von MonoalphabetcCipher
			try {
				this.m = new SubstitutionCipher(this.g.getGeheimalphabet());//erzeugt SubstitutionCipher Objekt
				this.g.setGeheimalphabetbeschrieftung(this.m.getSecretAlphabet());
				felder[1].setText(this.m.encrypt(felder[0].getText()));//verschlüsselt den Text und übergibt es der TextArea
			} catch (BadParamException e1) {
				try {
					this.m = new SubstitutionCipher(this.g.getGeheimalphabetbeschrieftung());
					felder[1].setText(this.m.encrypt(felder[0].getText()));//verschlüsselt den Text und übergibt es der TextArea
				} catch (BadParamException e2) {
				}
			}
		}

		if(e.getActionCommand().equals("decrypt")){
			try {
				this.m = new SubstitutionCipher(this.g.getGeheimalphabet());//erzeugt SubstitutionCipher Objekt
				this.g.setGeheimalphabetbeschrieftung(this.m.getSecretAlphabet());
				felder[1].setText(this.m.decrypt(felder[0].getText()));//entschlüsselt den Text und übergibt es der TextArea
			} catch (BadParamException e1) {
				try {
					this.m = new SubstitutionCipher(this.g.getGeheimalphabetbeschrieftung());
					felder[1].setText(this.m.decrypt(felder[0].getText()));//entschlüsselt den Text und übergibt es der TextArea
				} catch (BadParamException e2) {
				}
			}
		}


		if(e.getActionCommand().equals("encrypt1")){
			try {
				this.m = new KeywordCipher(this.g.getKeyword());//erzeugt KeywordCipher Objekt
				felder[3].setText(this.m.encrypt(felder[2].getText()));//verschlüsselt den Text und übergibt es der TextArea
			} catch (BadParamException e1) {

			}
		}
		if(e.getActionCommand().equals("decrypt1")){
			try {
				this.m = new KeywordCipher(this.g.getKeyword());//erzeugt KeywordCipher Objekt
				felder[3].setText(this.m.decrypt(felder[2].getText()));//entschlüsselt den Text und übergibt es der TextArea
			} catch (BadParamException e1) {
			}
		}
		this.g.settextfelder(felder);
	}
}

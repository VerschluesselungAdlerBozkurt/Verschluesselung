package adlerbozkurt.gui;

import java.awt.event.*;
import adlerbozkurt.cipher.*;

public class CipherController implements ActionListener{
	private MonoAlphabeticCipher[] m;
	private CipherGui g;
	public CipherController() throws BadParamException{
		this.m = new MonoAlphabeticCipher[3];
		this.m[0] = new SubstitutionCipher("QWERTZUßIOPÜÄÖLKJHGFDSAYXCVBNM");
		this.m[1] = new KeywordCipher("");
		this.m[2] = new ShiftCipher(0);
		this.g = new CipherGui(this,this.m);
	}


	@Override
	public void actionPerformed(ActionEvent e){
		try {
			this.m[2].setSecretAlphabet(this.m[0].getSecretAlphabet());
			this.m[2].setShiftAmount(this.g.getValue());
			this.m[0].setSecretAlphabet(this.m[2].getSecretAlphabet());
			this.g.setGeheim(this.m[2].getSecretAlphabet());
		} catch (BadParamException e2) {
			e2.printStackTrace();
		}
		if(e.getActionCommand().equals("encrypt")){
			try {
				this.g.ausgeben(this.m[0].encrypt(this.g.eingabe()));
			} catch (BadParamException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("decrypt")){
			try {
				this.g.ausgeben(this.m[0].decrypt(this.g.eingabe()));
			} catch (BadParamException e1) {
				e1.printStackTrace();
			}
		}
		
		
		if(e.getActionCommand().equals("encrypt1")){
			try {
				this.m[1].setKeyword(this.g.getKeyword());
				this.g.ausgeben1(this.m[1].encrypt(this.g.eingabe1()));
			} catch (BadParamException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getActionCommand().equals("decrypt1")){
			try {
				this.g.ausgeben1(this.m[1].decrypt(this.g.eingabe1()));
			} catch (BadParamException e1) {
				e1.printStackTrace();
			}
		}
	}
}

package adlerbozkurt.gui;

import java.awt.*;

import javax.swing.*;

import adlerbozkurt.cipher.BadParamException;
import adlerbozkurt.cipher.KeywordCipher;
import adlerbozkurt.cipher.MonoAlphabeticCipher;
import adlerbozkurt.cipher.SubstitutionCipher;


public class CipherGui extends JFrame{
	private CipherController c;
	private MonoAlphabeticCipher[] m;
	private JTextArea field,field2,field3,field4;
	private JTextField keyword;
	private JLabel geheimalphabet;
	private JComboBox<Integer> value;
	public CipherGui(CipherController c, MonoAlphabeticCipher[] m) throws BadParamException{
		this.c=c;
		this.m=m;
		this.start();//erzeugt mit dieser Methode die Grafik
	}

	public void start() throws BadParamException{
		Font style = new Font("Serif", Font.BOLD, 30);
		Font text = new Font(Font.DIALOG,Font.PLAIN , 20);
		JTabbedPane auswahl=new JTabbedPane();//erzeugt ein JTabbedPane
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		//Überschrift
		JLabel titel = new JLabel("Verschlüsselung Adler & Bozkurt",JLabel.CENTER);
		titel.setFont(style);

		//Button
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1, 2));
		String[] buttonbeschrieftung = {"encrypt","decrypt"};
		JButton[] button = new JButton[buttonbeschrieftung.length];
		for(int i=0;i<button.length;i++){
			button[i] = new JButton(buttonbeschrieftung[i]);
			button[i].setActionCommand(button[i].getText());
			button[i].addActionListener(this.c);
			panel1.add(button[i]);
		}

		//Textarea für die Message die ver- oder entschlüsselt werden soll
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		this.field = new JTextArea(5, 5);
		this.field.setFont(text);
		JLabel beschrieftung = new JLabel("Nachricht:");
		panel2.add(this.field);
		panel2.add(beschrieftung,BorderLayout.NORTH);
		panel2.add(panel1,BorderLayout.SOUTH);


		//Textarea für die Message die ver- oder entschlüsselt werden soll
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		this.field2 = new JTextArea(5, 5);
		field2.setFont(text);
		JLabel beschrieftung2 = new JLabel("Ver- oder Entschüsselte Nachricht");
		panel3.add(this.field2);
		panel3.add(beschrieftung2,BorderLayout.NORTH);
		
		//ShiftCipher
		Integer[] zahlen = new Integer[30];
		for(int i=0; i<zahlen.length; i++){
			zahlen[i] = new Integer(i);
		}
		this.value = new JComboBox<Integer>(zahlen);
		
		//Die Darstellung des Alphabet und dem Geheimalphabet
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(3, 1));
		JLabel alphabet = new JLabel("Normal Alphabet: ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß");
		this.geheimalphabet = new JLabel("Cipher Alphabet:  "+this.m[0].getSecretAlphabet());
		panel4.add(alphabet);
		panel4.add(value);
		panel4.add(geheimalphabet);

		//die 3 Panels hinzufügen
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(3, 1));
		panel5.add(panel2);
		panel5.add(panel4);
		panel5.add(panel3);
		auswahl.add("monoalphabetischen Substition / ShifCipher",panel5);










		//nächstes Fenster für KeywordCipher

		//Textfeld für das Keyword + Beschrieftung
		JPanel panel6 = new JPanel();
		panel6.setLayout(new GridLayout(2,1));
		JLabel key = new JLabel("Keyword:");
		this.keyword = new JTextField();
		panel6.add(key);
		panel6.add(keyword);

		//Button
		JPanel panel10 = new JPanel();
		panel10.setLayout(new GridLayout(1, 2));
		String[] buttonbeschrieftung1 = {"encrypt","decrypt"};
		JButton[] button1 = new JButton[buttonbeschrieftung1.length];
		for(int i=0;i<button.length;i++){
			button1[i] = new JButton(buttonbeschrieftung1[i]);
			button1[i].setActionCommand(button1[i].getText()+"1");
			button1[i].addActionListener(this.c);
			panel10.add(button1[i]);
		}
		//Textarea für die Message die ver- oder entschlüsselt werden soll
		JPanel panel7 = new JPanel();
		panel7.setLayout(new BorderLayout());
		this.field3 = new JTextArea(5, 5);
		this.field3.setFont(text);
		JLabel beschrieftung3 = new JLabel("Nachricht:");
		panel7.add(this.field3);
		panel7.add(beschrieftung3,BorderLayout.NORTH);
		panel7.add(panel10,BorderLayout.SOUTH);


		//Textarea für die Message die ver- oder entschlüsselt werden soll
		JPanel panel8 = new JPanel();
		panel8.setLayout(new BorderLayout());
		this.field4 = new JTextArea(5, 5);
		field4.setFont(text);
		JLabel beschrieftung4 = new JLabel("Ver- oder Entschüsselte Nachricht");
		panel8.add(this.field4);
		panel8.add(beschrieftung4,BorderLayout.NORTH);


		//die 3 Panels hinzufügen
		JPanel panel9 = new JPanel();
		panel9.setLayout(new GridLayout(3, 1));
		panel9.add(panel7);
		panel9.add(panel6);
		panel9.add(panel8);
		auswahl.add("KeywordCipher",panel9);

		//Elemente hinzufügen
		panel.add(titel,BorderLayout.NORTH);
		panel.add(auswahl);

		this.add(panel);
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocation(400,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public String eingabe(){
		return this.field.getText();
	}

	public void ausgeben(String text){
		this.field2.setText(text);
	}
	
	public String eingabe1(){
		return this.field3.getText();
	}

	public void ausgeben1(String text){
		this.field4.setText(text);
	}
	
	public String getKeyword(){
		return this.keyword.getText();
	}
	
	public int getValue(){
		return this.value.getSelectedIndex();
	}
	
	public void setGeheim(String text){
		this.geheimalphabet.setText("Cipher Alphabet:  "+text);
	}
}

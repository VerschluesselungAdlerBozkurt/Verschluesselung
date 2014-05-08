package adlerbozkurt.gui;

import java.awt.*;

import javax.swing.*;

import adlerbozkurt.cipher.BadParamException;
import adlerbozkurt.cipher.KeywordCipher;
import adlerbozkurt.cipher.MonoAlphabeticCipher;
import adlerbozkurt.cipher.SubstitutionCipher;

/**
 * Diese Klasse stellt die GUI dar welche die einzelnen Cipher Methoden testet
 * @author Philipp Adler
 * @version 06-05-2014
 */
public class CipherGui extends JFrame{
	private CipherController c;
	private JTextArea[] felder;//für Eingabe und Ausgabe des ver- oder entschlüsselten Text
	private JTextField keyword,geheim;//Hier wird das Keyword oder das Geheimalphabet eingegeben
	private JLabel geheimalphabet;//Beschriefung des Geheimalphabets
	private JComboBox<Integer> value;//für ShiftCipher um das Alphabet zu verschieben
	
	
	/**
	 * Diese Konstruktor speichert sich den Controller in ein Attribut für die Listener und führ die start Methode aus
	 * welche die GUI erzeugt
	 * @param c der Controller in dem sich die Listener für die Button befinden
	 */
	public CipherGui(CipherController c){
		this.c=c;
		this.start();//erzeugt mit dieser Methode die Grafik
	}

	
	
	/**
	 * Diese Methode erzeugt die GUI für Benutzer um die Funktion der Cipher zu testen
	 */
	public void start(){
		Font style = new Font("Serif", Font.BOLD, 30);
		Font text = new Font(Font.DIALOG,Font.PLAIN , 20);
		JTabbedPane auswahl=new JTabbedPane();//erzeugt ein JTabbedPane
		JPanel[] panels = new JPanel[11];
		for(int i = 0; i<panels.length; i++){
			panels[i] = new JPanel();
		}
		panels[0].setLayout(new BorderLayout());

		String[] beschrieftungstext = {"Verschlüsselung Adler & Bozkurt","Nachricht:","Ver- oder Entschüsselte Nachricht",
				"Normal Alphabet: ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜß","Keyword:","Nachricht:","Ver- oder Entschüsselte Nachricht"};
		JLabel[] beschrieftungen = new JLabel[7];
		for(int i = 0; i<beschrieftungen.length; i++){
			beschrieftungen[i] = new JLabel(beschrieftungstext[i]);
		}

		this.felder = new JTextArea[4];
		for(int i = 0; i<felder.length; i++){
			this.felder[i] = new JTextArea(5, 5);
			this.felder[i].setFont(text);
		}

		//Überschrift
		beschrieftungen[0].setFont(style);
		beschrieftungen[0].setHorizontalAlignment(JLabel.CENTER);

		//Button
		panels[1].setLayout(new GridLayout(1, 2));
		panels[10].setLayout(new GridLayout(1, 2));
		String[] buttonbeschrieftung = {"encrypt","decrypt","encrypt","decrypt"};
		JButton[] button = new JButton[buttonbeschrieftung.length];
		for(int i=0;i<button.length;i++){
			button[i] = new JButton(buttonbeschrieftung[i]);
			button[i].addActionListener(this.c);
			if(i >= 2 && i <=3){
				button[i].setActionCommand(button[i].getText()+"1");
				panels[10].add(button[i]);
			}else{
				button[i].setActionCommand(button[i].getText());
				panels[1].add(button[i]);
			}
		}
		
		//Textarea für die Message die ver- oder entschlüsselt werden soll
		panels[2].setLayout(new BorderLayout());
		panels[2].add(this.felder[0]);
		panels[2].add(beschrieftungen[1],BorderLayout.NORTH);
		panels[2].add(panels[1],BorderLayout.SOUTH);

		//Textarea für die Message die ver- oder entschlüsselt werden soll
		panels[3].setLayout(new BorderLayout());
		panels[3].add(this.felder[1]);
		panels[3].add(beschrieftungen[2],BorderLayout.NORTH);

		//ShiftCipher
		Integer[] zahlen = new Integer[30];
		for(int i=0; i<zahlen.length; i++){
			zahlen[i] = new Integer(i);
		}
		this.value = new JComboBox<Integer>(zahlen);

		//Die Darstellung des Alphabet und dem Geheimalphabet
		panels[4].setLayout(new GridLayout(4, 1));
		this.geheimalphabet = new JLabel("Cipher Alphabet:  ");
		this.geheim = new JTextField(30);
		panels[4].add(beschrieftungen[3]);
		panels[4].add(value);
		panels[4].add(geheimalphabet);
		panels[4].add(this.geheim);

		//die 3 Panels hinzufügen
		panels[5].setLayout(new GridLayout(3, 1));
		panels[5].add(panels[2]);
		panels[5].add(panels[4]);
		panels[5].add(panels[3]);
		auswahl.add("monoalphabetischen Substition / ShifCipher",panels[5]);


		//nächstes Fenster für KeywordCipher
		
		//Textfeld für das Keyword + Beschrieftung
		panels[6].setLayout(new GridLayout(2,1));
		this.keyword = new JTextField();
		panels[6].add(beschrieftungen[4]);
		panels[6].add(keyword);

		//Textarea für die Message die ver- oder entschlüsselt werden soll
		panels[7].setLayout(new BorderLayout());
		panels[7].add(this.felder[2]);
		panels[7].add(beschrieftungen[5],BorderLayout.NORTH);
		panels[7].add(panels[10],BorderLayout.SOUTH);

		//Textarea für die Message die ver- oder entschlüsselt werden soll
		panels[8].setLayout(new BorderLayout());
		panels[8].add(this.felder[3]);
		panels[8].add(beschrieftungen[6],BorderLayout.NORTH);

		//die 3 Panels hinzufügen
		panels[9].setLayout(new GridLayout(3, 1));
		panels[9].add(panels[7]);
		panels[9].add(panels[6]);
		panels[9].add(panels[8]);
		auswahl.add("KeywordCipher",panels[9]);

		
		//Elemente hinzufügen
		panels[0].add(beschrieftungen[0],BorderLayout.NORTH);
		panels[0].add(auswahl);
		this.add(panels[0]);
		this.setVisible(true);
		this.setSize(500,500);
		this.setLocation(400,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	
	/**
	 * Diese Methode gibt alle Textfelder also Eingabe- und Ausgabefelder zurück
	 * @return die Textfelder wo der Benutzer seine Eingaben betätigt hat
	 * @author Philipp Adler
	 */
	public JTextArea[] textfelder(){
		return this.felder;
	}
	
	
	/**
	 * Diese Methode erzeugt im Ausgabe Textfeld den ver- oder entschlüsselten Text
	 * @param felder die Textfelder welcher bearbeitet werden
	 * @author Philipp Adler
	 */
	public void settextfelder(JTextArea[] felder){
		for(int i = 0; i<felder.length; i++){
			if((i+2) % 2 == 1){
				this.felder[i].setText(felder[i].getText());
			}
		}
	}

	
	/**
	 * Diese Methode gibt das Keyword des Benutzers welche für die ver- oder entschlüsselung verwendet wird zurück
	 * @return das eingegeben Keyword
	 * @author Philipp Adler
	 */
	public String getKeyword(){
		return this.keyword.getText();
	}

	
	/**
	 * Diese Methode gibt das ShiftValue des Benutzers welche für die ver- oder entschlüsselung verwendet wird zurück
	 * @return der Value welche das Geheimalphabet um die Anzahl in eine Richtung verschiebt zurück
	 * @author Philipp Adler
	 */
	public int getValue(){
		return this.value.getSelectedIndex();
	}

	
	/**
	 * Diese Methode gibt das Geheimalphabet zurück
	 * @return ausgabe des Geheimalphabets
	 * @author Philipp Adler
	 */
	public String getGeheimalphabet(){
		return this.geheim.getText();
	}
	
	
	/**
	 * Diese Methode ändert das aktuelle Geheimalphabet
	 * @param text das neue Geheimalphabet welches das alte ersetzen soll
	 * @author Philipp Adler
	 */
	public void setGeheimalphabetbeschrieftung(String text){
		this.geheimalphabet.setText("Cipher Alphabet:  "+text);
	}
	
	
	/**
	 * Diese Methode gibt den das Geheimalphabet von der Beschrieftung zurück
	 * @return ausgabe des Geheimalphabets
	 * @author Philipp Adler
	 */
	public String getGeheimalphabetbeschrieftung(){
		return this.geheimalphabet.getText().replaceAll("Cipher Alphabet:  ", "");
	}
}

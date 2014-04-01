package adler.cipher;

public class MonoAlphabeticCipher implements Cipher{
	private String secretAlphabet;
	
	public MonoAlphabeticCipher(){
		this.secretAlphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
	}
	
	public String getSecretAlphabet(){
		return this.secretAlphabet;
	}
	
	protected void setSecretAlphabt(String secretAlphabet){
		this.secretAlphabet = secretAlphabet;
	}

	@Override
	public String encrypt(String text) {
		String verschluesselt = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		for(int i = 0; i < this.secretAlphabet.length(); i++){
			for(int j = 0; j < text.length(); j++){
				if(alphabet.charAt(i) == text.charAt(j)){
					verschluesselt += this.secretAlphabet.charAt(i);
				}
			}
		}
		return verschluesselt;
	}

	@Override
	public String decrypt(String text) {
		String entschluesselt = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyzäöüß";
		for(int i = 0; i < this.secretAlphabet.length(); i++){
			for(int j = 0; j < text.length(); j++){
				if(this.secretAlphabet.charAt(i) == text.charAt(j)){
					entschluesselt += alphabet.charAt(i);
				}
			}
		}
		return entschluesselt;
	}
	
	public static void main (String[] args){
		MonoAlphabeticCipher a = new MonoAlphabeticCipher();
		a.setSecretAlphabt("uflpwdrasjmconqybvtexhzkgiößüä");
		String verschluesselt = a.encrypt("abc");
		System.out.println("Verschlüsselt: "+verschluesselt);
		System.out.println("Entschlüsselt: "+a.decrypt(verschluesselt));
	}
}

import java.util.HashMap;

/**
 * 
 * @author Marjana Karzek
 * 
 * This class represents the Decoder for the Morse Code.
 *
 */
public class Decoder {
	private String ciphertext;
	private char dot;
	private char dash;
	private char charEnd;
	private String wordEnd;
	private HashMap<String,String> alphabet;
		
	/**
	 * 
	 * @param ciphertext
	 * @param dot
	 * @param dash
	 * @param charEnd
	 * @param wordEnd
	 */
	public Decoder(String ciphertext, char dot, char dash, char charEnd, String wordEnd){
		this.ciphertext=ciphertext;
		this.dot=dot;
		this.dash=dash;
		this.charEnd=charEnd;
		this.wordEnd=wordEnd;
		alphabet = new HashMap<String,String>();
		fillAlphabet();
	}
		
	/**
	 * This method fills the Alphabet.
	 */
	private void fillAlphabet(){
		alphabet.put(""+dot+dash, "A");
		alphabet.put(""+dash+dot+dot+dot, "B");
		alphabet.put(""+dash+dot+dash+dot, "C");
		alphabet.put(""+dash+dot+dot, "D");
		alphabet.put(""+dot, "E");
		alphabet.put(""+dot+dot+dash+dot, "F");
		alphabet.put(""+dash+dash+dot, "G");
		alphabet.put(""+dot+dot+dot+dot, "H");
		alphabet.put(""+dot+dot, "I");
		alphabet.put(""+dot+dash+dash+dash, "J");
		alphabet.put(""+dash+dot+dash, "K");
		alphabet.put(""+dot+dash+dot+dot, "L");
		alphabet.put(""+dash+dash, "M");
		alphabet.put(""+dash+dot, "N");
		alphabet.put(""+dash+dash+dash, "O");
		alphabet.put(""+dot+dash+dash+dot, "P");
		alphabet.put(""+dash+dash+dot+dash, "Q");
		alphabet.put(""+dot+dash+dot, "R");
		alphabet.put(""+dot+dot+dot, "S");
		alphabet.put(""+dash, "T");
		alphabet.put(""+dot+dot+dash, "U");
		alphabet.put(""+dot+dot+dot+dash, "V");
		alphabet.put(""+dot+dash+dash, "W");
		alphabet.put(""+dash+dot+dot+dash, "X");
		alphabet.put(""+dash+dot+dash+dash, "Y");
		alphabet.put(""+dash+dash+dot+dot, "Z");
	}
	
	/**
	 * This method decrypts the ciphertext.
	 * 
	 * @return plaintext
	 */
	public String decodeCiphertext(){
		String plaintext="";
		String letter="";
		for(int i=0;i<ciphertext.length();i++){
			if(ciphertext.charAt(i)!= ' '){
				letter += ciphertext.charAt(i);
			}
			else{
				if(letter.length()<=0){
					plaintext += " ";
					i++;
				}
				else
					plaintext += alphabet.get(letter);	
				letter="";
			}
		}
		return plaintext;
	}
}

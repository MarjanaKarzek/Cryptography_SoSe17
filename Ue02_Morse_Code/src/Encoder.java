import java.util.HashMap;

/**
 * 
 * @author Marjana Karzek
 * 
 * This class represents the Encoder for the Morse Code.
 *
 */
public class Encoder {
	private String plaintext;
	private char dot;
	private char dash;
	private char charEnd;
	private String wordEnd;
	private HashMap<String,String> alphabet;
	
	/**
	 * 
	 * @param plaintext
	 * @param dot
	 * @param dash
	 * @param charEnd
	 * @param wordEnd
	 */
	public Encoder(String plaintext, char dot, char dash, char charEnd, String wordEnd){
		this.plaintext=plaintext;
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
		alphabet.put("A", ""+dot+dash+charEnd);
		alphabet.put("B", ""+dash+dot+dot+dot+charEnd);
		alphabet.put("C", ""+dash+dot+dash+dot+charEnd);
		alphabet.put("D", ""+dash+dot+dot+charEnd);
		alphabet.put("E", ""+dot+charEnd);
		alphabet.put("F", ""+dot+dot+dash+dot+charEnd);
		alphabet.put("G", ""+dash+dash+dot+charEnd);
		alphabet.put("H", ""+dot+dot+dot+dot+charEnd);
		alphabet.put("I", ""+dot+dot+charEnd);
		alphabet.put("J", ""+dot+dash+dash+dash+charEnd);
		alphabet.put("K", ""+dash+dot+dash+charEnd);
		alphabet.put("L", ""+dot+dash+dot+dot+charEnd);
		alphabet.put("M", ""+dash+dash+charEnd);
		alphabet.put("N", ""+dash+dot+charEnd);
		alphabet.put("O", ""+dash+dash+dash+charEnd);
		alphabet.put("P", ""+dot+dash+dash+dot+charEnd);
		alphabet.put("Q", ""+dash+dash+dot+dash+charEnd);
		alphabet.put("R", ""+dot+dash+dot+charEnd);
		alphabet.put("S", ""+dot+dot+dot+charEnd);
		alphabet.put("T", ""+dash+charEnd);
		alphabet.put("U", ""+dot+dot+dash+charEnd);
		alphabet.put("V", ""+dot+dot+dot+dash+charEnd);
		alphabet.put("W", ""+dot+dash+dash+charEnd);
		alphabet.put("X", ""+dash+dot+dot+dash+charEnd);
		alphabet.put("Y", ""+dash+dot+dash+dash+charEnd);
		alphabet.put("Z", ""+dash+dash+dot+dot+charEnd);
		alphabet.put(" ", ""+wordEnd);
	}
	
	/**
	 * This method encrypts the plaintext.
	 * 
	 * @return ciphertext
	 */
	public String encodePlaintext(){
		String ciphertext="";
		for(int i=0;i<plaintext.length();i++){
			ciphertext += alphabet.get(""+plaintext.charAt(i));		
		}
		return ciphertext;
	}
}

/**
 * 
 * @author Marjana Karzek
 * 
 * The course set up rules for the communication:
 * 		A letter is separated by one blank
 * 		A word is separated by two blanks
 * 		A short signal is represented by a dot
 * 		A long signal is represented by a dash
 *
 */
public class Main {

	public static void main(String[] args) {
		String plaintext = "";
		Encoder encoder = new Encoder(plaintext, '.', '-',' ',"  ");
		System.out.println(encoder.encodePlaintext());
		
		String ciphertext = "";
		Decoder decoder = new Decoder(ciphertext,'.', '-',' ',"  ");
		System.out.println(decoder.decodeCiphertext());
	}
}
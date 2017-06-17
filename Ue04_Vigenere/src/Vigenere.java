import java.util.Random;

/**
 * 
 * @author Marjana Karzek
 * 
 * This class provides the functionality to encrypt and decrypt Vigenere ciphers.
 *
 */
public class Vigenere {
	private final int blockSize = 5;
	private Random random = new Random();

	public String encode(String key, String plainText) {
		int[] keyValues = keyToArray(key);
		String cipherText = "";
		plainText = plainText.replaceAll(" ", "");
		if (plainText.length() % blockSize != 0) {
			int remaining = blockSize - plainText.length() % blockSize;
			for (int i = 0; i < remaining; i++) {
				plainText += (char) (random.nextInt(26) + 65);
			}
		}
		for (int i = 0; i < plainText.length(); i++) {
			int plainCharValue = checkAscii((int) plainText.charAt(i));
			if (plainCharValue < 0)
				return "Plaintext not allowed";

			int cipherCharValue = (plainCharValue + keyValues[i % key.length()]) % 26 + 65;
			cipherText += (char) cipherCharValue;
			if ((i % blockSize) == (blockSize - 1))
				cipherText += " ";
		}
		return cipherText;
	}

	public String decode(String key, String cipherText) {
		int[] keyValues = keyToArray(key);
		String plainText = "";
		cipherText = cipherText.replaceAll(" ", "");
		for (int i = 0; i < cipherText.length(); i++) {
			int cipherCharValue = checkAscii((int) cipherText.charAt(i));
			if (cipherCharValue < 0)
				return "Plaintext not allowed";
			int plainCharValue = (cipherCharValue - keyValues[i % key.length()] + 26) % 26 + 65;
			plainText += (char) plainCharValue;
		}
		return plainText;
	}

	private int[] keyToArray(String key) {
		int[] keyValues = new int[key.length()];
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			int x = (int) c;
			x = checkAscii(x);
			if (x < 0)
				return null;
			keyValues[i] = x;
		}
		return keyValues;
	}

	private int checkAscii(int x) {
		if (65 <= x && x <= 90) {
			return x - 65;
		} else if (97 <= x && x <= 122) {
			return x - 97;
		}
		return -1;
	}
}
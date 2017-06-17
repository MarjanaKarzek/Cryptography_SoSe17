import java.math.BigInteger;

/**
 * 
 * @author Marjana Karzek
 *
 * This class implements two methods to calculate the algorithms modulo n and discreet logarithm.
 * With the methods the runtime can be compared.
 * 
 */
public class Calculator {

	/**
	 * Tests the methods moduloN() and discreetLog().
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//Test - moduloN()
		System.out.println("Test 1: x=2, y=5, n=3");
		System.out.println("Expected Output: 2");
		System.out.println("Actual Output  : " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(5),BigInteger.valueOf(3)));
		System.out.println();

		System.out.println("Test 2: x=2, y=4, n=3");
		System.out.println("Expected Output: 1");
		System.out.println("Actual Output  : " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(4),BigInteger.valueOf(3)));
		System.out.println();

		System.out.println("Test 3: x=2, y=21, n=6");
		System.out.println("Expected Output: 2");
		System.out.println("Actual Output  : " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(21),BigInteger.valueOf(6)));
		System.out.println();
		
		//Test - diskreterLog()
		System.out.println("Test 1: 7^x = 10 mod 31");
		System.out.println("Expected Output: 8");
		System.out.println("Actual Output  : " + discreetLog(BigInteger.valueOf(7),BigInteger.valueOf(10),31));
		System.out.println();
		
		System.out.println("Test 2: 7^x = 8 mod 7");
		System.out.println("Expected Output: 0");
		System.out.println("Actual Output  : " + discreetLog(BigInteger.valueOf(7),BigInteger.valueOf(8),7));
		System.out.println();
		
		//Test Multiplications Modulo n
		System.out.println("y=1: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(1),BigInteger.valueOf(3)));
		System.out.println("y=2: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(2),BigInteger.valueOf(3)));
		System.out.println("y=3: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(3),BigInteger.valueOf(3)));
		System.out.println("y=4: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(4),BigInteger.valueOf(3)));
		System.out.println("y=5: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(5),BigInteger.valueOf(3)));
		System.out.println("y=10: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(10),BigInteger.valueOf(3)));
		System.out.println("y=20: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(20),BigInteger.valueOf(3)));
		System.out.println("y=50: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(100),BigInteger.valueOf(3)));
		System.out.println("y=100: " + moduloN(BigInteger.valueOf(2),BigInteger.valueOf(1000),BigInteger.valueOf(3)));
		
	}

	/**
	 * Method to calculate modulo n.
	 * 
	 * @param x
	 * @param y
	 * @param n
	 * @return
	 */
	private static BigInteger moduloN(BigInteger x, BigInteger y, BigInteger n){
		BigInteger erg = BigInteger.valueOf(1);
		int counterModN=0;
		String binaryString = y.toString(2);
		BigInteger potenz = x;
		for(int i=binaryString.length()-1;i>=0;i--){
			if(binaryString.charAt(i)=='1'){
				erg = erg.multiply(potenz).mod(n);
				counterModN++;
			}
			potenz = potenz.multiply(potenz);
		}	
		//System.out.println("Counter: " + counterModN);
		return erg;
	}
	
	/**
	 * Method to calculate discreet logarithm.
	 * 
	 * @param a
	 * @param b
	 * @param p
	 * @return
	 */
	private static BigInteger discreetLog(BigInteger a, BigInteger b, int p){
		BigInteger x = BigInteger.valueOf(0);
		for(int i=1;i<p;i++){
			if(a.pow(i).mod(BigInteger.valueOf(p)).compareTo(b)==0){
				x = BigInteger.valueOf(i);
				return x;
			}
		}
		return x;
	}
}

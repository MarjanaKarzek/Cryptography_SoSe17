import java.math.BigInteger;

/**
 * 
 * @author Marjana Karzek
 * 
 * This class provides the functionality of a main class.
 *
 */
public class Calculator {
	public static void main(String[] args){
		Calculator x = new Calculator();
		x.calculate(BigInteger.valueOf(612),BigInteger.valueOf(1309),BigInteger.valueOf(3),BigInteger.valueOf(5));
	}

	/**
	 * Calls functions of the extended euclidean algorithm.
	 * 
	 * @param a
	 * @param b
	 * @param p
	 * @param q
	 */
	public void calculate(BigInteger a, BigInteger b, BigInteger p, BigInteger q){
		ExtendedEuclid calculator = new ExtendedEuclid();
		BigInteger[] values = calculator.executeExtendedEuclid(a, b);
		BigInteger z = values[5];
		System.out.println("z = " + z);
		
		BigInteger y = (a.subtract(b)).multiply(z).mod(p);
		System.out.println("y = " + y);
		
		BigInteger x = y.multiply(q).add(b);
		System.out.println("x = " + x);
	}
}

import java.math.BigInteger;
import java.util.Random;

/**
 * 
 * @author Marjana Karzek
 * 
 *         This class implements the Rabin Miller algorithm with appropriate
 *         test cases
 *
 */
public class RabinMiller {
	
	private static Random random = new Random();

	public static void main(String[] args) {

		// test cases with different k
		// k=1
		System.out.println("k=1");
		boolean isPrime = false;
		int primeCounter = 0;
		long timeStart = System.currentTimeMillis();
		for (int i = 5; i < 1000000; i = i + 2) {
			isPrime = calculate(BigInteger.valueOf(i), 1);
			if (isPrime)
				primeCounter++;
		}
		System.out.println(primeCounter);
		long timeEnd = System.currentTimeMillis();
		System.out.println("Time: " + (timeEnd - timeStart) + "ms");
		System.out.println();

		// k=2
		System.out.println("k=2");
		isPrime = false;
		primeCounter = 0;
		timeStart = System.currentTimeMillis();
		for (int i = 5; i < 1000000; i = i + 2) {
			isPrime = calculate(BigInteger.valueOf(i), 1);
			if (isPrime)
				primeCounter++;
		}
		System.out.println(primeCounter);
		timeEnd = System.currentTimeMillis();
		System.out.println("Time: " + (timeEnd - timeStart) + "ms");
		System.out.println();

		// k=3
		System.out.println("k=3");
		isPrime = false;
		primeCounter = 0;
		timeStart = System.currentTimeMillis();
		for (int i = 5; i < 1000000; i = i + 2) {
			isPrime = calculate(BigInteger.valueOf(i), 1);
			if (isPrime)
				primeCounter++;
		}
		System.out.println(primeCounter);
		timeEnd = System.currentTimeMillis();
		System.out.println("Time: " + (timeEnd - timeStart) + "ms");
		System.out.println();

		// k=4
		System.out.println("k=4");
		isPrime = false;
		primeCounter = 0;
		timeStart = System.currentTimeMillis();
		for (int i = 5; i < 1000000; i = i + 2) {
			isPrime = calculate(BigInteger.valueOf(i), 1);
			if (isPrime)
				primeCounter++;
		}
		System.out.println(primeCounter);
		timeEnd = System.currentTimeMillis();
		System.out.println("Time: " + (timeEnd - timeStart) + "ms");
		System.out.println();

		// k=5
		System.out.println("k=5");
		isPrime = false;
		primeCounter = 0;
		timeStart = System.currentTimeMillis();
		for (int i = 5; i < 1000000; i = i + 2) {
			isPrime = calculate(BigInteger.valueOf(i), 1);
			if (isPrime)
				primeCounter++;
		}
		System.out.println(primeCounter);
		timeEnd = System.currentTimeMillis();
		System.out.println("Time: " + (timeEnd - timeStart) + "ms");
		System.out.println();
	}

	/**
	 * Method implements Rabin Miller Algorithm with kMax.
	 * 
	 * @param n
	 * @param kMax
	 * @return
	 */
	public static Boolean calculate(BigInteger n, int kMax) {
		// s = n - 1
		BigInteger s = n.subtract(BigInteger.valueOf(1));
		int t = 0;
		// s % 2 == 0
		while (s.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
			// s = s/2
			s = s.divide(BigInteger.valueOf(2));
			t++;
		}
		int k = 0;
		while (k < kMax) {
			// a = random between 2 and n-1
			// int randomValue = random.nextInt(n.intValue() - 3) + 2;
			BigInteger a = BigInteger.valueOf(random.nextInt(n.intValue() - 3) + 2);
			// v = a ^ s % n
			BigInteger v = a.modPow(s, n);
			// BigInteger v = a.pow(s.intValue()).mod(n);
			// v != 1
			if (!v.equals(BigInteger.valueOf(1))) {
				int i = 0;
				// while v != n-1
				while (!v.equals(n.subtract(BigInteger.valueOf(1)))) {
					if (i == (t - 1)) {
						return false;
					} else {
						// v = v^2 % n
						v = v.modPow(BigInteger.valueOf(2), n);
						// v = v.pow(2).mod(n);
						i++;
					}
				}
			}
			k = k + 2;
		}
		return true;
	}
}

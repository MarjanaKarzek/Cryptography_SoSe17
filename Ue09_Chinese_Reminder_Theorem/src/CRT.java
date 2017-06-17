import java.math.BigInteger;
import java.util.Random;

/**
 * 
 * @author Marjana Karzek
 * 
 * This class implements the chinese reminder theorem.
 *
 */
public class CRT {
	private BigInteger p;
	private BigInteger q;
	private static Random random = new Random();
	public static final BigInteger ONE = BigInteger.valueOf(1);
	
	public CRT(BigInteger p, BigInteger q){
		this.p = p;
		this.q = q;
	}
	
	private int pow(BigInteger basis, BigInteger exponent) {
		int leftExp = exponent.mod(p.subtract(ONE)).intValue();
		int rightExp = exponent.mod(q.subtract(ONE)).intValue();
		BigInteger left = basis.pow(leftExp).mod(p);
		BigInteger right = basis.pow(rightExp).mod(q);
		ExtendedEuclid ee = new ExtendedEuclid();
		BigInteger values[] = ee.executeExtendedEuclid(q, p);
		int z = values[4].intValue();

		int v = (left.intValue()-right.intValue())*z;
		v = v % (p.intValue());
		if(v < 0){
			v += p.intValue();
		}	
		return q.intValue()*v+right.intValue();
	}
	
	public static void main(String[] args) {
		BigInteger p1 = BigInteger.valueOf(101);
		BigInteger q1 = BigInteger.valueOf(103);
		
		long timeStartCRT = System.currentTimeMillis(); 
		CRT crt = new CRT(p1,q1);	
		BigInteger basis = BigInteger.valueOf(500);
		BigInteger exponent = BigInteger.valueOf(3000);
		
		//int randomNumber = random.nextInt((p1.multiply(q1).subtract(BigInteger.valueOf(-3))).intValue())+2;
		//BigInteger basis = BigInteger.valueOf(randomNumber);
		//randomNumber = random.nextInt((p1.multiply(q1).subtract(BigInteger.valueOf(-3))).intValue())+2;
		//BigInteger exponent = BigInteger.valueOf(randomNumber);
		
		//System.out.println(p1.multiply(q1));
		System.out.println("Basis: " + basis);
		System.out.println("Exponent: " + exponent);
		
		int modulareBasis = crt.pow(basis, exponent);
		long timeEndCRT = System.currentTimeMillis();

		//System.out.println(modulareBasis);
		//System.out.println("Time: " + (timeEndCRT - timeStartCRT) + "ms");
		
		long timeStartMOD = System.currentTimeMillis(); 
		System.out.println("Result: " + basis.modPow(exponent, (p1.multiply(q1))));
		long timeEndMOD = System.currentTimeMillis();
		//System.out.println("Time: " + (timeEndMOD - timeStartMOD) + "ms");
	}
}

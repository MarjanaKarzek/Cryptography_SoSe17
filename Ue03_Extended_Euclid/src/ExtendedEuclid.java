import java.math.BigInteger;

/**
 * 
 * @author Marjana Karzek
 * 
 * This class implements the extended euclidean algorithm.
 *
 */
public class ExtendedEuclid{
	private BigInteger[] values;
	private BigInteger[] error;
	
	public ExtendedEuclid(){
		values = new BigInteger[6];
		error = new BigInteger[1];
		error[0] = BigInteger.valueOf(-1);
		resetValues();
	}
	
	/**
	 * Executes the algorithm.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public BigInteger[] executeExtendedEuclid(BigInteger a, BigInteger b){
		resetValues();
		//check input
		if(a.compareTo(BigInteger.valueOf(0))==-1 || b.compareTo(BigInteger.valueOf(0))==-1){
			return error;
		}
		else{
			//check d to become the greater input
			if(a.compareTo(b)==1){
				values[0] = b;
				values[1] = a;
			}
			else{
				values[0] = a;
				values[1] = b;
			}
			return calculateGCD(values);
		}	
	}
	
	/**
	 * Calculates the greatest common divisor.
	 * 
	 * @param values
	 * @return
	 */
	private BigInteger[] calculateGCD(BigInteger[] values){
		if(values[0] == BigInteger.valueOf(0))
			return values;
		else{ 
			BigInteger q = values[1].divide(values[0]);
		
			BigInteger helpC = values[0];
			values[0] = values[1].subtract(q.multiply(values[0]));
			values[1] = helpC;
			
			BigInteger helpUc = values[2];
			BigInteger helpVc = values[3];
			values[2] = values[4].subtract(q.multiply(values[2]));			//uc
			values[3] = values[5].subtract(q.multiply(values[3]));			//vc
			values[4] = helpUc;												//ud
			values[5] = helpVc;												//vd
			
			return calculateGCD(values);
		}
	}
	
	/**
	 * Sets the values of uc, vc, ud and vd back to the startng value.
	 */
	private void resetValues(){
		values[2] = values[5] = BigInteger.valueOf(1);
		values[0] = values[1] = values[3] = values[4] = BigInteger.valueOf(0);
	}
}

package euler;
import util.EulerUtils;
import java.util.List;

public class Problem69 {

	public static void main(String[] args) {
		double largestNumber = 0;
		int nMax = 1;
		int phi;
		
		for(int n = 2; n <= 1000000; n+=nMax){
			if(n % 10000 == 0){
				System.out.println("Reached: n = " + n);
			}
			
			phi = getPhi(n);

			if((double)n /(double)phi > largestNumber){
				nMax = n;
				largestNumber = (double)n/(double)phi;
				System.out.println("New highest: " + nMax);
			}
		}
		
		System.out.println("Highest output was given by n = " + nMax);
		
	}
	
	public static int getPhi(int n){
		int phi = 0;
		List<Integer> primeFactors = EulerUtils.primeFactorsNoDuplicate(n);
		for(int y = 1; y < n; y++){
			boolean isCoprime = true;
			
			for(int primeFactor : primeFactors){
				if(y % primeFactor == 0){
					isCoprime = false;
					break;
				}
			}
			
			if(isCoprime){
				phi++;
			}
		}
		
		return phi;
	}
}

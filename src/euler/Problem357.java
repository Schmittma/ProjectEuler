package euler;

import util.EulerUtils;
import java.util.ArrayList;
import java.util.List;

public class Problem357 {

	public static void main(String[] args) {
		

		int endNum = 1000;
		
		long sumOfAllPositives = 0;
		long startTime = System.currentTimeMillis();
		List<Integer> factors;
		
		long checkpoint = 1000000;
		
		for(int x = 2; x < endNum; x+=4){
			
			//Pre-check with known Divisors
			if(!EulerUtils.isPrime(x+1)){
				continue;
			}
			factors = getAllDivisors(x);
			
			boolean isAPositive = true;
			
			for(int factor : factors){	
				//if(!isPrime((factor + x/factor), primes)){
				if(!EulerUtils.isPrime(factor + x/factor)){
					isAPositive = false;
					break;
				}
			}
			
			if(isAPositive){
				sumOfAllPositives += x;
				System.out.println(x);
			}
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println(sumOfAllPositives);
		System.out.println("Execution time: " + (endTime - startTime) + "ms");
	}
	
    public static List<Integer> getAllDivisors(int number) {
        List<Integer> factors = new ArrayList<Integer>();

        for(int x = 1; x <= (int)Math.sqrt(number); x++){
        	if(number % x == 0){
        		factors.add(x);
        	}
        }
        return factors;
    }
}

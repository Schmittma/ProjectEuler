package euler;

import java.util.List;

import util.EulerUtils;
import util.StopWatch;


/**
 * This solution tries to "smartly" brute force by looping and checking for coprime numbers.
 * 
 * @author deschmm3
 *
 */

/* !!! NOTE: IF YOU FOUND THE SOLUTION, IT SHOULD BE A TRIVIAL TASK TO FIND THE SOLUTION TO P73 !!! */
public class p72 {

	public static void main(String[] args) {
		
		final int D_MAX = 100;
		final boolean PRINT = true;
		long count = 0;
		
		StopWatch sw = new StopWatch();
		sw.start();

		for(int d = 1; d <= D_MAX; d++){
			
			List<Integer> pf = EulerUtils.primeFactorsNoDuplicate(d);
			long maxCop = d-1;
			
			/* 
			 * Subtract the number of times, the prime factor fits into the value
			 * because thats also the number of values below d, that are not coprime to d
			 */
			for(int i = 0; i < pf.size(); i++){
				int v1 = pf.get(i);
				
				maxCop -= ((d/v1) - 1);
			
				/*
				 * For multiple prime factor a value may have been excluded multiple times
				 * Take 50 = 2 * 5 * 5 for example -> 10, 20, 30, aso. 
				 */
				for(int j = i+1; j < pf.size(); j++){
					int v2 = pf.get(j);
					int mul = v1*v2;
					
					maxCop += ((d/mul)-1);
				}	
			}
			count += maxCop;	
		}		
	
		
		if(PRINT) System.out.println(); //TODO Remove print statement
		sw.stop();
		
		System.out.println("Num of Elements: " + count); //TODO Remove print statement
		System.out.println(sw); //TODO Remove print statement
	}
}

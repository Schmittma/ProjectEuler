package euler;

import util.EulerUtils;
import java.util.ArrayList;
import java.util.List;

public class Problem387 {

	public static void main(String[] args) {
		
		long maxNum = (long)Math.pow(10, 13);
		long sum = 0;
		long startTime = System.currentTimeMillis();
		List<List<Long>> truncatableHarshads = new ArrayList<>(); 
		
		for(int exp = 0; exp < Math.log10(maxNum); exp++){
			ArrayList<Long> harshads = new ArrayList<>();
			if(exp == 0){
				for(long x = 1; x < 10; x++) harshads.add(x);
				truncatableHarshads.add(harshads);
				continue;
			}
			
			for(long harshad : truncatableHarshads.get(exp-1)){
				for(int x = 0; x < 10; x++){
					long newProbableHarshad = harshad*10 + x;
					if(isRightTruncatableHarshad(newProbableHarshad)){
						harshads.add(newProbableHarshad);
					}
				}
			}
			truncatableHarshads.add(harshads);
		}	
		
		for(int x = 1; x < truncatableHarshads.size(); x++){
			for(int y = 0; y < truncatableHarshads.get(x).size(); y++){
				long harshad = truncatableHarshads.get(x).get(y);
				
				if(isStrongHarshad(harshad)){
					for(int z = 1; z < 10; z+=2){
						if(EulerUtils.isPrime(harshad*10+z)){
							sum += harshad*10+z;
						}
					}
				}
			}
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("Solution: " + sum);
		System.out.println("Execution time: "  + (endTime - startTime) + "ms");
		
	}
	
	public static boolean isStrongHarshad(long n){
		long temp = n;
		long digitSum = 0;
		while(temp > 0){
			digitSum += (temp%10);
			temp/=10;
		}
		return n % digitSum == 0 && EulerUtils.isPrime(n/digitSum) ;
	}
	
	public static boolean isRightTruncatableHarshad(long n){
		
		long temp = n;
		long digitSum = 0;
		while(temp > 0){
			digitSum+= (temp%10);
			temp/=10;
		}
		
		temp = n;
		
		while(temp > 0){
			
			if(temp % digitSum != 0){
				return false;
			}
			
			digitSum -= (temp%10);
			temp /= 10;
		}

		return true;
	}
}

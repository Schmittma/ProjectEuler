package euler;

import java.util.ArrayList;

import util.EulerUtils;
public class Problem60 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		ArrayList<Integer> primes = EulerUtils.getPrimeNumbers(10000);
		long end = System.currentTimeMillis();
		System.out.println("Time = " + (end - start) + "ms");
		int lowestSum = Integer.MAX_VALUE;
		
		for(int a : primes){
			for(int b : primes){
				if(b < a){
					continue;
				}
				if(!(EulerUtils.isPrime(EulerUtils.concat(a,b)) && 
						EulerUtils.isPrime(EulerUtils.concat(b,a)))){
					continue;
				}
				
				for(int c : primes){
					if(c < b){
						continue;
					}
					if(!(EulerUtils.isPrime(EulerUtils.concat(c,a)) && 
							EulerUtils.isPrime(EulerUtils.concat(a,c)) &&
							EulerUtils.isPrime(EulerUtils.concat(c,b)) &&
							EulerUtils.isPrime(EulerUtils.concat(b,c)))){
						continue;
					}
					
					for(int d : primes){
						if(d < c){
							continue;
						}
						if(!(EulerUtils.isPrime(EulerUtils.concat(d,a)) && 
								EulerUtils.isPrime(EulerUtils.concat(a,d)) &&
								EulerUtils.isPrime(EulerUtils.concat(d,b)) &&
								EulerUtils.isPrime(EulerUtils.concat(b,d)) &&
								EulerUtils.isPrime(EulerUtils.concat(d,c)) &&
								EulerUtils.isPrime(EulerUtils.concat(c,d)))){
							continue;
						}
						
						for(int e : primes){
							if(e < d){
								continue;
							}
							if(!(EulerUtils.isPrime(EulerUtils.concat(e,a)) && 
									EulerUtils.isPrime(EulerUtils.concat(a,e)) &&
									EulerUtils.isPrime(EulerUtils.concat(e,b)) &&
									EulerUtils.isPrime(EulerUtils.concat(b,e)) &&
									EulerUtils.isPrime(EulerUtils.concat(e,c)) &&
									EulerUtils.isPrime(EulerUtils.concat(c,e)) &&
									EulerUtils.isPrime(EulerUtils.concat(e,d)) &&
									EulerUtils.isPrime(EulerUtils.concat(d,e)))){
								continue;
							}
							lowestSum = Integer.min(lowestSum, a+b+c+d+e);
							
						}
					}
				}
			}
		}
	
		System.out.println(lowestSum);
		
	}
	
	
}

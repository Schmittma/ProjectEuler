package util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EulerUtils {
	
	public static int sum(List<Integer> values){
		int sum = 0;
		for(int i : values){
			sum += i;
		}
		return sum;
	}
	
	//This function will return a list of prime integers smaller or equal to n
	public static ArrayList<Integer> getPrimeNumbers(int n){
		if(n < 2){
			return new ArrayList<Integer>();
		}
		
		boolean[] markers = new boolean[n+1];
		Arrays.fill(markers, true);
		markers[0] = false;
		markers[1] = false;
		
		for(int x = 2; x <= n; x++){
			if(markers[x] == true){
				for(int factor = 2; x*factor >= 0 && x*factor <= n; factor++){
					markers[factor*x] = false;
				}
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<>();
		
		for(int x = 0; x < markers.length; x++){
			if(markers[x] == true){
				primes.add(x);
			}
		}
		return primes;
	}
	
	public static boolean isPrime(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
	
	public static long concat(int a, int b){
		return (long) (a*Math.pow(10, ((int)Math.log10(b)+1)) + b);
	}
	
	public static int GCD(int a, int b) {
	   if (b==0) return a;
	   return GCD(b,a%b);
	}
	
	public static boolean isCoprime(int a, int b){
		return GCD(a,b) == 1;
	}
	
    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
    
    public static List<Integer> primeFactorsNoDuplicate(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n / i; i++) {
        	boolean isAllreadyIn = false;
            while (n % i == 0) {
            	if(!isAllreadyIn){
            		factors.add(i);
            		isAllreadyIn = true;
            	}
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
    
    public static int getNumberOfPartitions(int n){
    	return getNumberOfPartitions(n,n);
    }
    
    /* n is the number to be partitioned
     * 
     * k is the maximum number of parts the partition may have
     * 
     * Note: Getting all partitions requires k to be equal to n 
     */
    public static int getNumberOfPartitions(int n, int k){
    	
    	if(n == 0){
    		return 1;
    	}
    	if(k == 1){
    		return 1;
    	}
    	if(k > n){
    		return getNumberOfPartitions(n,n);
    	}

    	
    	return getNumberOfPartitions(n,k-1) + getNumberOfPartitions(n-k,k);
    }
    
    public static List<Integer> getAllDivisors(int number) {
        List<Integer> factors = new ArrayList<Integer>();

        for(int x = 1; x <= (int)Math.sqrt(number); x++){
        	if(number % x == 0){
        		factors.add(x);
        	}
        }
        
        List<Integer> reverseFactors = new ArrayList<Integer>();
        for(int x = factors.size() - 1; x >= 0; x--){
        	reverseFactors.add(number / factors.get(x));
        }
   
        factors.addAll(reverseFactors);
        return factors;
    }
    
	/* 
	 * Based on: https://www.geeksforgeeks.org/farey-sequence/ 
	 * 
	 * TODO: If needed, make a separate function that can return all those values
	 */
	public static long farey_count(int n) 
	{ 
	    long count;
		
		// We know first two terms are 0/1 and 1/n 
	    double x1 = 0, y1 = 1, x2 = 1, y2 = n; 
	    count = 2;
	    
	    double x, y = 0; // For next terms to be evaluated 
	    while (y != 1.0)  
	    { 
	        // Using recurrence relation to find the next term 
	        x = Math.floor((y1 + n) / y2) * x2 - x1; 
	        y = Math.floor((y1 + n) / y2) * y2 - y1; 
	 
	        count++;
	  
	        // Update x1, y1, x2 and y2 for next iteration 
	        x1 = x2; 
	        x2 = x; 
	        y1 = y2; 
	        y2 = y; 
	    } 
	    
	    return count;
	} 
	
	public static List<Integer> getDigitsOfNumber(int number){
		List<Integer> digits = new ArrayList<>();
		while(number > 0){
			digits.add(number%10);
			number/=10;
		}
		return digits;
	}
	
	public static int getFactorialDigitSum(int n){
		List<Integer> digits = getDigitsOfNumber(n);
		int sum = 0;
		
		for(int digit : digits){ 
			sum += EulerConstants.FACTORIAL[digit];
		}
		
		return sum;
	}
	
	/*
	 * Returns the i-th fibonacci number
	 * 
	 * Note: f0 is defined as 0 and f1 is defined as 1 thus f2 is also 1
	 * Note: If you need performance, you may want to calculate those inside your own loop because this function has to recalculate everytime
	 */
	public static long getFibonacciNumber(int i){
		
		if(i == 0 || i <= 0){
			return 0;
		}
		if(i == 1){
			return 1;
		}
		
		long f0 = 0;
		long f1 = 1;
		
		long retVal = 0;
		
		long prev = f1;
		long prev_prev = f0;
		long fx; 
		
		for(int x = 2; x <= i; x++){
			fx = prev + prev_prev;
			prev_prev = prev;
			prev = fx;
			
			if(x == i){
				retVal = fx;
			}
		}
		
		return retVal;
	}
}

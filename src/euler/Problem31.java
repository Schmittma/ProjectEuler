package euler;

public class Problem31 {
	
	static final int[] coins = {1,2,5,10,20,50,100,200};
	
	public static void main(String[] args) {
		
		int n = 200;
		int k = coins.length-1;
		//Produces either 3 to much or 30 to less.... :( 
		//The general idea seems to hold tho, seems to have some kind of problems with the return conditions
		System.out.println(getNumberOfPartitions(n,k));
	}
	
	 public static int getNumberOfPartitions(int n, int k){
	    	
	    	if(n <= 1){
	    		return 1;
	    	}
	    	if(k == 0){
	    		return 1;
	    	}
	    	
	    	if(coins[k] > n){
	    		return getNumberOfPartitions(n-1,k);
	    	}
	    	
	    	return getNumberOfPartitions(n,k-1) + getNumberOfPartitions(n-coins[k],k);
	    }
}

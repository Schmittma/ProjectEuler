package euler;

public class p17 {

	final static int[] ONES = {3,3,5,4,4,3,5,5,4};
	final static int TEN = 3;
	final static int HUNDRED = 7;
	final static int[] FIRST_TENS = {6,6,8,8,7,7,9,8,8};
	final static int[] ALL_OTHER_TENS = {0,4,4,3,3,3,5,4,4};
	final static int AND = 3;
	final static int TY = 2;
	final static int THOUSAND = 8;
	
	public static void main(String[] args) {
		int lettersum = 0;
		for(int x = 1; x <= 1000; x++){
			lettersum += getNumberOfLetters(x);
		}
		System.out.println(lettersum);
	}
	
	public static int getNumberOfLetters(int n){
		int count = 0;
		if(n >= 1000){
			count += ONES[((n/1000)%10)-1] + THOUSAND;
			n -= (n/1000) * 1000;
		}
		
		if(n >= 100){
			count += ONES[((n/100)%10)-1] + HUNDRED;
			n -= (n/100) * 100;
			if(n > 0){
				count += AND;
			}
		}
		
		if(n >= 20){
			count += ALL_OTHER_TENS[((n/10)%10)-1] + TY;
			n -= (n/10) * 10;
		}
		else if(n > 10){
			count += FIRST_TENS[n-10-1];
			n = 0;
		}
		else if(n == 10){
			count += TEN;
			n -= 10;
		}
		
		if(n > 0){
			count += ONES[n-1];
		}
		
		return count;
	}
}

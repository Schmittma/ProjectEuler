package euler;

public class p92 {

	public static void main(String[] args) {
		int border = 10000000;
		int count = 0;
		
		for(int x = 1; x < border; x++){
			if(getChainNumber(x) == 89){
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static int getChainNumber(int chainNumber){
		while(true){
			if(chainNumber == 89){
				return 89;
			}
			if(chainNumber == 1){
				return 1;
			}
			
			int newNumber = 0;
			while(chainNumber > 0){
				newNumber += Math.pow(chainNumber%10, 2);
				chainNumber /= 10;
			}
			chainNumber = newNumber;
		}
	}
}

package euler;

public class Problem206 {

	public static void main(String[] args) {
		long lowest =  1020304050607080900L;
		long largest = 1929394959697989990L;
		
		for(long x = (long) Math.sqrt(lowest); x < (long) Math.sqrt(largest); x++){
			long square = x*x;

			if(square % 10 != 0){
				continue;
			}
			square /= 100;
			
			for(int digit = 9; digit > 0; digit--){
				if(square % 10 == digit){
					square /= 100;
					if(digit == 1){
						System.out.println(x);
						System.exit(0);
					}
				}
				else{
					break;
				}
			}
		}
	}
}

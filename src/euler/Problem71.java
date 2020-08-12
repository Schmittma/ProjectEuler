package euler;
import util.EulerUtils;
public class Problem71 {

	public static void main(String[] args) {
		int[] closestFraction = new int[2];
		double leastDifference = 1; 
		int maxnum = 1000000;
		double targetFraction = 3.0/7.0;
		
		
		for(int denominator = maxnum; denominator > 0; denominator--){
			if(denominator % 10000 == 0){
				System.out.println("Denom: " + denominator);
			}
			
			for(int numerator = 1; numerator < denominator; numerator++){
				
				double currentDif =  targetFraction - ((double)numerator / (double)denominator);
				
				if( currentDif > 0 										//On the left site of 3/7
					&& currentDif < leastDifference						//New smallest
					&& !(denominator == 7 && numerator == 3)			//Not 3/7
					&& EulerUtils.GCD(numerator, denominator) == 1){	//Proper Reduced faction

					System.out.println("New closest to 3/7: " + numerator + "/" + denominator);
					closestFraction[0] = numerator;
					closestFraction[1] = denominator;
					leastDifference = currentDif;
				}
				

				

			}
		}
		
		System.out.println(closestFraction[0] + "/" + closestFraction[1]);
		
	}
}

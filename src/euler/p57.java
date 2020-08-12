package euler;

import java.math.BigInteger;

public class Problem57 {

	// Zähler(x+1) = Zähler(x)*2 + Zähler(x-1)
	// Nenner(x+1) = Nenner(x) + Zähler(x)
	
	
	public static void main(String[] args) {
		int expansions = 1000;
		BigInteger currentNum = new BigInteger("7");
		BigInteger currentDen = new BigInteger("5");
		BigInteger prevNum = new BigInteger("3");
		
		BigInteger tempNum;
		BigInteger tempDen;
	
		int count = 0;
		
		for(int x = 2; x < expansions; x++){
			tempNum = currentNum.multiply(new BigInteger("2")).add(prevNum);
			tempDen = currentDen.add(currentNum);
			
			prevNum = new BigInteger(currentNum.toString());
			currentNum = new BigInteger(tempNum.toString());
			currentDen = new BigInteger(tempDen.toString());
			
			if(currentNum.toString().length() > currentDen.toString().length()){
				count++;
			}
			
		}
		System.out.println(count);

	}
	
}

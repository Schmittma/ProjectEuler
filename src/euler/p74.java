package euler;

import java.util.ArrayList;
import java.util.List;

import util.EulerUtils;
import util.StopWatch;

public class p74 {
	
	//Trading memory for speed

	
	public static void main(String[] args) {
		final int MAX = 1000000;
		
		StopWatch sw = new StopWatch();
		sw.start();
		
		int count = 0;
		for(int x = 1; x < MAX; x++){
			if(getDigitFactorialChain(x).size() == 60){
				count++;
			}
		}
		
		sw.stop();
		
		System.out.println(count); //TODO Remove print statement
		System.out.println(sw); //TODO Remove print statement
	}
	
	public static List<Integer> getDigitFactorialChain(int startingNumber){
		List<Integer> chain = new ArrayList<Integer>();
		
		chain.add(startingNumber);
		boolean chainBroken = false;
		int currentNumber = startingNumber;
		
		while(!chainBroken)
		{
			currentNumber = EulerUtils.getFactorialDigitSum(currentNumber);
			if(chain.contains(currentNumber)){
				chainBroken = true;
			}
			else{
				chain.add(currentNumber);
			}
		}
		
		return chain;
	}
	

}

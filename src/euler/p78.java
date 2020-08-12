package euler;

import util.EulerUtils;

public class p78 {

	public static void main(String[] args) {
		
		int divisor = 1000000;
		int value = 1;
		
		while(EulerUtils.getNumberOfPartitions(value) % divisor != 0){
			System.out.println(value); //TODO Remove print statement
			value++;
		}
		System.out.println(value); //TODO Remove print statement
	}
}

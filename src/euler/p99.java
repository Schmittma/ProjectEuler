package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p99 {

	public static void main(String[] args) {

		
		//[pair] -> [0] base, [1] exponent
		int[][] baseExpPairs = new int[1000][2];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("res/p099_base_exp.txt")));
			
			for(int x = 0; x < baseExpPairs.length; x++){
				String[] pair = reader.readLine().split(",");
				baseExpPairs[x][0] = Integer.parseInt(pair[0]);
				baseExpPairs[x][1] = Integer.parseInt(pair[1]);
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		long startTime = System.nanoTime();
		double largest = 0;
		int indexOflargest = 0;
		
		for(int x = 0; x < baseExpPairs.length; x++){
			double i = baseExpPairs[x][1] * Math.log10(baseExpPairs[x][0]);
			if( i > largest){
				largest = i;
				indexOflargest = x+1;
			}
			
		}
		
		
		
		long endTime = System.nanoTime();
		System.out.println(indexOflargest);
		System.out.println("Executed in: " + (endTime - startTime) + "ns"); 
	}
}

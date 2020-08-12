package euler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class p81 {
	
	/*
	 *   x -> 
	 * y [0][0] | [1][0] | [2][0] | ... | [n][0]
	 * | [0][1] | [1][1]
	 * v [0][2]
	 * 	  ...
	 *   [0][n]
	 */
	
	public static void main(String[] args) {
		int[][] matrix = new int[80][80];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("res/p081_matrix.txt")));
			for(int y = 0; y < matrix.length; y++){
				int x = 0;
				for(String cell : reader.readLine().split(",")){
					matrix[x][y] = Integer.parseInt(cell);
					x++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[][] sumMatrix = new int[matrix.length][matrix.length];

		sumMatrix[0][0] = matrix[0][0];
		
		for(int y = 1; y < matrix.length; y++){
			for(int x = 0; x <= y; x++){
				int minLast = 0;
				if(x == 0){
					minLast = sumMatrix[0][y-1];
				}
				else if(x-y == 0){
					minLast = sumMatrix[x-1][0];
				}
				else{
					minLast = Integer.min(sumMatrix[x-1][y-x], sumMatrix[x][y-x-1]);
				}
				
				sumMatrix[x][y-x] = matrix[x][y-x] + minLast;
			}
		}
		
		
		sumMatrix[matrix.length-1][matrix.length-1] = matrix[matrix.length-1][matrix.length-1];
		
		
		for(int y = matrix.length-2; y > 0; y--){
			for(int x = matrix.length-1; x >= y; x--){
				//upperSumMatrix[x][y-x]
				int minLast = 0;
				
				if(x == matrix.length-1){
					minLast = sumMatrix[matrix.length-1][y+1];
				}
				else if(x-y == 0){
					minLast = sumMatrix[x+1][matrix.length-1];
				}
				else{
					minLast = Integer.min(sumMatrix[x+1][(matrix.length-1) - (x-y)], sumMatrix[x][(matrix.length-1) - (x-y)+1]);
				}
				
				sumMatrix[x][(matrix.length-1) - (x-y)] = matrix[x][(matrix.length-1) - (x-y)] + minLast;
			}
		}
		
		int lowestSum = -1;
		
		for(int x = 1; x < matrix.length; x++){
			int y = (matrix.length-1) - (x-1);
			
			int lowestLocal = Integer.min(sumMatrix[x-1][y], sumMatrix[x][y-1]) + sumMatrix[x][y];
			
			if(lowestLocal < lowestSum || lowestSum < 0){
				lowestSum = lowestLocal;
			}
			
		}
		
		System.out.println(lowestSum);
	}
}

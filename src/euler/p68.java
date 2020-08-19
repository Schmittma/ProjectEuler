package euler;

import java.util.Arrays;

import util.PermutationList;
import util.StopWatch;

public class p68 {

	public static void main(String[] args) {
		
		StopWatch s = new StopWatch();
		s.start();
		
		int[] possibleNumbers = {1,2,3,4,5,6,7,8,9,10};
		PermutationList permutation = new PermutationList(possibleNumbers);
		permutation.GetFirst();
		
		int[] inner = new int[possibleNumbers.length/2];
		int[] outer = new int[possibleNumbers.length/2];
		
		long largest = 0;
		
		while(permutation.HasNext()){
			int[] current = permutation.GetNext();
			
			boolean is_10_in_inner = false;
			/* special case for current assignment */
			for(int x = 0; x < possibleNumbers.length/2; x++){
				if(current[x] == 10){
					is_10_in_inner = true;
				}
			}
			if(is_10_in_inner){
				continue;
			}
			
			for(int x = 0; x < current.length; x++){
				if(x < possibleNumbers.length/2){
					inner[x] = current[x];
				}
				else{
					outer[x-(possibleNumbers.length/2)] = current[x];
				}
			}
			
			if(isMagic(inner, outer)){
				long set = getSolutionSet(inner, outer);
				if(set > largest){
					largest = set;
				}
			}
		}
		System.out.println(s.stop()); //TODO Remove print statement
		System.out.println(largest); //TODO Remove print statement
		
	}
	
	public static boolean isMagic(int[] inner, int[] outer){
		int size = outer.length;
		int goal = outer[size-1] + inner[size-1] + inner[0];
		
		for(int x = 0; x < size-1; x++){
			if(goal != (outer[x] + inner[x] + inner[x+1])){
				return false;
			}
		}
		
		return true;
	}
	
	public static long getSolutionSet(int[] inner, int[] outer){
		int size = outer.length;
		int lowestStartPos = 0;
		long solutionSet = 0;
		
		for(int x = 1; x < size; x++){
			if(outer[x] < outer[lowestStartPos]){
				lowestStartPos = x;
			}
		}
		
		for(int x = 0; x < size; x++){
			int curPos = (lowestStartPos + x) % size;
			int nextPos = (curPos + 1) % size;
			solutionSet *= Math.pow(10, (int)Math.log10(outer[curPos]) + 1);
			solutionSet += outer[curPos];
			solutionSet *= Math.pow(10, (int)Math.log10(inner[curPos]) + 1);
			solutionSet += inner[curPos];
			solutionSet *= Math.pow(10, (int)Math.log10(inner[nextPos]) + 1);
			solutionSet += inner[nextPos];
			
		}
		
		return solutionSet;
	}
}

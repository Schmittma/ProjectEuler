package euler;

import java.util.Random;

public class p493 {

	public static void main(String[] args) {
		
		double probability = 0;
		long n = 1;
		while(true){
			boolean[] drawn = new boolean[7];
			Random r = new Random();
			
			for(int x = 0; x < 20; x++){
				int randomNum = r.nextInt(70);
				drawn[randomNum/10] = true;
			}
			
			int distinct = 0;
			for(boolean x : drawn){
				if(x) distinct++;
			}
			
			probability = (n-1)*probability + distinct;
			probability /= n;
			
			n++;
			
			if(n % 1000000 == 0){
				System.out.println("n: " + n + " | num: " + probability);
			}
		}
	}
}

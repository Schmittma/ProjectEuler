package euler;

public class p85 {

	public static void main(String[] args) {
		
		int target = 2000000;
		
		int nearestDist = target;
		int nearestArea = 0;
		
		for(int a = 1; countRectangles(a,1) < 2100000; a++) {
			for(int b = 1; b <= a; b++) {
				int count = countRectangles(a,b);
				
				int dist = Math.abs(count - target);
				if(dist < nearestDist) {
					nearestDist = dist;
					nearestArea = a*b;
				}
				else if(count > target){
					break;
				}
			}
		}
		
		System.out.println(nearestArea + " -> " + nearestDist);
		
		
		
	}
	
	public static int countRectangles(int a, int b ) {
		int count = 0;
		
		for(int i = 0; i < b; i++) {
			for(int j = 0; j < a; j++) {
				count += (a-j) * (b-i); 
			}
		}
		
		return count;
		
	}
}

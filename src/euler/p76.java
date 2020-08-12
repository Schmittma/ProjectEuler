package euler;
import util.EulerUtils;
public class p76 {

	public static void main(String[] args) {
		int n = 100;
		int k = 100;
		System.out.println(EulerUtils.getNumberOfPartitions(n,k)-1);
	}
}

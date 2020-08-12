package euler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Problem97 {

	public static void main(String[] args) {
		BigInteger mnmp = new BigInteger("28433").multiply(new BigInteger("2").pow(7830457)).add(new BigInteger("1"));

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("number")));
			writer.write(mnmp.toString().toCharArray());
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

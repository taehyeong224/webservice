import java.rmi.*;
import java.rmi.server.*;
import java.util.Random;

public class CalcClient {
	public static void main(String[ ] args) throws Exception {
		int size = 10;
		Numbers nums = new Numbers(size);
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < size ; i++){
			nums.setNumber(i,random.nextInt(1000));
		}

		String url = "//172.19.93.13/calc";
		Calc remoteCalcObject = (Calc)Naming.lookup(url);
		System.out.println("Got remote object : " + remoteCalcObject);
		System.out.println(" 1 + 2 = " +remoteCalcObject.sum(1,2));
		System.out.println(" Sum of " + size + " Random Numbers is " + remoteCalcObject.sumNumbers(nums));
	}
}
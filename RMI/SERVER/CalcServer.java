import java.rmi.*;
import java.rmi.server.*;

public class CalcServer {
	public static void main(String args[]) throws Exception {
		CalcImpl calc = new CalcImpl();
		Naming.rebind("//localhost/calc", calc);
		System.out.println("Server waiting.....");
	}
}
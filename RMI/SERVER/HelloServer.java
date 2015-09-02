import java.rmi.*;
import java.rmi.server.*;
public class HelloServer {
	public static void main(String[] args) throws Exception {
		HelloImpl h = new HelloImpl();
		Naming.bind("//172.19.92.59/hello",h);
		System.out.println("Hello Server ready");
	}
}
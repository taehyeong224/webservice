import java.rmi.*;
public class HelloClient {
	public static void main(String[] args) throws Exception {
		Hello h = (Hello) Naming.lookup("//localhost/hello");
		String message = h.sayHello();
		System.out.println("HelloClient : " + message);
	}
}
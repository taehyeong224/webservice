import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
//import java.rmi.server.RemoteServer.getClientHost
public class CalcImpl extends UnicastRemoteObject implements Calc {
	CalcImpl() throws RemoteException {
		super();
	}

	public int sum(int a, int b) throws RemoteException {
		return a + b;
	}

	public int sumNumbers(Numbers c) throws RemoteException {
		int sum =0;
		for (int i = 0; i < c.size(); i++) {
			sum = sum + c.getNumber(i);
			//System.out.println("Cleint  :  " +  java.rmi.server.RemoteServer.getClientHost());
		}
		return sum;
	}
}
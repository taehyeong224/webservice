import java.rmi.*;

public interface Calc extends Remote {
	public int sum(int a, int b) throws RemoteException;
	public int sumNumbers(Numbers c) throws RemoteException;
}
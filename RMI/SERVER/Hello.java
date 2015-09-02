import java.rmi.Remote;
import java.rmi.RemoteException;

 public interface Hello extends Remote {
      public String sayHello() throws java.rmi.RemoteException;
 }
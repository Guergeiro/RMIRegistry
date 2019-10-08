import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIRegistry {
  public static void main(String[] args) {
    Registry r = null;
    try {
      r = LocateRegistry.createRegistry(2023);
    } catch (RemoteException a) {
      a.printStackTrace();
    }

    try {
      ObjectRegistryInterface objectRegistry = new ObjectRegistry();
      r.rebind("registry", objectRegistry);

      System.out.println("ObjectRegistry server ready");
    } catch (Exception e) {
      System.out.println("ObjectRegistry server main " + e.getMessage());
    }
  }
}

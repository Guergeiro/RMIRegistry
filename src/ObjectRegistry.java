import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class ObjectRegistry extends UnicastRemoteObject implements ObjectRegistryInterface {
  // Attributes
  private static HashMap<String, String> servers = new HashMap<String, String>();

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  // Constructor
  public ObjectRegistry() throws RemoteException {
    super(0);
  }

  @Override
  public void addRManager(String objectID, String serverAddres) throws RemoteException {
    servers.put(objectID, serverAddres);
  }

  @Override
  public String resolve(String objectID) throws RemoteException {
    return servers.get(objectID);
  }
}

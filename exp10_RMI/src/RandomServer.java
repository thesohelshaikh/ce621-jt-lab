
import java.rmi.*;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RandomServer {

    public static void main(String args[]) {
        try {
            int port = 7000;
            startRegistry(port);
            RandomImpl r = new RandomImpl();
            String url = "rmi://localhost:" + port + "/RandomService";
            Naming.rebind(url, r);
            System.out.println("RandomGenerator is Ready and  running on port Number : " + port);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void startRegistry(int portNumber) throws RemoteException {
        try {
            Registry registry = LocateRegistry.getRegistry(portNumber);
            registry.list();
        } catch (Exception ex) {
            System.out.println("Registry could not be found on port number " + portNumber);
            Registry registry = LocateRegistry.createRegistry(portNumber);
            System.out.println("Registry created on port no. : " + portNumber);

        }
    }

}

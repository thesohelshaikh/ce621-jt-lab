
import java.rmi.*;
import java.rmi.server.*;

public class RandomImpl extends UnicastRemoteObject implements RandomGenerator {

    public RandomImpl() throws RemoteException {
        super();
    }

    @Override
    public int random() throws RemoteException {
        int random = (int) (Math.random() * 100 + 1);
        return random;
    }

}


import java.rmi.*;

public class RandomClient {

    public static void main(String args[]) {
        int port = 7000;
        try {
            String lookup_url = "rmi://localhost:" + port + "/RandomService";
            RandomGenerator r = (RandomGenerator) Naming.lookup(lookup_url);

            int result = r.random();
            System.out.println("Your random number is " + result);
        } catch (Exception ex) {

        }
    }
}

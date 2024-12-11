import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        DiffieHellmanSimulation diffieHellmanSimulation = new DiffieHellmanSimulation();

        // TEST OUTPUT
        BigInteger prime = diffieHellmanSimulation.generateLargePrime(2048);
        System.out.println("Generated prime number is: " + prime);
        BigInteger privateKey =  diffieHellmanSimulation.generatePrivateKey(prime);
        System.out.println("Generated private key is: " + privateKey);
    }
}
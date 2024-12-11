import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        DiffieHellmanSimulation diffieHellmanSimulation = new DiffieHellmanSimulation();

        // TEST OUTPUT
        BigInteger prime = diffieHellmanSimulation.generateLargePrime(2048);
        System.out.println("Prosti broj (p): " + prime);

        BigInteger generator = diffieHellmanSimulation.generateGenerator(prime);
        System.out.println("generator (g): " + generator);

        BigInteger privateKey =  diffieHellmanSimulation.generatePrivateKey(prime);
        System.out.println("Generated private key is: " + privateKey);

        BigInteger publicKey = diffieHellmanSimulation.calculatePublicKey(generator,privateKey,prime);
        System.out.println("public key je: " + publicKey);
    }
}
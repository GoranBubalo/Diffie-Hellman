import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellmanSimulation  {

    // Generating number
    SecureRandom random = new SecureRandom();

    // Method for  generating a large Prime number lest say 2048 bits
    public BigInteger generateLargePrime(int bitLength) {
        //Declaring object prime type of BigInteger
        BigInteger prime;

        //Start prime number generation
        System.out.println("Starting prime number generation......");

        //Generate  numbers until we find prime
        do {
            //Generate a random number with set length (Initializing)
            prime = new BigInteger(bitLength, random);

            //Continue until we get prime number
        } while (!prime.isProbablePrime(100));
        return prime;
    }

    // Generating a random private key smaller then p
    public BigInteger generatePrivateKey(BigInteger p){
        BigInteger privateKey;

        System.out.println("Generating private key....");

        //Generate a random number in the range [2. p -1]
        do {
            privateKey = new BigInteger(p.bitLength(), random);
        }while (privateKey.compareTo(BigInteger.TWO) < 0 || privateKey.compareTo(p) >= 0);

        return privateKey;
    }

    // Method for calculating the public key
    public BigInteger calculatePublicKey(BigInteger g, BigInteger privateKey, BigInteger p){

        return g.modPow(privateKey, p);
    }

    // Method for calculating secure key
    public BigInteger calculateSharedKey(BigInteger receivedPublicKey, BigInteger privateKey, BigInteger p){

        return receivedPublicKey.modPow(privateKey,p);
    }

}
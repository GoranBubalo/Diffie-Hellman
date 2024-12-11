import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellmanSimulation {

    // Generating number
    SecureRandom random = new SecureRandom();

    // Method for  generating a large Prime number lest say 2048 bits
    public BigInteger generateLargePrime(int bitLength) {
        BigInteger primeNumber;
        do {
            primeNumber = new BigInteger(bitLength, random);//Generate a random number with set length (Initializing)
        } while (!primeNumber.isProbablePrime(100));  //Continue until we get prime number
        return primeNumber;
    }

    // Method for generating a generator
    public BigInteger generateGenerator(BigInteger primeNumber) {
        BigInteger[] possibleGenerators = {BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(5)};
        for (BigInteger generator : possibleGenerators){
            if (generator.compareTo(primeNumber) < 0){
                return generator;
            }
        }
        return BigInteger.valueOf(2);//Default value
    }

    public void runDiffiHellmanKeyEncripton(){
        //1.Step generate prime numbers and generator
        //2.Step Create Users
        //3. Step Generate private Keys
        //4. Step Calculate public Keys
        //5. StepExchange public key and calculate shared secret keys
        //6. Step Verify Result

        BigInteger primeNumber = generateLargePrime(2048);
        BigInteger generator = generateGenerator(primeNumber);

        System.out.println("Prime Number (p): " + primeNumber);
        System.out.println("generator (g): " + generator);
        System.out.println("---------------------------------------------------");

        User alice = new User("Alice");
        User bob = new User("Bob");



        alice.generatePrivateKey(primeNumber);
        bob.generatePrivateKey(primeNumber);

        alice.calculatePublicKey(generator,alice.getPublicKey(),primeNumber);
        bob.calculatePublicKey(generator,bob.getPublicKey(),primeNumber);

        System.out.println("---------------------------------------------------");

        BigInteger alicShareKey = alice.calculateSharedKey(bob.getPublicKey(),alice.getPublicKey(), primeNumber);
        BigInteger bobSharedKey = bob.calculateSharedKey(alice.getPublicKey(),bob.getPublicKey(), primeNumber);

        if (alicShareKey.equals(bobSharedKey)) {
            System.out.println("Success! Both users calculated the same shared key");
        } else {
            System.out.println("Error! Shared keys do not match.");
        }

    }

}


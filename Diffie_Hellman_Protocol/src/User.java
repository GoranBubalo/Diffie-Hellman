import java.math.BigInteger;
import java.security.SecureRandom;

public class User {

    private final String userName;
    private BigInteger privateKey;
    private BigInteger publicKey;

    public User(String userName){
        this.userName = userName;
    }

    //Generating private key
    public void generatePrivateKey(BigInteger primeNumber){
        SecureRandom randomSecureNumber = new SecureRandom();
        this.privateKey = new BigInteger(primeNumber.bitLength(), randomSecureNumber);// privateKey stores a prime number
        while (privateKey.compareTo(BigInteger.TWO) < 0 || privateKey.compareTo(primeNumber) >= 0){
            this.privateKey = new BigInteger(primeNumber.bitLength(), randomSecureNumber);
        }
        System.out.println(userName + "'s private key is " + privateKey);
    }

    // Calculate public key
    public void calculatePublicKey(BigInteger generator, BigInteger primeNumber) {
        this.publicKey = generator.modPow(privateKey,primeNumber);
        System.out.println(userName + "'s public key is " + publicKey);

    }
    // Calculate shared key using received public key
    public BigInteger calculateSharedKey(BigInteger receivedPublicKey, BigInteger primeNumber){
        BigInteger sharedKey = receivedPublicKey.modPow(privateKey,primeNumber);
        System.out.println(userName + "'s Shared Key: " + sharedKey);
        return sharedKey;
    }

    // Getting public key
    public BigInteger getPublicKey() {
        return publicKey;
    }

    public BigInteger getPrivateKey() {
        return privateKey;
    }
}

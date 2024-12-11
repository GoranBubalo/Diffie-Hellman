import java.math.BigInteger;

public class User {

    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger primeNumber;
    private BigInteger generator;

    public User(BigInteger primeNumber, BigInteger generator){
        this.primeNumber = primeNumber;
        this.generator = generator;
    }

    //Generating private key


}

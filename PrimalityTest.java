/**
 * Created by anjieliang on 4/2/16.
 */
import java.util.*;
import java.math.*;

public class PrimalityTest {
    public static void main(String[] args ){
        BigInteger next = new BigInteger("600613");
        next = next.pow(128);
        BigInteger prime = next.nextProbablePrime();
        prime = prime.subtract(next);
        System.out.println(prime);

    }

    public static void GetNextPrime(int n) {
        boolean isPrime = false;
        int i = n;
    }
    public static boolean returnPrime(BigInteger number) {
        if (!number.isProbablePrime(5))
            return false;

        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) {
            if (BigInteger.ZERO.equals(number.mod(i)))
                return false;
        }
        return true;
    }
}

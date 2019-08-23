import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * https://www.interviewbit.com/problems/prime-sum/
 */
public class Solution {
    private Set<Integer> primes = new HashSet<>();

    public ArrayList<Integer> primesum(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        if (isPrime(A - 2)) {
            result.add(2);
            result.add(A - 2);
            return result;
        }
        for (int i = 3; i < A - 1; i++) {
            if (isPrime(i) && isPrime(A - i)) {
                result.add(i);
                result.add(A - i);
                return result;
            }
        }
        return result;
    }

    public boolean isPrime(int a) {
        if (primes.contains(a)) return true;
        if (a == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0)
                return false;
        }
        primes.add(a);
        return true;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.primesum(12).toArray()));
    }
}


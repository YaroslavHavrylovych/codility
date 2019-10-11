import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/fizzbuzz/
 */
public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    res.add("FizzBuzz");
                } else {
                    res.add("Fizz");
                }
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.fizzBuzz(15).toArray()));
    }
}


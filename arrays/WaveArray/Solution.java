import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * https://www.interviewbit.com/problems/wave-array/
 */
public class Solution {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size() - 1; i += 2) {
            int tmp = A.get(i);
            A.set(i, A.get(i + 1));
            A.set(i + 1, tmp);
        }
        return A;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(4);
        lst.add(3);
        lst.add(2);
        System.out.println(Arrays.toString(sl.wave(lst).toArray()));
    }
}


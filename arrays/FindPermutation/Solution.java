import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/find-permutation/
 */
public class Solution {
    public ArrayList<Integer> findPerm(final String A, int B) {
        int d = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'D') d++;
        }
        int s = d;
        int g = d + 2;
        ArrayList<Integer> res = new ArrayList<>(B);
        res.add(d + 1);
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == 'D') res.add(s--);
            else res.add(g++);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.findPerm("D", 2).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("I", 2).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("ID", 3).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("DDDIDIDID", 10).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("IIIIDDDDDD", 11).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("IDIDIDID", 9).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("DDDD", 5).toArray()));
        System.out.println(Arrays.toString(sl.findPerm("IIII", 5).toArray()));
    }
}


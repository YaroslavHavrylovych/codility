import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * https://www.interviewbit.com/problems/maximum-unsorted-subarray/
 */
public class Solution {
    public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        //check sorted head
        int firstUnsortedInd = -1;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i + 1) - A.get(i) < 0) {
                firstUnsortedInd = i;
                break;
            }
        }
        if (firstUnsortedInd == -1) return res;
        //check sorted tail
        int lastUnsortedInd = -1;
        for (int i = A.size() - 1; i > 0; i--) {
            if (A.get(i) - A.get(i - 1) < 0) {
                lastUnsortedInd = i;
                break;
            }
        }
        //check unsorted part
        int minInUnsorted = A.get(firstUnsortedInd);
        int maxInUnsorted = A.get(firstUnsortedInd);
        for (int i = firstUnsortedInd + 1; i <= lastUnsortedInd; i++) {
            if (A.get(i) < minInUnsorted) {
                minInUnsorted = A.get(i);
            } else if (A.get(i) > maxInUnsorted) {
                maxInUnsorted = A.get(i);
            }
        }
        //check head insertion index
        int headIns = Collections.binarySearch(A.subList(0, firstUnsortedInd), minInUnsorted);
        if (headIns < 0) {
            headIns = -headIns - 1;
        }
        while (headIns < firstUnsortedInd) {
            if (A.get(headIns).equals(minInUnsorted)) headIns++;
            else break;
        }
        //check tail insertion
        int tailIns = Collections.binarySearch(A.subList(lastUnsortedInd + 1, A.size()), maxInUnsorted);
        if (tailIns < 0) {
            tailIns = -tailIns - 1;
        }
        tailIns += lastUnsortedInd;
        while (tailIns > lastUnsortedInd) {
            if (A.get(tailIns).equals(maxInUnsorted)) tailIns--;
            else break;
        }
        //create result
        res.clear();
        res.add(headIns);
        res.add(tailIns);
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(3);
        lst.add(2);
        lst.add(4);
        lst.add(5);
        System.out.println(Arrays.toString(sl.subUnsort(lst).toArray()));
        lst.clear();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        System.out.println(Arrays.toString(sl.subUnsort(lst).toArray()));
        lst.clear();
        lst.add(1);
        lst.add(2);
        lst.add(2);
        lst.add(2);
        lst.add(5);
        lst.add(4);
        lst.add(3);
        lst.add(2);
        System.out.println(Arrays.toString(sl.subUnsort(lst).toArray()));
        lst.clear();
        lst.add(1);
        lst.add(5);
        lst.add(4);
        lst.add(3);
        lst.add(5);
        lst.add(5);
        lst.add(5);
        System.out.println(Arrays.toString(sl.subUnsort(lst).toArray()));
    }
}

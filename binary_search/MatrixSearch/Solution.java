import java.util.ArrayList;

/*
 * https://www.interviewbit.com/problems/matrix-search/
 */
public class Solution {
    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        if (a == null || a.isEmpty() || a.get(0).isEmpty()) return 0;
        int last = a.size() * a.get(0).size();
        //set stating and ending index
        int start = 0, end = last - 1;
        while (start <= end) {
            // take mid of the list
            int mid = (start + end) / 2;
            int x = mid / a.get(0).size();
            int y = mid % a.get(0).size();
            // we found a match
            if (a.get(x).get(y) == b) {
                return 1;
            } else if (a.get(x).get(y) < b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // element is not present in list
        return 0;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(3);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        a.add(b);
        b = new ArrayList<>();
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);
        b.add(10);
        a.add(b);
        b = new ArrayList<>();
        b.add(11);
        b.add(12);
        b.add(13);
        b.add(14);
        b.add(15);
        a.add(b);
        System.out.println(sl.searchMatrix(a, 1));
    }
}

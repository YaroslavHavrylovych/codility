import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://www.interviewbit.com/problems/set-matrix-zeros/
 */
public class Solution {
    public void setZeroes(ArrayList<ArrayList<Integer>> a) {
        if (a == null || a.size() == 0) return;
        Set<Integer> zeroColumns = new HashSet<>(a.get(0).size());
        Set<Integer> zerRows = new HashSet<>(a.get(0).size());
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.get(i).size(); j++) {
                if (a.get(i).get(j) == 0) {
                    zeroColumns.add(j);
                    zerRows.add(i);
                }
            }
        }
        for (Integer row : zerRows)
            for (int j = 0; j < a.get(row).size(); j++)
                a.get(row).set(j, 0);
        for (int i = 0; i < a.size(); i++)
            for (Integer col : zeroColumns)
                a.get(i).set(col, 0);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        row.add(0);
        row.add(1);
        lst.add(new ArrayList<>(row));
        row.clear();
        row.add(1);
        row.add(1);
        row.add(1);
        lst.add(new ArrayList<>(row));
        row.clear();
        row.add(1);
        row.add(1);
        row.add(1);
        lst.add(new ArrayList<>(row));
        sl.setZeroes(lst);
        print(lst);
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(Arrays.toString(a.get(i).toArray()));
        }
    }
}


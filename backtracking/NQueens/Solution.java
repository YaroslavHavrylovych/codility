import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/nqueens/
 */
public class Solution {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        return toPrint(a, addNew(a, new HashMap<>(a), 0));
    }

    private List<Map<Integer, Integer>> addNew(int a, 
            Map<Integer, Integer> existing, int curr) {
        List<Map<Integer, Integer>> mp = new ArrayList<>();
        if (curr == a) {
            mp.add(existing);
            return mp;
        }
        o1:
        for (int i = 0; i < a; i++) {
            if (existing.containsValue(i)) continue;
            for (int j = 1; j < a; j++) {
                //check
                Integer val = existing.get(curr + j);
                if (val != null && (val == i + j || val == i - j)) continue o1;
                val = existing.get(curr - j);
                if (val != null && (val == i + j || val == i - j)) continue o1;
            }
            //we can use the value
            Map<Integer, Integer> map = new HashMap<>(existing);
            map.put(curr, i);
            mp.addAll(addNew(a, map, curr + 1));
        }
        return mp;
    }

    private ArrayList<ArrayList<String>> toPrint(int a, 
            List<Map<Integer, Integer>> lst) {
        ArrayList<ArrayList<String>> res = new ArrayList<>(lst.size());
        for (Map<Integer, Integer> mp : lst) {
            ArrayList<String> resRow = new ArrayList<>();
            for (Integer row : mp.keySet().stream()
                    .sorted().collect(Collectors.toList())) {
                resRow.add(toRow(mp.get(row), a));
            }
            res.add(resRow);
        }
        return res;
    }

    private String toRow(Integer pos, int a) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a; i++) {
            if (i == pos) res.append("Q");
            else res.append(".");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<ArrayList<String>> res = sl.solveNQueens(5);
        for (ArrayList<String> solution : res) {
            System.out.println();
            for (String row : solution) {
                System.out.println(row);
            }
        }
    }
}



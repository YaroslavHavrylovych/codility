import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://www.interviewbit.com/problems/largest-number/
 */
public class Solution {
    public String largestNumber(final List<Integer> A) {
        List<String> res = A.stream().map(String::valueOf)
                .sorted((o1, o2) -> (o1 + o2).compareTo(o2 + o1)).collect(Collectors.toList());
        if (res.get(res.size() - 1).equals("0")) return "0";
        StringBuilder strBld = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) strBld.append(res.get(i));
        return strBld.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        List<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(30);
        lst.add(0);
        lst.add(34);
        lst.add(5);
        lst.add(9);
        System.out.println(sl.largestNumber(lst));
        lst.clear();
        lst.add(12);
        lst.add(121);
        System.out.println(sl.largestNumber(lst));
    }
}


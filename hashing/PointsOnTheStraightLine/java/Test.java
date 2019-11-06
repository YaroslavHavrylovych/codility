import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        arrToList(a, new int[]{1, -2, 3, 3, 2, 2, 1});
        arrToList(b, new int[]{1, -2, 3, -1, 2, -1, -1});
        boolean success = sl.maxPoints(a, b) == 4;
        a.clear();
        b.clear();
        parse("15 12 9 10 -16 3 -15 15 11 -10 -5 20 -3 -15 -11 -8 -8 -3 3 6 15 -14 -16 -18 -6 -8 14 9 -1 -7 -1 -2 3 11 6 20 10 -7 0 14 19 -18 -10 -15 -17 -1 8 7 20 -18 -4 -9 -9 16 10 14 -14 -15 -2 -10 -18 9 7 -5 -12 11 -17 -6 5 -17 -2 -20 15 -2 -5 -16 1 -20 19 -12 -14 -1 18 10 1 -20 -15 19 -18 13 13 -3 -16 -17 1 0 20 -18 7 19 1 -6 -7 -11 7 1 -15 12 -1 7 -3 -13 -11 2 -17 -5 -12 -14 15 -3 15 -11 7 3 19 7 -15 19 10 -14 -14 5 0 -1 -12 -4 4 18 7 -3 -5 -3 1 -11 1 -1 2 16 6 -6 -17 9 14 3 -13 8 -9 14 -5 -1 -18 -17 9 -10 19 19 16 7 3 7 -18 -12 -11 12 -15 20 -3 4 -18 1 13 17 -16 -15 -9 -9 15 8 19 -9 9 -17", a, b);
        success = success && sl.maxPoints(a, b) == 6;
        a.clear();
        b.clear();
        parse("3 5 1 1 -6 -4 1 1 -6 -4 3 5 -6 -4 1 1 1 1 -6 -4 1 1 3 5 2 2 -6 -4 2 2 3 5 3 5 -6 -4 2 2 3 5 -6 -4 -6 -4", a, b);
        success = success && sl.maxPoints(a, b) == 14;
        System.out.println("Points on the straight line: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void parse(String str, List<Integer> a, List<Integer> b) {
        String[] parsed = str.split(" ");
        int i = 0;
        while (i < parsed.length) {
            a.add(Integer.parseInt(parsed[i++]));
            b.add(Integer.parseInt(parsed[i++]));
        }
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}

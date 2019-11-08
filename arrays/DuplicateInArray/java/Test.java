import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(4);
        lst.add(1);
        lst.add(4);
        lst.add(1);
        int res = sl.repeatedNumber(lst);
        System.out.println("Duplicated value: " +
                (res == 1 || res == 4 ? "SUCCESS" : "FAIL"));
    }
}

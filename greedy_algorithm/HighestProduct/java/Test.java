import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> lst = new ArrayList<>();
        boolean success = new Solution().maxp3(lst) == 0;
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        success = success && new Solution().maxp3(lst) == 24;
        lst.clear();
        lst.add(0);
        lst.add(-1);
        lst.add(3);
        lst.add(70);
        lst.add(100);
        lst.add(50);
        success = success && new Solution().maxp3(lst) == 350_000;
        System.out.println("Highest Product (3 nums): " +
                (success ? "SUCCESS" : "FAIL"));
    }

}

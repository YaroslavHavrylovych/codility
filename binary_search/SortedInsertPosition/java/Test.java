import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(5);
        a.add(6);
        System.out.println("Sorted insert position: " +
                (sl.searchInsert(a, 5) == 2 
                 && sl.searchInsert(a, 2) == 0
                 && sl.searchInsert(a, 7) == 4
                 && sl.searchInsert(a, 0) == 0 
                 ? "SUCCESS" : "FAILED"));
    }
}

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        copyArr(a, new int[]{1, 2});
        copyArr(b, new int[]{2, 1});
        boolean success = new Solution().canCompleteCircuit(a, b) == 1;
        copyArr(a, new int[]{959, 329, 987, 951, 942, 410, 282, 
            376, 581, 507, 546, 299, 564, 114, 474,
            163, 953, 481, 337, 395, 679, 21, 335, 846,
            878, 961, 663, 413, 610, 937, 32, 831, 239,
            899, 659, 718, 738, 7, 209});
        copyArr(b, new int[]{862, 783, 134, 441, 177, 416, 
            329, 43, 997, 920, 289, 117, 573, 672, 574,
            797, 512, 887, 571, 657, 420, 686, 411, 817,
            185, 326, 891, 122, 496, 905, 910, 810, 226,
            462, 759, 637, 517, 237, 884});
        success = success && new Solution().canCompleteCircuit(a, b) == -1;
        System.out.println("Gas station: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void copyArr(ArrayList<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

import java.util.Arrays;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        boolean success = true;
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(Arrays.asList(
                new String[]{"ls", "qp", "q_l", "ql", "lq", "l_", "q_", 
                    "a_l_a", "a_q_a", "q_q", "a_q", "q_a"}));
        success = success && Arrays.toString(sl.solve("l_q", lst).toArray())
            .equals("[2, 9, 5, 6, 7, 8, 10, 11, 0, 1, 3, 4]");
        lst.clear();
        lst.addAll(Arrays.asList(
                new String[]{"smart_guy", "girl_and_boy_play", "play_ground"}));
        success = success && Arrays.toString(sl.solve("play_boy", lst).toArray())
            .equals("[1, 2, 0]");
        lst.clear();
        lst.addAll(Arrays.asList(
                new String[]{"water_is_cool", "cold_ice_drink", "cool_wifi_speed"}));
        success = success && Arrays.toString(sl.solve("cool_ice_wifi", lst).toArray())
            .equals("[2, 0, 1]");
        System.out.println("Hotel Reviews: " + (success ? "SUCCESS" : "FAIL"));
    }
}

import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.interviewbit.com/problems/hotel-bookings-possible/
 */
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        Collections.sort(arrive);
        Collections.sort(depart);
        int occupied = 0;
        int a = 0;
        int d = 0;
        while (a < arrive.size() && d < depart.size()) {
            int a1 = arrive.get(a);
            int d1 = depart.get(d);
            if (a1 < d1) {
                occupied += 1;
                if (occupied > K) {
                    return false;
                }
                a++;
            } else if (d1 < a1) {
                occupied -= 1;
                d++;
            } else {
                a++;
                d++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(3);
        lst.add(5);
        ArrayList<Integer> lst2 = new ArrayList<>();
        lst2.add(2);
        lst2.add(5);
        lst2.add(8);
        System.out.println(sl.hotel(lst, lst2, 1));
    }
}


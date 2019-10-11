import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://www.interviewbit.com/problems/max-distance/
 */
public class Solution {
    public int maximumGap(final List<Integer> A) {
        Queue<Item> heap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) heap.add(new Item(A.get(i), i));
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while (!heap.isEmpty()) {
            Item item = heap.poll();
            if (item.ind < min) {
                min = item.ind;
            } else {
                if (item.ind - min > max) {
                    max = item.ind - min;
                }
            }
        }
        if (max == Integer.MIN_VALUE) return 0;
        return max;
    }

    class Item implements Comparable<Item> {
        Integer val;
        Integer ind;

        Item(Integer val, Integer ind) {
            this.val = val;
            this.ind = ind;
        }

        @Override
        public int compareTo(Item o) {
            int res = val.compareTo(o.val);
            return res == 0 ? ind.compareTo(o.ind) : res;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(5);
        lst.add(4);
        lst.add(2);
        System.out.println(sl.maximumGap(lst));
        lst.clear();
        lst.add(3);
        lst.add(2);
        lst.add(1);
        System.out.println(sl.maximumGap(lst));
        Integer[] ar = new Integer[]{87319994, 94264960, 56326873, 92933025, 34799665, 70797709,
                87627208, 20659144, 32127143, 62784597, 26538695, 6715130, 34007680, 24503297, 82709828,
                75121359, 13442939, 47540743, 22497579, 65933130, 9211431, 7453693, 36943607, 96808904,
                22111943, 89901732, 35862586, 84143023, 35623474, 53333511, 76997194, 28347079, 48736937,
                28278557, 1973816, 86844533, 63049856, 3062391, 18073648, 65080192, 34969237, 66289244,
                65251465, 77978456, 40548337, 19751944, 76593474, 85475980, 12800945, 69775288, 5346458,
                39774516, 27745522, 19906182, 99708072, 94778147, 71221795, 81186513, 42569918, 70312835,
                16376923, 78793505, 69593264, 10959719, 2343941, 53176912, 75727760, 47501912, 86658650,
                70979656, 35224877, 74884852, 45344639, 40104049, 91543758, 11220024, 84458071, 67879870,
                44517149, 88680258, 314515, 99466349, 73215205, 37973008, 97777936, 1437770, 48525022,
                17617510, 12518524, 6185280, 83030653, 41569881, 32787886, 47267651, 26232207, 31609631,
                73064111, 15943132, 8839288, 53313013};
        System.out.println(sl.maximumGap(Arrays.asList(ar)));
    }
}

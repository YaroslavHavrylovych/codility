import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * Given n points on a 2D plane, find the maximum number 
 * of points that lie on the same straight line.
 * <br/>
 * https://www.interviewbit.com/problems/points-on-the-straight-line/
 */
public class Solution {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        if (a.size() != b.size()) return 0;
        if (a.size() <= 2) return a.size();
        Map<Point, Integer> pointsMap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            Point p = new Point(a.get(i), b.get(i));
            pointsMap.put(p, pointsMap.getOrDefault(p, 0) + 1);
        }
        List<Point> pointsList = new ArrayList<>(pointsMap.size());
        for (Point p : pointsMap.keySet()) pointsList.add(new Point(p.x, p.y, pointsMap.get(p)));
        if (pointsList.size() <= 2) return pointsList.stream().mapToInt(p -> p.amount).sum();
        int i = 0;
        int maxAmount = 2;
        while (i < pointsList.size() - 1) {
            int x1 = pointsList.get(i).x;
            int y1 = pointsList.get(i).y;
            for (int i1 = i + 1; i1 < pointsList.size(); i1++) {
                int x2 = pointsList.get(i1).x;
                int y2 = pointsList.get(i1).y;
                int amount = pointsList.get(i).amount;
                amount += pointsList.get(i1).amount;
                //y == kx + c
                int j = i1 + 1;
                while (j < pointsList.size()) {
                    long x = pointsList.get(j).x;
                    long y = pointsList.get(j).y;
                    if ((x - x1) * (y2 - y1) == (y - y1) * (x2 - x1)) {
                        amount += pointsList.get(j).amount;
                    }
                    j++;
                }
                if (amount > maxAmount) maxAmount = amount;
            }
            i++;
        }
        return maxAmount;
    }

    class Point {
        int x;
        int y;
        int amount;
        int hash;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private Point(int x, int y, int amount) {
            this(x, y);
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Point)) return false;
            Point p1 = (Point) obj;
            return x == p1.x && y == p1.y;
        }

        @Override
        public int hashCode() {
            if (hash == 0) {
                hash = Integer.hashCode(x * x * 100) + Integer.hashCode(y * y);
            }
            return hash;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        arrToList(a, new int[]{1, -2, 3, 3, 2, 2, 1});
        arrToList(b, new int[]{1, -2, 3, -1, 2, -1, -1});
        System.out.println(sl.maxPoints(a, b));
        a.clear();
        b.clear();
        parse("15 12 9 10 -16 3 -15 15 11 -10 -5 20 -3 -15 -11 -8 -8 -3 3 6 15 -14 -16 -18 -6 -8 14 9 -1 -7 -1 -2 3 11 6 20 10 -7 0 14 19 -18 -10 -15 -17 -1 8 7 20 -18 -4 -9 -9 16 10 14 -14 -15 -2 -10 -18 9 7 -5 -12 11 -17 -6 5 -17 -2 -20 15 -2 -5 -16 1 -20 19 -12 -14 -1 18 10 1 -20 -15 19 -18 13 13 -3 -16 -17 1 0 20 -18 7 19 1 -6 -7 -11 7 1 -15 12 -1 7 -3 -13 -11 2 -17 -5 -12 -14 15 -3 15 -11 7 3 19 7 -15 19 10 -14 -14 5 0 -1 -12 -4 4 18 7 -3 -5 -3 1 -11 1 -1 2 16 6 -6 -17 9 14 3 -13 8 -9 14 -5 -1 -18 -17 9 -10 19 19 16 7 3 7 -18 -12 -11 12 -15 20 -3 4 -18 1 13 17 -16 -15 -9 -9 15 8 19 -9 9 -17", a, b);
        System.out.println(sl.maxPoints(a, b));
        a.clear();
        b.clear();
        parse("3 5 1 1 -6 -4 1 1 -6 -4 3 5 -6 -4 1 1 1 1 -6 -4 1 1 3 5 2 2 -6 -4 2 2 3 5 3 5 -6 -4 2 2 3 5 -6 -4 -6 -4", a, b);
        System.out.println(sl.maxPoints(a, b));
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



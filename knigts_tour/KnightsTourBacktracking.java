import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Arrays;

/**
 * Tour is closed, when the last knight move placed on the cell with distance
 * of one move from the start point. So if knight want, he can start
 * same tour again directly after the last step of the current tour.
 *
 */
public class KnightsTourBacktracking {
    private static final int N = 8;
    private final int MOVES_TO_MAKE = N * N - 1;
    private static final Point INITIAL_POINT = new Point(0, 0);

    public boolean tour(List<Point> points) {
        if(points.size() == MOVES_TO_MAKE)
            return checkLastMove(points);
        Point last = possibleMoves(points)
            .filter(point -> 
                {
                    points.add(point);
                    if(!tour(points)) {
                        points.remove(points.size() -1);
                        return false;
                    }
                    return true;
                })
            .findFirst().orElse(null);
        return last != null;
    }

    private boolean checkLastMove(List<Point> points) {
        return possibleMoves(points.get(points.size() - 1))
            .anyMatch(point -> point.equals(points.get(0)));
    }

    private Stream<Point> possibleMoves(Point last) {
        int x = last.x, y = last.y;
        return Stream.of(
                new Point(x + 1, y - 2),
                new Point(x + 2, y - 1),
                new Point(x + 2, y + 1),
                new Point(x + 1, y + 2),
                new Point(x - 1, y + 2),
                new Point(x - 2, y + 1),
                new Point(x - 2, y - 1),
                new Point(x - 1, y - 2)
                )
            .filter(val -> val.x >= 0 && val.y >= 0 && val.x < N && val.y < N);
    }

    private Stream<Point> possibleMoves(List<Point> points) {
        return possibleMoves(points.get(points.size() - 1))
            .filter(val -> !points.contains(val));
    }

    public static void main(String[] args) {
        List<Point> tourPath = new ArrayList<>(N * N);
        tourPath.add(INITIAL_POINT);
        boolean success = new KnightsTourBacktracking().tour(tourPath);
        System.out.println("Tour success " + success);
        System.out.println("moves: " + Arrays.toString(tourPath.toArray()));
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return x * N + y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || !(obj instanceof Point)) return false;
            Point p = (Point) obj;
            return this == p || (x == p.x && y == p.y);
        }

        @Override
        public String toString() {
            return "{x=" + x + ",y=" + y + "}";
        }
    }
}

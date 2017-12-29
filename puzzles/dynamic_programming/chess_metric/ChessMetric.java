import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Check README to find description.
 * <br/>
 * Each step we're moving from start position to an end and checking if next
 * step is already calculated (so someone calculated possible moves from the
 * next step to the end point in exact same step) 
 * than we adding next step solution to the current
 * step existing solutions from other nodes/cells.
 * <br/>
 * Example: we're on the step 5 out of 10 and on point [0,0]. One of possible
 * moves is [1,1] and we see that it's already visited on step 4 (next step)
 * and the amount of possible moves to the endpoint is 123. From [0,0] we
 * had already visited point [0,1] and we know that there is 321 moves to the
 * end point. So currently we writing result 123+321 for step 5 at point [0,0].
 */
public class ChessMetric {
    private final int[][] templateCoords = new int[][] {
        {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1},
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    public long solutionsAmount(int size, int[] start, int[] end, int moves) {
        Map<Integer, Map<Integer, Long>> solutions = new HashMap<>(moves);
        System.out.println("");
        calculateSolutions(size, coord(start[0], start[1], size), 
                coord(end[0], end[1], size), moves, solutions);
        System.out.println("");
        print(solutions, size);
        return solutions.isEmpty() ? 0 : solutions.get(moves)
            .get(coord(start[0], start[1], size));
    }

    private void calculateSolutions(int size, int start, int end, int move,
            Map<Integer, Map<Integer, Long>> solutions) {
        println(size, move, "move " + move);
        println(size, move, "start [" + toX(start, size) + ", " 
                + toY(start, size) + "]");
        Map<Integer, Long> existing = solutions.get(move);
        //reuse if this solution was already calculated
        if(existing != null) {
            Long solsAmount= existing.get(start);
            if(solsAmount != null) {
                if(solsAmount > 0) {
                    println(size, move, "existing solution");
                    existing.put(start, solsAmount * 2);
                } else {
                    existing.put(start, solsAmount);
                }
                return;
            }
        } else {
            existing = new HashMap<>();
            solutions.put(move, existing);
        }
        int[] moves = moves(start, size);
        //if it's the last move - update
        if(move == 1) {
            if(contains(end, moves)) {
                println(size, move, "branch can be used");
                existing.put(start, 1l);
            } else { 
                println(size, move, "dead end branch");
                existing.put(start, -1l);
            }
            return;
        }
        int nextMove = move - 1;
        for(int i = 0; i < moves.length; i++) {
            //update each possible move from this point
            if(moves[i] == -1) continue;
            println(size, move, "possible move [" + toX(moves[i], size) +
                    ", " + toY(moves[i], size) + "]");
            Long existingMoves = existing.get(start);
            if(existingMoves == null) existingMoves = -1l;
            Map<Integer, Long> nextMovesMap = solutions.get(nextMove);
            if(nextMovesMap == null || nextMovesMap.get(moves[i]) == null) 
                calculateSolutions(size, moves[i], 
                    end, nextMove, solutions);
            Long newMoves = solutions.get(nextMove).get(moves[i]); 
            if(newMoves == -1l) 
                newMoves = existingMoves;
            else
                newMoves += existingMoves == -1l ? 0 : existingMoves;
            existing.put(start, newMoves);
        }
    }

    private void println(int size, int move, String str) {
        StringBuilder tmp = new StringBuilder();
        for(int i = 1; i < size - move; i++) tmp.append("  ");
        tmp.append(str);
        System.out.println(tmp.toString());
    }

    private void print(Map<Integer, Map<Integer, Long>> map, int size) {
        System.out.println("printing internal solution representation");
        for(Integer moves: map.keySet().stream().sorted()
                .collect(Collectors.toList())) {
            System.out.println("Moves " + moves + ":");
            for(Integer coord: map.get(moves).keySet()) {
                Long val = map.get(moves).get(coord);
                if(val != -1l)
                    System.out.println("  [" + toX(coord, size)+ ", " 
                            + toY(coord, size) + "] : " 
                            + map.get(moves).get(coord));
            }
        }
    }

    private boolean contains(int pos, int[] positions) {
        for(int i = 0; i < positions.length; i++)
            if(positions[i] == pos) return true;
        return false;
    }

    private int[] moves(int pos, int size) {
        int x = toX(pos, size);
        int y = toY(pos, size);
        int[] tmpCoords = new int[16];
        for(int i = 0; i < templateCoords.length; i++)
            tmpCoords[i] = coord(x + templateCoords[i][0], 
                    y + templateCoords[i][1], size);
        return tmpCoords;
    }

    private int toX(int coordinate, int size) {
        return coordinate / size;
    }

    private int fromX(int x, int size) {
        return x * size;
    }

    private int toY(int coordinate, int size) {
        return coordinate % size;
    }

    private int fromY(int y, int size) {
        return y;
    }

    private int coord(int x, int y, int size) {
        if(x >= size || y >= size || x < 0 || y < 0) return -1;
        return x * size + y;
    }

    public static void main(String[] args) {
        int size = 13;
        int[] start = new int[] {3, 7};
        int[] end = new int[] {11, 5};
        int moves = 14;
        System.out.println("");
        System.out.println("Conditions:");
        System.out.println("field size = " + size);
        System.out.println("start point = " + Arrays.toString(start));
        System.out.println("end point = " + Arrays.toString(end));
        System.out.println("moves = " + moves);
        long possibleMoves = new ChessMetric().solutionsAmount(size, start, end, 
                moves);
        System.out.println("");
        System.out.println("possible moves = " + possibleMoves);
        System.out.println("");
    }
}

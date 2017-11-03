import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Searches for each possible solution (92).
 * <br/>
 * How can we optimize? (we can skip creating each array for trying solition,
 * but use existing)
 * <br/>
 * We could search remove symetry solutions to achieve 12 totally unique.
 * 
 */
public class NqueensBacktracking {
    private final int NO_VALUE = -1;
    private final int N = 8;

    public void solutions(int[] matrix, List<int[]> solutions) {
        if(!checkRestrictions(matrix)) {
            return;
        }
        int lastNotSetInd = getLastNotSetInd(matrix);
        if(lastNotSetInd == N) {
            solutions.add(matrix);
            return;
        }
        IntStream.range(0, N)
            .forEach(val -> solutions(copyWithNew(matrix, val), solutions));
    }

    /* 
     * Check if given "matrix" respect rules of n-queens task (skipping empty
     * fields) 
     */
    private boolean checkRestrictions(int[] matrix) {
        int lastNotSetInd = getLastNotSetInd(matrix);
        for(int i = 0; i < lastNotSetInd; i++) {
            for(int j = 1; j < lastNotSetInd; j++) {
                if(i + j < lastNotSetInd) {
                    //unique
                    if(matrix[i] == matrix[i + j]) return false;
                    //diagonal to right 
                    if(matrix[i + j] == matrix[i] + j) return false;
                }
                if(i - j >= 0) {
                    //unique
                    if(matrix[i] == matrix[i - j]) return false;
                    //diagonal to left 
                    if(matrix[i - j] == matrix[i] + j) return false;
                }  
            }
        }
        return true;
    }

    private int getLastNotSetInd(int[] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i] == NO_VALUE) return i;
        }
        return N;
    }

    private void solutions(List<int[]> solutions) {
        int[] array = createEmpty(N);
        IntStream.range(0, N)
            .forEach(val -> solutions(copyWithNew(array, val), solutions));
    } 

    private int[] copyWithNew(int[] a, int val) {
        int[] res = new int[a.length];
        System.arraycopy(a, 0, res, 0, res.length);
        int lastNotSetInd = getLastNotSetInd(a);
        res[lastNotSetInd] = val;
        return res;
    }

    private int[] createEmpty(int size) {
        return IntStream.range(0, size).map(val -> -1).toArray();
    }

    public static void main(String[] args) {
        List<int[]> solutions = new ArrayList<>();
        new NqueensBacktracking().solutions(solutions);
        System.out.println("solutions size " + solutions.size());
        solutions.stream().forEach(solution -> 
                System.out.println(Arrays.toString(solution)));
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}.
 * There are K painters available and you are also given how much time
 * a painter takes to paint 1 unit of board.
 * You have to get this job done as soon as possible under
 * the constraints that any
 * painter will only paint contiguous sections of board.
 * <br/>
 * https://www.interviewbit.com/problems/painters-partition-problem/
 */
public class Solution {
    private long modulo = 10_000_003L;

    public int paint(int A, int B, ArrayList<Integer> C) {
        long min = 0, max = Long.MAX_VALUE / 2;
        long lastSuccess = max;
        while (min <= max) {
            long mid = (min + max) / 2;
            if (isPossible(mid, A, B, C)) {
                lastSuccess = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return (int) (lastSuccess % modulo);
    }

    private boolean isPossible(long maxT, int pAmount, int timeToPaint, List<Integer> C) {
        int boardsPassed = 0;
        int p = 0;
        while (boardsPassed < C.size() && p < pAmount) {
            long drawenBy = 0;
            while (drawenBy < maxT && boardsPassed < C.size()) {
                drawenBy += (C.get(boardsPassed) * 1L) * timeToPaint;
                if (drawenBy < 0 || drawenBy > maxT) {
                    break;
                }
                boardsPassed++;
            }
            p++;
        }
        return boardsPassed >= C.size();
    }
}


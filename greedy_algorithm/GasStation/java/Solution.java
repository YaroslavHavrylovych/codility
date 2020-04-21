import java.util.ArrayList;
import java.util.List;

/**
 * Given two integer arrays A and B of size N.
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i and
 * ending up at i again.
 * <br/>
 * https://www.interviewbit.com/problems/gas-station/
 */
public class Solution {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        if (A.isEmpty() || A.size() != B.size()) return 0;
        int startInd = 0;
        int currentInd = startInd;
        int stationsPassed = 0;
        int gasAmount = 0;
        do {
            gasAmount += A.get(currentInd);
            gasAmount -= B.get(currentInd);
            stationsPassed += 1;
            if (gasAmount < 0) {
                if (startInd > currentInd) return -1;
                gasAmount = 0;
                stationsPassed = 0;
                startInd = currentInd + 1;
            }
            currentInd++;
            if (currentInd >= A.size()) {
                currentInd = 0;
            }
        } while (startInd < A.size() && stationsPassed < A.size());
        if (stationsPassed >= A.size()) return startInd;
        else return -1;
    }
}


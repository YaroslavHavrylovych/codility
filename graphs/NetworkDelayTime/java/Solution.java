import java.util.HashSet;
import java.util.Set;

/**
 * There are N network nodes, labelled 1 to N.  
 * Given times, a list of travel times as directed edges 
 * times[i] = (u, v, w), where u is the source node, 
 * v is the target node, and w is the time it takes for a signal 
 * to travel from source to target.  
 *
 * Now, we send a signal from a certain node K. 
 * How long will it take for all nodes to receive the signal? 
 * If it is impossible, return -1.
 * <br/>
 * https://leetcode.com/problems/network-delay-time/
 */
class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] visited = new int[N + 1];
        for(int i = 0; i < N; i++) visited[i] = -1;
        visited[K - 1] = 0;
        Set<Integer> current = new HashSet<>();
        current.add(K);
        while(!current.isEmpty()) {
            Set<Integer> nextMove = new HashSet<>();
            //next iteration of move
            for(int[] move: times) {
                if(current.contains(move[0])) {
                    int timeToMove = move[2];
                    int existingTime = visited[move[0] - 1];
                    int afterMoveTime = existingTime + timeToMove;
                    if(visited[move[1] - 1] == -1 || afterMoveTime < visited[move[1] - 1]) {
                        visited[move[1] - 1] = afterMoveTime;
                        nextMove.add(move[1]);
                    }
                }
            }
            //updating next steps
            current = nextMove;
        }
        //check if everythig is visited
        int max = -1;
        for(int i = 0; i < N; i++) {
            if(visited[i] > max) max = visited[i];
            else if(visited[i] == -1) return -1;
        }
        return max;
    }
}

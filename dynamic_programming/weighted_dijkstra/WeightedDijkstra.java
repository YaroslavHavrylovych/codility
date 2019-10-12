import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Check README to find the description.
 * <br/>
 * Traversing graph from start point step by step and select only 
 * unused vertices with cheapest path.
 */
public class WeightedDijkstra {
    /**
     * Searches for the shortest path from 0 to n.
     *
     * @return int array which contains path length and money spent on path
     * respectively (if there is multiple path with the same length - return
     * cheapest) and null if path doesn't exist.
     */
    public int[] shortestPath(int[][] g, int n, int money) {
        List<Integer> start = new ArrayList<>();
        start.add(0);
        List<Integer> weights = new ArrayList<>();
        weights.add(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        return shortestPath(0, n, g, money, start, weights, visited);
    }

    /**
     * Searches for the shortest path from positions to n.
     *
     * @return int array which contains path length and money spent on path
     * respectively (if there is multiple path with the same length - return
     * cheapest) and null if path doesn't exist.
     */
    private int[] shortestPath(int step, int n, int[][] g, int money, 
            List<Integer> positions, List<Integer> weights,
            Set<Integer> visited) {
        List<Integer> newPositions = new ArrayList<>();
        List<Integer> newWeights = new ArrayList<>();
        for(int ind = 0; ind < positions.size(); ind++) {
            int i = positions.get(ind);
            for(int j = 0; j < g[i].length; j++) {
                if(g[i][j] == 0 || visited.contains(j)) continue;
                int weight = weights.get(ind) + g[i][j];
                if(weight > money) continue;
                int existInd = newPositions.indexOf(j);
                if(existInd == -1) {
                    newPositions.add(j);
                    newWeights.add(weight);
                } else {
                    int existingWeight = newWeights.get(existInd);
                    if(weight < existingWeight) 
                        newWeights.set(existInd, weight);
                }
            }
        }
        int lastInd = newPositions.indexOf(n);
        if(newPositions.isEmpty()) return null;
        if(lastInd != -1) return new int[] {step + 1, newWeights.get(lastInd)};
        visited.addAll(positions);
        return shortestPath(step + 1, n, g, money,
                newPositions, newWeights, visited);
    }

    public static void main(String[] args) {
        int[][] g = new int[][] {
            {0, 4, 5, 2, 0, 0, 0, 0, 0, 0, 0}, 
            {4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
            {5, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0}, 
            {2, 0, 0, 0, 8, 0, 0, 7, 0, 0, 0}, 
            {0, 0, 6, 8, 0, 4, 5, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 5, 0, 0, 0, 4, 3, 0}, 
            {0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 7}, 
            {0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0}, 
            {0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0}};
        int[] shortest = new WeightedDijkstra().shortestPath(g, 9, 18);
        if(shortest == null) System.out.println("the path doesn't exists");
        else System.out.println("shortest path consists of " + shortest[0] 
                + " elements, and costs " + shortest[1]);
    }
}

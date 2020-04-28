/**
 * Students are asked to stand in non-decreasing order of heights for
 * an annual photo.
 *
 * Return the minimum number of students that must move in order for
 * all students to be standing in non-decreasing order of height.
 * Notice that when a group of students is selected they can reorder
 * in any possible way between themselves and the non selected students
 * remain on their seats.
 * <br/>
 * https://leetcode.com/problems/height-checker/
 */
class Solution {
    int MAX_HEIGHT = 100;
    
    public int heightChecker(int[] heights) {
        int[] bucket = new int[MAX_HEIGHT];
        for(int i = 0; i < heights.length; i++) bucket[heights[i] - 1] += 1;
        int currentInLine = 0;
        int[] resultLine = new int[heights.length];
        for(int i = 0; i < bucket.length; i++)
            for(int j = 0; j < bucket[i]; j++) 
                resultLine[currentInLine++] = i + 1;
        int diff = 0;
        for(int i = 0; i < resultLine.length; i++)
            if(heights[i] != resultLine[i]) diff++;
        return diff;
    }
}

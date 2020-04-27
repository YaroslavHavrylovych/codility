/**
 * The Hamming distance between two integers is the number of positions at 
 * which the corresponding bits are different. 
 * Given two integers x and y, calculate the Hamming distance.
 *
 * @link https://leetcode.com/problems/hamming-distance/
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        while(x > 0 || y > 0) {
            if((x & 1) != (y & 1)) {
                dist++;
            }
            x >>= 1;
            y >>= 1;
        }
        return dist;
    }
}

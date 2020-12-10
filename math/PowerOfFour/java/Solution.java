import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Given an integer n, return true if it is a power of four. Otherwise, return false.
 * An integer n is a power of four, if there exists an integer x such that n == 4x.
 * <br/>
 * https://leetcode.com/problems/power-of-four/
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == Integer.MIN_VALUE) return false;
        if(num == 0 || num == -1) return false;
        int orig = num;
        num = Math.abs(num);
        if(num == 1) return true;
        int i = 0;
        int neg_i = 0;
        while(num > 1) {
            if((num & 1) == 1) return false;
            num = num >> 1;
            i++;
        }
        if(orig > 0) return i % 2 == 0;
        else return i % 2 == 0 && i % 4 == 1;
    }
}

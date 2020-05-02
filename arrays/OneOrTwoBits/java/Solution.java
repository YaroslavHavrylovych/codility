/**
 * We have two special characters. 
 * The first character can be represented by one bit 0.
 * The second character can be represented by two bits (10 or 11).
 *
 * Now given a string represented by several bits.
 * Return whether the last character must be a one-bit character or not.
 * The given string will always end with a zero.
 * <br />
 * https://leetcode.com/problems/1-bit-and-2-bit-characters/
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       if(bits.length < 1) return true;
       int i = 0;
       boolean oneBit = false;
       while(i < bits.length) {
           if(bits[i] == 1) {
               i += 2;
               oneBit = false;
           } else {
               i += 1;
               oneBit = true;
           }
       }
       return oneBit;
    }
}

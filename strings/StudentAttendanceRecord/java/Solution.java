/**
 * You are given a string representing an attendance record for a student. 
 * The record only contains the following three characters: 
 *      'A' : Absent.  
 *      'L' : Late.  
 *      'P' : Present.  
 *
 *  A student could be rewarded if his attendance record doesn't contain
 *  more than one 'A' (absent) or more than two continuous 'L' (late). 
 *
 *  You need to return whether the student could be rewarded according 
 *  to his attendance record.
 * <br/>
 *  * https://www.interviewbit.com/problems/add-binary-strings/
 */
public class Solution {
    public boolean checkRecord(String s) {
        if(s.isEmpty() || s.length() == 1) return true;
        boolean wasAbsentOnce = false;
        boolean lastLate = false;
        boolean beforeLastLate = false;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'A') {
                if(wasAbsentOnce) return false;
                else wasAbsentOnce = true;
            } else if(ch == 'L') {
                if(beforeLastLate) return false;
                if(lastLate) beforeLastLate = true;
                lastLate = true;
                continue;
            }
            beforeLastLate = false;
            lastLate = false;
        }
        return true;
    }
}

import java.util.ArrayDeque;
import java.util.Deque;

/** 
 * Given a string A representing an absolute path for a file (Unix-style).  
 * Return the string A after simplifying the absolute path.  
 * <br/>
 * Note: 
 * Absolute path always begin with ’/’ ( root directory ).  
 * Path will not have whitespace characters.
 * <br/>
 * https://www.interviewbit.com/problems/simplify-directory-path/
 */
public class Solution {
    public String simplifyPath(String A) {
        Deque<String> path = new ArrayDeque<>();
        for (String str : A.split("/")) {
            if (str.isEmpty()) continue;
            if (str.equals(".")) continue;
            if (str.equals("..")) {
                if (!path.isEmpty()) path.pop();
                continue;
            }
            path.push(str);
        }
        if (path.isEmpty()) return "/";
        StringBuilder strBld = new StringBuilder();
        while (!path.isEmpty()) {
            strBld.append("/").append(path.removeLast());
        }
        return strBld.toString();
    }
}



/**
 * Your friend is typing his name into a keyboard.
 * Sometimes, when typing a character c, the key might get long pressed,
 * and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.
 * Return True if it is possible that it was your friends name,
 * with some characters (possibly none) being long pressed.
 * <br/>
 * https://leetcode.com/problems/long-pressed-name/
 */
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        //TODO any is empty - handle here
        int i1 = 0;
        int i2 = 0;
        while(i1 < name.length() && i2 < typed.length()) {
            if(name.charAt(i1) != typed.charAt(i2)) return false;
            int charInName = charactersAmountIn(name, i1);
            int charInTyped = charactersAmountIn(typed, i2);
            if(charInTyped < charInName) return false;
            i1 += charInName;
            i2 += charInTyped;
        }
        return i1 == name.length() && i2 == typed.length();
    }
    
    private int charactersAmountIn(String word, int startPos) {
        int end = startPos;
        while(++end < word.length()) if(word.charAt(end) != word.charAt(startPos)) break;
        return end - startPos;
    }
}

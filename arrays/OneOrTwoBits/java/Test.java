import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        if(sl.isOneBitCharacter(new int[] {1,0,0})
                && !sl.isOneBitCharacter(new int[] {1,1,1,0}))
            {
                System.out.println("1-bit and 2-bit Characters: SUCCESS");
            } else {
                System.out.println("1-bit and 2-bit Characters: FAILED");
            }
    }
}


public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        boolean success = sl.simplifyPath("/home//path").equals("/home/path")
            && sl.simplifyPath("/home/").equals("/home")
            && sl.simplifyPath("/a/./b/../../c/").equals("/c")
            && sl.simplifyPath("/../").equals("/");
        System.out.println("Dir path: " + (success ? "SUCCESS" : "FAIL"));
    }
}

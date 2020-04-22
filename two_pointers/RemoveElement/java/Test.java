public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] arr = new int[] {3,2,2,3};
        boolean success = sl.removeElement(arr, 3) == 2;
        System.out.println("Remove element: " +
                (success ? "SUCCESS" : "FAILED"));
    }
}

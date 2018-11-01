import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int position = Arrays.binarySearch(sortedArray, lessThan);
        if(position < 0) {
            position = -position - 1;
        }
        return position;
    }
    
    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(
                    new int[] { 1, 3, 5, 7 }, 4));
    }
}

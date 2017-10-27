import java.util.Arrays;

public class Bubble {

    /** default Bubble sort algorithm */
    private void sort(int[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = 0; j < a.length - i; j++) {
                if(a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 11, 31, 60, 90, 81,
            85, 75, 21, 13, 32, 42, 90, 1};
        System.out.println("start array " + Arrays.toString(array));
        new Bubble().sort(array);
        System.out.println("sorted array " + Arrays.toString(array));
    }
}

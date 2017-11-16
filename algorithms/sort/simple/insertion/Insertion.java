import java.util.Arrays;

/** Check README to find description */
public class Insertion {
    private void sort(int[] a) {
        for(int i = 1; i < a.length; i++)
            for(int j = i; j > 0; j--)
                if(a[j-1] > a[j]) swap(a, j-1, j);
                else break;
    }

    private void swap(int[] a, int ind1, int ind2) {
        if(ind1 == ind2) return;
        int tmp = a[ind1];
        a[ind1] = a[ind2];
        a[ind2] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {10, 2, 11, 31, 60, 90, 81,
            85, 75, 21, 13, 32, 42, 90, 1};
        System.out.println(Arrays.toString(array));
        new Insertion().sort(array);
        System.out.println(Arrays.toString(array));
    }
}

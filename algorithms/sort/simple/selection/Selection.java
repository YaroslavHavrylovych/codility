import java.util.Arrays;

/** Check README to find description */
public class Selection {
    public void sort(int[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            int ind = getIndOfSmallest(a, i, a.length);
            swap(a, i, ind);
        }
    }

    private int getIndOfSmallest(int[] a, int start, int end) {
        int smallestInd = start;
        for(int i = start + 1; i < end; i++) {
            if(a[i] < a[smallestInd]) {
                smallestInd = i;
            }
        }
        return smallestInd;
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
        new Selection().sort(array);
        System.out.println(Arrays.toString(array));
    }
}

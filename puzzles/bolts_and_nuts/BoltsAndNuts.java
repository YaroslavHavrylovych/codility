import java.util.Map;
import java.util.HashMap;

/**
 * Check README to find description.
 * <br/>
 * In the input you have two unsorted arrays of bolts and nuts.
 * As we need to pair each we could do a full check: each bolt with each nut 
 * (holding in mind that we can't compare bolt to bolt and nut to nut).
 * Approach here is to sort bolts and nuts arrays with quicksort, as quicksort
 * does sorting of array parts based on a given component.
 * <br/>
 * Step by step:
 * 1) Sort bolts by a given nut (nut in the top of the array of nuts).
 * 2) While sort we could find corresponding bolt which appear on his position.
 * 3) Based on we have equal amounts of corresponding nuts we know the final
 * position in a sorted array of a last nut (which was used to sort bolts). So
 * we moving the nut to it's position.
 * 4) We have paired single bolt and nut and partly sorted array (against on
 * component). So we continue our sort (and pairing) on unsorted parts.
 *
 */
public class BoltsAndNuts {

    public static void main(String[] args) {
        Bolt[] bolts = new Bolt[] {new Bolt(1), new Bolt(22), new Bolt(3),
            new Bolt(7), new Bolt(12), new Bolt(14), new Bolt(17),
            new Bolt(46), new Bolt(42), new Bolt(44), new Bolt(47),
            new Bolt(36), new Bolt(32), new Bolt(34), new Bolt(37)};
        Nut[] nuts= new Nut[] {new Nut(17), new Nut(22), new Nut(1),
            new Nut(14), new Nut(7), new Nut(3), new Nut(12),
            new Nut(36), new Nut(34), new Nut(32), new Nut(37),
            new Nut(47), new Nut(42), new Nut(44), new Nut(46)};
        Map<Bolt, Nut> result = new BoltsAndNuts().sort(bolts, nuts);
        System.out.println("Sorted bolts and nuts by size: " + result);
    }

    public Map<Bolt, Nut> sort(Bolt[] bolts, Nut[] nuts) {
        sort(bolts, nuts, 0, bolts.length - 1);
        Map<Bolt, Nut> map = new HashMap<>(bolts.length);
        for(int i = 0; i < bolts.length; i++)
            map.put(bolts[i], nuts[i]);
         return map;
    }

    private void sort(Bolt[] bolts, Nut[] nuts, int low, int hi) {
        if(low >= hi) return;
        //splitting parts for bolts and for nuts
        int splitPos = split(bolts, low, hi, nuts[hi]);
        swap(nuts, splitPos, hi);
        split(nuts, low, hi, bolts[splitPos]);
        //sorting the rest
        sort(bolts, nuts, low, splitPos - 1);
        sort(bolts, nuts, splitPos + 1, hi);
    }

    private int split(Nut[] nuts, int low, int hi, Bolt bolt) {
        int i = low, j = hi - 1;
        if(i == j) {
            if(nuts[i].compareTo(bolt) > 0) swap(nuts, low, hi);
            return low;
        }
        int pivot = hi;
        boolean done = false;
        do {
            while(i < j && nuts[i].compareTo(bolt) <= 0) {
                if(nuts[i].equals(bolt)) swap(nuts, i, pivot);
                else i++;
            }
            while(j > i && nuts[j].compareTo(bolt) >= 0) {
                if(nuts[j].equals(bolt)) swap(nuts, j, pivot);
                else j--;
            }
            if(i >= j) done = true;
            else swap(nuts, i, j);
        } while(!done);
        if(nuts[j].compareTo(bolt) > 0) swap(nuts, j, pivot);
        return j;
    }

    private int split(Bolt[] bolts, int low, int hi, Nut nut) {
        int i = low, j = hi - 1;
        int pivot = hi;
        boolean done = false;
        do {
            while(i < j && bolts[i].compareTo(nut) <= 0) {
                if(bolts[i].equals(nut)) swap(bolts, i, pivot);
                else i++;
            }
            while(j > i && bolts[j].compareTo(nut) >= 0) {
                if(bolts[j].equals(nut)) swap(bolts, j, pivot);
                else j--;
            }
            if(i >= j) done = true;
            else swap(bolts, i, j);
        } while(!done);
        if(bolts[j].compareTo(nut) > 0) swap(bolts, j, pivot);
        return j;
    }

    private void swap(Object[] obj, int i1, int i2) {
        Object val = obj[i1];
        obj[i1] = obj[i2];
        obj[i2] = val;
    }
}

class Bolt implements Comparable<Nut> {
    Integer size;

    Bolt(int size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        return size.hashCode();
    }

    @Override
    public String toString() {
        return "B(" + size.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Nut)) {
            return false;
        }
        return compareTo((Nut) obj) == 0;
    }

    @Override
    public int compareTo(Nut nut) {
        return size.compareTo(nut.size);
    }
}

class Nut implements Comparable<Bolt> {
    Integer size;

    Nut(int size) {
        this.size = size;
    }

    @Override
    public int hashCode() {
        return size.hashCode();
    }

    @Override
    public String toString() {
        return "N(" + size.toString() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Bolt)) {
            return false;
        }
        return compareTo((Bolt) obj) == 0;
    }

    public int compareTo(Bolt bolt) {
        return size.compareTo(bolt.size);
    }
}

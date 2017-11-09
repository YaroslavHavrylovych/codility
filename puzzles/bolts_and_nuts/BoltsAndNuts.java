import java.util.Map;
import java.util.HashMap;

public class BoltsAndNuts {

    public static void main(String[] args) {
        Bolt[] bolts = new Bolt[] {new Bolt(1), new Bolt(22), new Bolt(3),
            new Bolt(7), new Bolt(12), new Bolt(14), new Bolt(17)};
        Nut[] nuts= new Nut[] {new Nut(1), new Nut(22), new Nut(3),
            new Nut(7), new Nut(12), new Nut(14), new Nut(17)};
        Map<Bolt, Nut> result = new BoltsAndNuts().sort(bolts, nuts);
        System.out.println("Sorted bolts and nuts by size: " + result);
    }

    public Map<Bolt, Nut> sort(Bolt[] bolts, Nut[] nuts) {
        Map<Bolt, Nut> map = new HashMap<>(bolts.length);;;;
        for(int i = 0; i < bolts.length; i++)
            map.put(bolts[i], nuts[i]);
         return map;
    }

    private void sort(Bolt[] bolts, Nut[] nuts, int low, int hi) {
        if(low > hi) return;
        //splitting parts for bolts and for nuts
        int splitPos = split(bolts, low, hi, nuts[nuts.length - 1]);
        split(nuts, low, hi, bolts[bolts.length - 1]);
        //continue with each in separate
        sort(bolts, nuts, low, splitPos - 1);
        sort(bolts, nuts, splitPos + 1, hi);
    }

    private int split(Nut[] nuts, int low, int hi, Bolt bolt) {
        int i = low, j = hi - 1;
        int pivot = hi;
        boolean done = false;
        do {
            while(i < j && nuts[i].compareTo(bolt) <= 0) {
                if(nuts[i].compareTo(bolt) == 0) swap(nuts, i, pivot);
                else i++;
            }
            while(j > i && nuts[i].compareTo(bolt) >= 0) {
                if(nuts[i].compareTo(bolt) == 0) swap(nuts, i, pivot);
                else j--;
            }
            if(i >= j) done = true;
            else swap(nuts, i, j);
        } while(!done);
        swap(nuts, j, pivot);
        return low;
    }

    private int split(Bolt[] bolts, int low, int hi, Nut nut) {
        int i = low, j = hi - 1;
        int pivot = hi;
        boolean done = false;
        do {
            while(i < j && bolts[i].compareTo(nut) <= 0) {
                if(bolts[i].compareTo(nut) == 0) swap(bolts, i, pivot);
                else i++;
            }
            while(j > i && bolts[i].compareTo(nut) >= 0) {
                if(bolts[i].compareTo(nut) == 0) swap(bolts, i, pivot);
                else j--;
            }
            if(i >= j) done = true;
            else swap(bolts, i, j);
        } while(!done);
        swap(bolts, j, pivot);
        return low;
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
        return size.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || (obj instanceof Nut)) {
            return false;
        }
        return size == ((Nut) obj).size;
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
        return size.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || (obj instanceof Bolt)) {
            return false;
        }
        return size == ((Bolt) obj).size;
    }

    public int compareTo(Bolt bolt) {
        return size.compareTo(bolt.size);
    }
}


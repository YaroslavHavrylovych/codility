import java.util.Map;
import java.util.HashMap;

public class Test {
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
}

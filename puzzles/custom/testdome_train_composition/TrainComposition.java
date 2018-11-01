import java.util.LinkedList;
import java.util.List;

public class TrainComposition {
    private List<Integer> train = new LinkedList<>(); 
    public void attachWagonFromLeft(int wagonId) {
        train.add(0, wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        train.add(wagonId);
    }

    public int detachWagonFromLeft() {
        return train.remove(0);
    }

    public int detachWagonFromRight() {
        return train.remove(train.size() - 1);
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}

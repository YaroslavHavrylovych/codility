## Train Composition

[Original](https://www.testdome.com/questions/java/train-composition/21568?questionIds=21568,21557&generatorId=27&type=fromtest&testDifficulty=Hard)

Preconditions:

A TrainComposition is built by attaching and detaching wagons from the left
and the right sides, efficiently with respect to time used.

For example, if we start by attaching wagon 7 from the left followed
by attaching wagon 13, again from the left, we get a composition of two
wagons (13 and 7 from left to right). Now the first wagon that can be
detached from the right is 7 and the first that can be detached from the
left is 13.

Implement a TrainComposition that models this problem.

Starting code:

```java
public class TrainComposition {
    public void attachWagonFromLeft(int wagonId) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public void attachWagonFromRight(int wagonId) {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromLeft() {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public int detachWagonFromRight() {
        throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7 
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}
```

TODO: You have to implement this detacher-attacher in the most efficient way.


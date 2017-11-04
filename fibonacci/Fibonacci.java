/**
 * Check README to find description.
 * <br/>
 * Even java doesn't have tail optimization I've tried to keep it (for future
 * generations, lol). As in this case we don't need any memoization and it's
 * pretty straight forward and easy.
 */
public class Fibonacci {
    private static final int NUMBER_TO_FIND = 40;

    public int evaluate(int numberToFind) {
        if(numberToFind <= 2) return 1;
        return fibonacci(1, 1, numberToFind - 3);
    }

    private int fibonacci(int i1, int i2, int amountLeft) {
        if(amountLeft == 0) return i1 + i2;
        return fibonacci(i2, i1 + i2, amountLeft - 1);
    }

    public static void main(String[] args) {
        System.out.println("fibonacci(" + NUMBER_TO_FIND + ") = " +
                new Fibonacci().evaluate(NUMBER_TO_FIND));
    }
}

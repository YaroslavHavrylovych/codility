import java.util.Arrays;

/**
 * Check README to find the description.
 */
public class MinCoinsAmount {
    private static final int[] COINS = new int[] {1, 3, 4, 5, 10};
    private static final int S = 37;

    public int minAmount(int[] coins, int s) {
        int[] coinsTable = new int[37];
        for(int i = 0; i < coinsTable.length; i++) 
            coinsTable[i] = Integer.MAX_VALUE;
        return minAmount(coins, s, 0, coinsTable);
    }

    private int minAmount(int[] coins, int s, int current, int[] coinsTable) {
        if(current == coinsTable.length) return coinsTable[current - 1];
        for(int i = 0; i < coins.length; i++) {
            if(coins[i] == current + 1) coinsTable[current] = 1;
            else if(current - coins[i] < 0) continue;
            else if(coinsTable[current - coins[i]] < coinsTable[current])
                coinsTable[current] = coinsTable[current - coins[i]] + 1;
        }
        return minAmount(coins, s, current + 1, coinsTable);
    }

    public static void main(String[] args) {
        System.out.println("Available coins: " + Arrays.toString(COINS));
        System.out.println("Sum to achieve: " + S);
        System.out.println("Minimum amount of coins: " 
                + new MinCoinsAmount().minAmount(COINS, S));

    }
}


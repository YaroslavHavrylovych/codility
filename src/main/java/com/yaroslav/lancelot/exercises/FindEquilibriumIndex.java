package com.yaroslav.lancelot.exercises;

/**
 * The task is to return "equilibrium index" (sum of indexes before and after that index are equals) of an array.
 * <br/>
 * If index is zero or N-1 (where N - number of elements in array) that's mean that sum of elements from [1..N-1]
 * (or [N-2..0]) is equal to zero.
 */
class FindEquilibriumIndex {
    public int findIndex(int[] a) {
        if (a.length == 1) {
            return 0;
        }
        if (a.length == 0) {
            return -1;
        }
        int[] b = new int[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        //now we have 2 arrays with visa versa sums in both
        for (int i = 1; i < b.length; i++) {
            b[i] = b[i - 1] + b[i];
        }
        if (b[b.length - 2] == 0) {// if it's last index
            return b.length - 1;
        }
        for (int i = a.length - 2; i >= 0; i--) {
            a[i] = a[i] + a[i + 1];
        }
        if (a[1] == 0) {// if it's first index
            return 1;
        }
        //any other
        for (int i = 1; i < a.length - 1; i++) {
            if (b[i - 1] == a[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String... r) {
        FindEquilibriumIndex s = new FindEquilibriumIndex();
        System.out.println(s.findIndex(new int[]{5, 5, 4, 3, 2, 3, 4, 5, 5}));
        System.out.println(s.findIndex(new int[]{0, 1, -1, 1, 0, 1, -1}));
        System.out.println(s.findIndex(new int[]{-1, 1, -1, 1, 1, 0}));
        System.out.println(s.findIndex(new int[]{-1, 1, -1, 1, -1, 1, 56}));
        System.out.println(s.findIndex(new int[]{65, -1, 1, -1, 1, -1, 1}));
        System.out.println(s.findIndex(new int[0]));
        System.out.println(s.findIndex(new int[1]));
        System.out.println(s.findIndex(new int[]{65, 96}));
        System.out.println(s.findIndex(new int[]{65, -1, 30, 35}));
        System.out.println(s.findIndex(new int[]{30, 35, -1, 65}));
    }
}
import java.util.*;

class Solution {
    public int[] repeatedNumber(final int[] A) {
        double n = A.length;
        Double Sn = (n * (n + 1)) / 2;
        Double S = 0d;

        for (int i = 0; i < n; i++) {
            S += A[i];
        }

        Double S2n = (n * (n + 1) * (2*n + 1))/6;
        Double S2 = 0d;

        for (int i = 0; i < n; i++) {
            S2 += Math.pow(A[i], 2);
        }

        double x = ((S2 - S2n)/(S - Sn) - (S - Sn))/2;

        double y = x - (S - Sn);

        int xx = (int) x;
        int yy = (int) y;

        return new int[]{xx, yy};
    }
}


class Main {
    public static void main(String[] args) {


    }
}
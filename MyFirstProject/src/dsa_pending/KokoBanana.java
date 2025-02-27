package dsa_pending;

import java.util.Arrays;

class KokoBananaSolution {
    int upperBound(int[] piles, int val) {
        int n = piles.length;
        int l = 0, r = n - 1;
        if (piles[r] < val) return r + 1;

        while (l <= r) {
            int mid = (l + r)/2;
            if (l == r) {
                if (piles[mid] > val) return mid;
                else return mid + 1;
            }

            if (piles[mid] <= val) l = mid + 1;
            else r = mid;
        }

        return -1;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);

        if (n == h) return piles[n - 1];

        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i];
        }
        int start = (sum % h == 0) ? sum/h : sum/h + 1;

        int prev = 0, curr = -1, hrs = 0, x = start, q = 1;

        while (true) {
            curr = upperBound(piles, q*x);
            hrs += q * (curr - prev);
            if (curr == n) {
                if (hrs <= h) {
                    return x;
                } else {
                    prev = 0; curr = -1; hrs = 0; x++; q = 1;
                }
            } else {
                prev = curr;
                q = (piles[curr] % x == 0) ? piles[curr]/x : piles[curr]/x + 1;
            }
        }
    }
}



public class KokoBanana {
    public static void main(String[] args) {
        KokoBananaSolution sol = new KokoBananaSolution();

        int[] piles = { 4, 10, 23, 25 };

        System.out.println(sol.minEatingSpeed(piles, 10));
    }
}

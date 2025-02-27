package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {

    static void merge(ArrayList<Integer> arr, int l, int r) {
        int mid = l + (r - l)/2;
        int n = mid + 1 - l, m = r - mid;
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        int u = 0, v = l;
        while (u < n) arr1[u++] = arr.get(v++);
        u = 0; v = mid + 1;
        while (u < m) arr2[u++] = arr.get(v++);

        int k = 0, len = n + m;
        int[] sorted = new int[len];

        int i = 0, j = 0;
        while (i < n && j < m && k < len) {
            if (arr1[i] <= arr2[j]) {
                sorted[k++] = arr1[i++];
            } else {
                sorted[k++] = arr2[j++];
            }
        }
        while (i < n && k < len) sorted[k++] = arr1[i++];
        while (j < m && k < len) sorted[k++] = arr2[j++];

        k = 0;
        for (i = l; i <= r; i++) arr.set(i, sorted[k++]);
    }

    static void mergeSort(ArrayList<Integer> arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, r);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 1, 1, 2, 0, 0));
        mergeSort(arr, 0, arr.size() - 1);
        for (Integer x: arr) System.out.println(x + " ");
    }
}

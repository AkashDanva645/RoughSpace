package DataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {

    static void quickSort(ArrayList<Integer> arr, int l, int r) {


    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(5, 1, 1, 2, 0, 0));
        quickSort(arr, 0, arr.size() - 1);
        for (Integer x: arr) System.out.println(x + " ");
    }
}

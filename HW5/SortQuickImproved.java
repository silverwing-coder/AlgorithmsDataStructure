package HW5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortQuickImproved {

    // private static final int CUTOFF = 10;

    public static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    public static void exch(Comparable[] a, int lo, int hi) {
        Comparable tmp = a[lo];
        a[lo] = a[hi];
        a[hi] = tmp;
    }

    /* Implement a method that returns the index of median value element */
    public static int medianOf3(Comparable[] a, int i, int j, int k) {
        if (less(a[j], a[i]) && less(a[i], a[k])) {
            return i;
        } else if (less(a[i], a[j]) && less(a[j], a[k])) {
            return j;
        } else {
            return k;
        }
    }

    /* Implement Insertion Sort */
    public static void insertionSort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    public static void quickSort(Comparable[] a, int CUTOFF) {
        quickSort(a, 0, a.length - 1, CUTOFF);
    }

    public static void quickSort(Comparable[] a, int lo, int hi, int CUTOFF) {

        /* Implement: Check CUTOFF number of elements and call Insertion sort. */
        if (hi <= (lo + CUTOFF)) {
            insertionSort(a);
            return;
        }

        /*
         * Check median valued element's index and swap the element with the first
         * element of data array.
         */
        int median = medianOf3(a, lo, lo + ((hi - lo) / 2), hi);
        exch(a, lo, median);

        /* Partition and recursive Quick Sort methods */
        int j = partition(a, lo, hi);
        quickSort(a, lo, j - 1, CUTOFF);
        quickSort(a, j + 1, hi, CUTOFF);
    }

    /* Implement Partition method */
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);

        return j;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub

        int CUTOFF = 10; // Cut off value for Insertion Sort execution

        // Scanner inp = new Scanner(new File("path-to-data-file"));
        // String[] data = new String[100];
        String file = "data/words.txt";
        Scanner scanner = new Scanner(new File(file));
        int N = 100;
        String[] data = new String[N];

        for (int i = 0; i < N; i++) {
            data[i] = scanner.nextLine();
            // System.out.println(i + "-" + data[i]);
            //

        }

        // Comparable[] data = { 4, 7, 9, 0, 3, 6, 2, 1 }; // Testing data

        quickSort(data, CUTOFF);
        // Insertion.sort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.println(i + "-" + data[i] + ",  ");
        }

    }

}
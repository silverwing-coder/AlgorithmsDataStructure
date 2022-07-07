package HW5;

import java.io.FileNotFoundException;

public class SortMergeBU {
    private static Comparable[] aux;

    /*
     * Implement a method that compares variable v and w. If v < w -> return true,
     * else return false
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;

    }

    /*
     * Implement a method that swaps of array elements of a[i] and a[j]
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {

                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    /*
     * Implement merge sort algorithm
     */
    public static void mergeSortBU(Comparable[] a) {
        aux = new Comparable[a.length];
        int n = a.length;
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < (n - len); lo += (len + len)) {
                merge(a, lo, (lo + len) - 1, Math.min((lo + len + len) - 1, n - 1));
            }
        }
    }

    /*
     * Implement testing code for your shell sort implementation. 1. Read the first
     * 100 words from data file(words.txt) and store them in an array 2. Sort the
     * words in alphabetical order using your merge sorting implementation. 3. Print
     * out the 100 sorted words
     */

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        // Scanner inp = new Scanner(new File("path-to-data-file"));
        // String[] data = new String[100];

        Comparable[] data = { 4, 7, 9, 0, 3, 6, 2, 1 };
        // for (int i = 0; i < data.length; i++) {
        // System.out.println(data[i]);
        // }
        mergeSortBU(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",  ");
        }

    }

}

package HW4;

import java.io.FileNotFoundException;

public class SortQuick {

    public static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    public static void exch(Comparable[] a, int lo, int hi) {
        Comparable tmp = a[lo];
        a[lo] = a[hi];
        a[hi] = tmp;
    }

    public static void sortQuick(Comparable[] a) {
        sortQuick(a, 0, a.length - 1);
    }

    public static void sortQuick(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sortQuick(a, lo, j - 1);
        sortQuick(a, j + 1, hi);
    }

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
        // Scanner inp = new Scanner(new File("path-to-data-file"));
        // String[] data = new String[100];

        Comparable[] data = { 4, 7, 9, 0, 3, 6, 2, 1 };

        sortQuick(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",  ");
        }

    }

}

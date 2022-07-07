package HW6;

public class SortHeap {

    /**
     * Heap sort constructor 1. Create a priority queue(Heap data structure) 2. Sort
     * down elements in the priority queue
     */
    public static void sortHeap(Comparable[] pq) {
        int n = pq.length;

        // heapify phase
        for (int k = n / 2; k >= 1; k--) {
            sinkDown(pq, k, n);
        }

        // sortdown phase
        int k = n;
        while (k > 1) {
            exch(pq, 1, k--);
            sinkDown(pq, 1, k);
        }
    }

    // Restore the heap invariant.
    private static void sinkDown(Comparable[] pq, int k, int n) {
        while ((2 * k) <= n) {
            int j = 2 * k;
            if ((j < n) && less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    // Helper functions for comparisons and swaps. Indices aSre "off-by-one" to
    // support 1-based indexing.

    private static boolean less(Comparable[] pq, int i, int j) {
        return pq[i - 1].compareTo(pq[j - 1]) < 0;
    }

    private static void exch(Object[] pq, int i, int j) {
        Object tmp = pq[i - 1];
        pq[i - 1] = pq[j - 1];
        pq[j - 1] = tmp;
    }

    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {

        String[] data = { "A", "C", "O", "K", "D", "L", "E", "P" };
        sortHeap(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " -> ");
        }
    }
}
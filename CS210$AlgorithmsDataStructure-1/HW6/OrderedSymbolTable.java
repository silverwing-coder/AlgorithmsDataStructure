package HW6;

public class OrderedSymbolTable<Key, Value> {

    private static final int MAX_SIZE = 100;

    private Value[] vals; // symbol table values
    private Key[] keys; // symbol table keys
    private int n = 0; // number of elements in symbol table

    public OrderedSymbolTable() {
        keys = (Key[]) new Object[MAX_SIZE];
        vals = (Value[]) new Object[MAX_SIZE];
    }

    // return the number of key-value pairs in the symbol table
    public int size() {
        return n;
    }

    // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }

    // insert the key-value pair into the symbol table
    public void put(Key key, Value val) {

        boolean lgst = false;

        if (n == 0) {
            keys[0] = key;
            vals[0] = val;
            n++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (((Comparable) keys[i]).compareTo(key) == 0) {
                // System.out.println(keys[i] + "-" + key + "-" + val);
                vals[i] = val;
                // n--;
                return;
            } else if (((Comparable) keys[i]).compareTo(key) > 0) {
                // System.out.println(key + "-" + keys[i]);

                for (int j = n; j > i; j--) {
                    keys[j] = keys[j - 1];
                    vals[j] = vals[j - 1];
                }
                keys[i] = key;
                vals[i] = val;
                n++;
                return;
            }
        }

        // add new key and value at the end of array
        vals[n] = val;
        keys[n] = key;
        n++;
    }

    public Value get(Key key) {
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    // public int getPosition(Key key) {
    // for (int i = 0; i < n; i++) {
    //// String st = (String) keys[i];
    //// String ke = (String) key;
    // if (((Comparable) keys[i]).compareTo(key) == 0) {
    //// if (st.compareTo(ke) == 0) {
    // return i;
    // }
    // }
    // return -1;
    // }

    public boolean contains(Key key) {
        return (get(key) != null);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(keys[i]);
        }
        return queue;
    }

    // remove given key (and associated value)
    public void delete(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                for (int j = i + 1; j < n; j++) {
                    keys[i] = keys[j];
                    vals[i] = vals[j];
                }
                keys[n - 1] = null;
                vals[n - 1] = null;
                n--;
                return;
            }
        }
    }

    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {

        String[] keys = { "S", "E", "A", "R", "C", "H", "E", "X", "A", "M", "P", "L", "E" };

        OrderedSymbolTable<String, Integer> st = new OrderedSymbolTable<String, Integer>();

        for (int i = 0; i < keys.length; i++) {
            // String key = keys[i];
            st.put(keys[i], i);
            // System.out.println(key + "-" + i);
        }
        System.out.println("key\t value");
        for (String s : st.keys()) {
            System.out.println(s + " \t " + st.get(s));
        }
    }
}
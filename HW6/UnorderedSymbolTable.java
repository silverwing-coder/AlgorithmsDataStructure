package HW6;

import HW2.Queue;

//import edu.princeton.cs.algs4.Queue;

public class UnorderedSymbolTable<Key, Value> {
    private static final int MAX_SIZE = 100;

    private Value[] vals; // symbol table values
    private Key[] keys; // symbol table keys
    private int n = 0; // number of elements in symbol table

    public UnorderedSymbolTable() {
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

        // to deal with duplicates
        delete(key);

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
                keys[i] = keys[n - 1];
                vals[i] = vals[n - 1];
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

        UnorderedSymbolTable<String, Integer> st = new UnorderedSymbolTable<String, Integer>();

        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            st.put(key, i);
        }
        System.out.println("key\t value");
        for (String s : st.keys()) {
            System.out.println(s + " ->\t " + st.get(s));
        }
    }
}
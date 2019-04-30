import objects.Entry;

import java.util.*;

abstract class HashTable {

    protected LinkedList<Entry>[] myTable;

    /**
     * Constructs a new HashTable.
     *
     * @param capacity to be used as capacity of the table.
     * @throws IllegalArgumentException if the input capacity is invalid.
     */
    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException();

        myTable = new LinkedList[capacity];
    }

    /**
     * Add a key value pair to the HashTable.
     *
     * @param key   to identify the value.
     * @param value that is identified by the key.
     */
    public void put(String key, Integer value) {
        int hash = 0;
        if (key != null)
            hash = this.hash(key);
        Entry e = new Entry(key, value);
        if(!this.containsKey(key))
            myTable[hash].add(e);
        else {
            LinkedList<Entry> list = myTable[hash];
            for(int i = 0; i < list.size(); i++) {
                Entry ee = list.get(i);
                if(e != null) {
                    String k = e.getKey();
                    if(k != null && k.equals(key))
                        list.set(i, e);
                }
            }

        }

    }

    /**
     * @param key to look for in the HashTable.
     * @return true iff the key is in the HashTable.
     */
    public boolean containsKey(String key) {
        int hash = 0;
        if(key != null)
            hash = this.hash(key);
        LinkedList<Entry> list = myTable[hash];
        for(int i = 0; i < list.size(); i++) {
            Entry e = list.get(i);
            if(e != null) {
                String k = e.getKey();
                if(k != null && k.equals(key))
                    return true;
            }
        }
        return false;
    }

    /**
     * Get a value from the HashTable.
     *
     * @param key that identifies the value.
     * @return the value associated with the key or `null` if the key is not in the HashTable.
     */
    public Integer get(String key) {
        int hash = 0;
        if(key != null)
            hash = this.hash(key);
        LinkedList<Entry> list = myTable[hash];
        for(int i = 0; i < list.size(); i++) {
            Entry e = list.get(i);
            if(e != null) {
                String k = e.getKey();
                if(k != null && k.equals(key))
                    return e.value;
            }
        }
        return null;
    }

    /**
     * @return the capacity of the HashTable.
     */
    public int getCapacity() {
        return myTable.length;
    }

    /**
     * Hashes a string/key.
     *
     * @param item to hash.
     * @return the hashcode of the string, modulo the capacity of the HashTable.
     */
    public abstract int hash(String item);

    class ETHHash extends HashTable {
        public ETHHash(int size) {
            super(size);
        }

        @Override
        public int hash(String item) {
            if(item.length() == 0)
                return 1;
            int ci = item.charAt(0);
            return ci * ((hash(item.substring(1, item.length())) % 257) + 1);
        }
    }
}

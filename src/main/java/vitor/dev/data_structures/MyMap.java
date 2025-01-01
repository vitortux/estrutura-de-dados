package vitor.dev.data_structures;

import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V> {
    private Entry<K, V>[] entries;
    private int size;

    public MyMap() {
        entries = new Entry[10];
        size = 0;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    void grow() {
        int newLength = entries.length + 1;
        Entry<K, V>[] newEntries = (Entry<K, V>[]) new Entry[newLength];

        for (int i = 0; i < size; i++) {
            newEntries[i] = entries[i];
        }

        entries = newEntries;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean containsKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(Object value) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].value.equals(value)) {
                return true;
            }
        }

        return false;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }

        return null;
    }

    public Object put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].key.equals(key)) {
                Object oldValue = entries[i].value;
                entries[i].value = value;
                return oldValue;
            }
        }

        if (size == entries.length) {
            grow();
        }

        entries[size++] = new Entry<>(key, value);
        return null;
    }

    public Object remove(Object key) {
        for (int i = 0; i < size; i++) {
            if (entries[i] != null && entries[i].key.equals(key)) {
                Object removedValue = entries[i].value;

                for (int j = i; j < size - 1; j++) {
                    entries[j] = entries[j + 1];
                }

                entries[--size] = null;
                return removedValue;
            }
        }

        return null;
    }

    public void putAll(MyMap<K, V> m) {
        for (int i = 0; i < m.size; i++) {
            if (m.entries[i] != null) {
                put(m.entries[i].key, m.entries[i].value);
            }
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            entries[i] = null;
        }

        size = 0;
    }

    public Set<K> keySet() {
        Set<K> keySet = new HashSet<>();
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                keySet.add(entries[i].key);
            }
        }
        return keySet;
    }

    public V[] values() {
        V[] values = (V[]) new Object[size];

        for (int i = 0; i < entries.length; i++) {
            values[i] = entries[i].value;
        }

        return values;
    }

    public Set entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();

        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                entrySet.add(entries[i]);
            }
        }

        return entrySet;
    }
}

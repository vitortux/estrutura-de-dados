package vitor.dev.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySet<T> implements Iterable<T> {

    private Object[] items;
    private int size;

    public MySet() {
        items = new Object[10];
        size = 0;
    }

    void grow() {
        int newLength = items.length + 1;
        Object[] newItems = new Object[newLength];

        for (int i = 0; i < size; i++) {
            newItems[i] = items[i];
        }

        items = newItems;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) items[currentIndex++];
            }
        };
    }

    public Object[] toArray() {
        Object[] newArray = new Object[size];

        for (int i = 0; i < size; i++) {
            newArray[i] = items[i];
        }

        return newArray;
    }

    public Object[] toArray(Object[] a) {
        if (a.length < size) {
            a = new Object[size];
        }

        for (int i = 0; i < size; i++) {
            a[i] = items[i];
        }

        return a;
    }

    public boolean add(T e) {
        if (contains(e)) {
            return false;
        }

        if (size == items.length) {
            grow();
        }

        items[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                for (int j = i; j < size - 1; j++) {
                    items[j] = items[j + 1];
                }

                items[size - 1] = null;
                size--;
                return true;
            }
        }

        return false;
    }

    public boolean containsAll(MySet<T> c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    public boolean addAll(MySet<T> c) {
        boolean added = false;

        for (T item : c) {
            if (add(item)) {
                added = true;
            }
        }

        return added;
    }

    public boolean retainAll(MySet<T> c) {
        boolean removed = false;

        for (int i = size - 1; i >= 0; i--) {
            Object item = items[i];

            if (!c.contains(item)) {
                remove(item);
                removed = true;
            }
        }

        return removed;
    }

    public boolean removeAll(MySet<T> c) {
        boolean removed = false;

        for (Object item : c) {
            if (remove(item)) {
                removed = true;
            }
        }

        return removed;
    }

    public void clear() {
        items = new Object[10];
        size = 0;
    }
}

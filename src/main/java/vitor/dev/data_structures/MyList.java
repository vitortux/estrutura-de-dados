package vitor.dev.data_structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class MyList<T> {
    private Object[] items;
    private int size;

    public MyList() {
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

    void grow(int increment) {
        Object[] newItems = new Object[items.length + increment];

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
        return indexOf(o) >= 0;
    }

    public Iterator iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
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
        if (size == items.length) {
            grow();
        }
        items[size++] = e;
        return true;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if ((o == null && items[i] == null) || (o != null && o.equals(items[i]))) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection c) {
        for (Object item : c) {
            if (!contains(item)) {
                return false;
            }
        }

        return true;
    }

    public boolean addAll(Collection c) {
        for (Object item : c) {
            add((T) item);
        }

        return containsAll(c);
    }

    public boolean addAll(int index, Collection c) {
        if (c == null || c.isEmpty()) {
            return false;
        }

        int numElementsToAdd = c.size();

        if (size + numElementsToAdd > items.length) {
            grow(numElementsToAdd);
        }

        for (int i = size - 1; i >= index; i--) {
            items[i + numElementsToAdd] = items[i];
        }

        int i = index;
        for (Object item : c) {
            items[i++] = item;
        }

        size += numElementsToAdd;

        return true;
    }

    public boolean removeAll(Collection c) {
        boolean removed = false;

        for (Object item : c) {
            if (remove(item)) {
                removed = true;
            }
        }
        return removed;
    }

    public boolean retainAll(Collection c) {
        boolean modified = false;

        for (int i = 0; i < size; i++) {
            Object item = items[i];

            if (!c.contains(item)) {
                remove(item);
                modified = true;
                i--;
            }
        }

        return modified;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }
        size = 0;
    }

    public Object get(int index) {
        return items[index];
    }

    public Object set(int index, Object element) {
        Object oldValue = items[index];
        items[index] = element;
        return oldValue;
    }

    public void add(int index, Object element) {
        if (size == items.length) {
            grow();
        }

        for (int i = size; i > index; i--) {
            items[i] = items[i - 1];
        }

        items[index] = element;
        size++;
    }

    public Object remove(int index) {
        Object removedItem = items[index];
        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        items[--size] = null;
        return removedItem;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public ListIterator listIterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    public ListIterator listIterator(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
    }

    public MyList<T> subList(int fromIndex, int toIndex) {
        MyList<T> subList = new MyList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add((T) items[i]);
        }

        return subList;
    }
}

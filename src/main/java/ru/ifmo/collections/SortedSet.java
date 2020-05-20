package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Object> contents;

    private SortedSet(TreeMap<T, Object> contents) {
        this.contents = contents;
    }
    public static <T> SortedSet<T> create() {
        return new SortedSet<>(new TreeMap<>());
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(new TreeMap<>(comparator));
    }

    public ArrayList<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public ArrayList<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.size();
    }

    @Override
    public boolean add(T t) {
        int oldSize = contents.size();
        contents.put(t, null);

        return oldSize != contents.size();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        int oldSize = contents.size();
        for (T v : c) {
            add(v);
        }

        return oldSize != contents.size();
    }

    @Override
    public boolean remove(Object o) {
        int oldSize = contents.size();
        contents.remove(o);

        return oldSize != contents.size();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        int oldSize = contents.size();
        for (Object v : c) {
            remove(v);
        }

        return oldSize != contents.size();
    }
}

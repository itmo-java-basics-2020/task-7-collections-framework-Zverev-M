package ru.ifmo.collections;

import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * Represents LRU cache with fixed maximum capacity.
 *
 * get() should return null if there is no value for a given key.
 * elements() should return number of elements in cache.
 *
 * This class should not have any other public methods.
 *
 * Implementing this cache in (almost) the same manner as it was implemented during the lecture will result in extra points.
 */
public class LruCache<K, V> {
    private int capacity;
    private HashMap<K, V> hashMap;
    private ArrayDeque<K> queue;

    public LruCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<K, V>();
        queue = new ArrayDeque<K>();
    }

    public V get(K key) {
        if (!queue.contains(key)) {
            return null;
        } else {
            addToStory(key);
            return hashMap.get(key);
        }
    }

    public void put(K key, V value) {
        addToStory(key);
        hashMap.put(key, value);
    }

    public int elements() {
        return queue.size();
    }

    private void addToStory(K key) {
        if (queue.contains(key)) {
            queue.remove(key);
        }

        queue.add(key);
        if (queue.size() > capacity) {
            hashMap.remove(queue.poll());
        }
    }
}
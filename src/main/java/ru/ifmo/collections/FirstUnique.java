package ru.ifmo.collections;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private HashMap<Integer, Boolean> hashMap;
    private ArrayList<Integer> story;

    public FirstUnique(int[] numbers) {
        hashMap = new HashMap<Integer, Boolean>();
        story = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            story.add(numbers[i]);
            add(numbers[i]);
        }
    }

    public int showFirstUnique() {
        for (int i = 0; i < story.size(); i++) {
            if (hashMap.get(story.get(i)).equals(false)) {
                return story.get(i);
            }
        }

        return -1;
    }

    public void add(int value) {
        if (hashMap.containsKey(value)) {
            hashMap.replace(value, true);
        } else {
            hashMap.put(value, hashMap.containsKey(value));
        }

        story.add(value);
    }
}

package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public final class DuplicateRemover {
    public <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {
        Set<T> seenItems = new HashSet<>();
        ArrayList<T> uniqueItems = new ArrayList<>();

        for (T item : list) {
            if (seenItems.add(item)) {
                uniqueItems.add(item);
            }
        }

        return uniqueItems;
    }
}

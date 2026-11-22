package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DuplicateRemoverTest {
    private DuplicateRemover duplicateRemover;

    @BeforeEach
    void setUp() {
        duplicateRemover = new DuplicateRemover();
    }

    @Test
    void returnsANewEmptyListForEmptyInput() {
        ArrayList<Integer> numbers = new ArrayList<>();

        ArrayList<Integer> result = duplicateRemover.removeDuplicates(numbers);

        assertEquals(List.of(), result);
        assertNotSame(numbers, result);
    }

    @Test
    void keepsASingleItem() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(1));

        assertEquals(List.of(1), duplicateRemover.removeDuplicates(numbers));
    }

    @Test
    void returnsANewListWhenAllItemsAreUnique() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(3, 1, 2));

        ArrayList<Integer> result = duplicateRemover.removeDuplicates(numbers);

        assertEquals(numbers, result);
        assertNotSame(numbers, result);
    }

    @Test
    void removesDuplicatesInFirstOccurrenceOrderAndPreservesTheInput() {
        List<Integer> original = List.of(3, 1, 3, 5, 1, 5);
        ArrayList<Integer> numbers = new ArrayList<>(original);

        ArrayList<Integer> result = duplicateRemover.removeDuplicates(numbers);

        assertEquals(List.of(3, 1, 5), result);
        assertEquals(original, numbers);
    }

    @Test
    void removesEqualStrings() {
        ArrayList<String> letters = new ArrayList<>(List.of("A", "A", "B"));

        assertEquals(List.of("A", "B"), duplicateRemover.removeDuplicates(letters));
    }
}

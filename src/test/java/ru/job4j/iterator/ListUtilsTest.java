package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddBeforeFirstItem() {
        ListUtils.addBefore(input, 0, 0);
        assertThat(input).hasSize(3).containsSequence(0, 1, 3);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addAfter(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfterLastItem() {
        ListUtils.addAfter(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 3, 2);
    }

    @Test
    void whenRemoveIf() {
        ListUtils.removeIf(input, integer -> integer == 3);
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void whenRemoveIfNoMatch() {
        ListUtils.removeIf(input, integer -> integer == 5);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveIfAllMatch() {
        ListUtils.removeIf(input, integer -> integer > 0);
        assertThat(input).isEmpty();
    }

    @Test
    void whenReplaceIf() {
        ListUtils.replaceIf(input, integer -> integer == 3, 0);
        assertThat(input).hasSize(2).containsSequence(1, 0);
    }

    @Test
    void whenReplaceIfNoMatch() {
        ListUtils.replaceIf(input, integer -> integer == 5, 0);
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenReplaceAllMatch() {
        ListUtils.replaceIf(input, integer -> integer > 0, 0);
        assertThat(input).hasSize(2).containsSequence(0, 0);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, Arrays.asList(2, 3, 4));
        assertThat(input).hasSize(1).containsSequence(1);
    }

    @Test
    void whenRemoveAllNoMatch() {
        ListUtils.removeAll(input, Arrays.asList(5, 6, 7));
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }

    @Test
    void whenRemoveAllAllMatch() {
        ListUtils.removeAll(input, Arrays.asList(1, 2, 3, 4));
        assertThat(input).isEmpty();
    }

    @Test
    void whenRemoveAllEmptyElements() {
        ListUtils.removeAll(input, new ArrayList<>());
        assertThat(input).hasSize(2).containsSequence(1, 3);
    }
}
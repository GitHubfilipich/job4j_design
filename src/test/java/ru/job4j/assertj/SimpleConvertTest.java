package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        var list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1))
                .noneMatch(Objects::isNull)
                .allMatch(s -> s.length() <= 6)
                .startsWith("first", "second")
                .endsWith("four", "five")
                .containsSequence("second", "three")
                .allSatisfy(s -> assertThat(s).isNotEqualTo("six"))
                .element(1)
                .isEqualTo("second");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        var set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).hasSize(5)
                .contains("second")
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("six")
                .noneMatch(Objects::isNull)
                .allMatch(s -> s.length() <= 6)
                .allSatisfy(s -> assertThat(s).isNotEqualTo("six"))
                .filteredOn(s -> s.charAt(0) == 'f')
                .hasSize(3)
                .doesNotContain("second");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        var map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).hasSize(5)
                .containsKeys("first", "second")
                .doesNotContainKey("six")
                .containsValues(1, 3)
                .doesNotContainValue(5)
                .containsEntry("first", 0)
                .doesNotContainEntry("zero", -1)
                .allSatisfy((s, integer) -> assertThat(integer).isLessThan(5));
    }
}
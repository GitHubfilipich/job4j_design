package ru.job4j.ood.parking.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled("Тесты отключены до момента реализации всех методов")
class MercedesTest {

    @Test
    void whenGetSize() {
        int size = 1;
        Auto auto = new Mercedes(size);
        assertThat(auto.getSize()).isEqualTo(size);
    }
}
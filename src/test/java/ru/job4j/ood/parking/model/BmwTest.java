package ru.job4j.ood.parking.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BmwTest {

    @Test
    void whenGetSize() {
        int size = 3;
        Auto auto = new Bmw(size);
        assertThat(auto.getSize()).isEqualTo(size);
    }
}
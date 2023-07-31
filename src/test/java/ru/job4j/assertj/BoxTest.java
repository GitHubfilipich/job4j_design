package ru.job4j.assertj;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotBlank()
                .startsWith("Sp")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotBlank()
                .startsWith("Te")
                .isEqualTo("Tetrahedron");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .isNotBlank()
                .startsWith("Cu")
                .isEqualTo("Cube");
    }

    @Test
    void theNumberOfVerticesIs0() {
        Box box = new Box(0, 1);
        int number = box.getNumberOfVertices();
        assertThat(number).isNotNull()
                .isNotNegative()
                .isEqualTo(0);
    }

    @Test
    void theNumberOfVerticesIs4() {
        Box box = new Box(4, 1);
        int number = box.getNumberOfVertices();
        assertThat(number).isNotNull()
                .isNotNegative()
                .isNotZero()
                .isEqualTo(4);
    }

    @Test
    void theNumberOfVerticesIsMinus1() {
        Box box = new Box(1, 1);
        int number = box.getNumberOfVertices();
        assertThat(number).isNotNull()
                .isNotZero()
                .isNegative()
                .isEqualTo(-1);
    }

    @Test
    void isExistWhenTheNumberOfVerticesIs0() {
        Box box = new Box(0, 1);
        boolean exist = box.isExist();
        assertThat(exist).isNotNull()
                .isTrue();
    }

    @Test
    void isExistWhenTheNumberOfVerticesIs8() {
        Box box = new Box(8, 1);
        boolean exist = box.isExist();
        assertThat(exist).isNotNull()
                .isTrue();
    }

    @Test
    void isNotExistWhenTheNumberOfVerticesIs1() {
        Box box = new Box(1, 1);
        boolean exist = box.isExist();
        assertThat(exist).isNotNull()
                .isFalse();
    }

    @Test
    void areaIs0() {
        Box box = new Box(1, 1);
        double area = box.getArea();
        assertThat(area).isNotNull()
                .isNotNegative()
                .isBetween(-1D, 1D)
                .isZero();
    }

    @Test
    void areaIs6() {
        Box box = new Box(8, 1);
        double area = box.getArea();
        assertThat(area).isNotNull()
                .isNotNegative()
                .isNotZero()
                .isEqualTo(6, Offset.offset(0.001D));
    }
}
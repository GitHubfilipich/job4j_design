package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void when3ThenCorrectAnswerFizz() {
        assertThat(Fool.getCorrectAnswer(3)).isEqualTo("Fizz");
    }

    @Test
    void when5ThenCorrectAnswerBuzz() {
        assertThat(Fool.getCorrectAnswer(5)).isEqualTo("Buzz");
    }

    @Test
    void when15ThenCorrectAnswerFizzBuzz() {
        assertThat(Fool.getCorrectAnswer(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void when9And3ThenDivisibleByIsTrue() {
        assertThat(Fool.isDivisibleBy(9, 3)).isTrue();
    }

    @Test
    void when15And5ThenDivisibleByIsTrue() {
        assertThat(Fool.isDivisibleBy(15, 5)).isTrue();
    }

    @Test
    void when10And4ThenDivisibleByIsFalse() {
        assertThat(Fool.isDivisibleBy(10, 4)).isFalse();
    }
}
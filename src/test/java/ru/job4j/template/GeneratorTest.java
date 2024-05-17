package ru.job4j.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GeneratorTest {

    @Test
    void whenCorrectParametersThenProduceCorrectResult() {
        Generator generator = (template, args) -> "I am a Petr Arsentev, Who are you?";
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        String result = "I am a Petr Arsentev, Who are you?";
        assertThat(generator.produce(template, args)).isEqualTo(result);
    }

    @Test
    void whenTooMuchParametersInTemplateThenGetException() {
        Generator generator = (template, args) -> {
            throw new IllegalArgumentException();
        };
        String template = "I am a ${name}, I am ${age} years old, Who are ${subject}";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenTooMuchEntriesInArgsThenGetException() {
        Generator generator = (template, args) -> {
            throw new IllegalArgumentException();
        };
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of("name", "Petr Arsentev", "subject", "you", "age", "30");
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
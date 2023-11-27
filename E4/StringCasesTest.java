import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCasesTest {

    @Test
    @DisplayName("Test camelCase")
    void camelCase() {
        assertAll(
                () -> assertEquals("helloWorld", StringCases.camelCase("Hello World")),
                () -> assertEquals("helloWorld", StringCases.camelCase("HELLO WoRLd!.")),
                () -> assertEquals("helloNewWorld", StringCases.camelCase("Hello 43 .4new. World")),
                () -> assertEquals("helloworld", StringCases.camelCase("HelloWorld")),
                () -> assertEquals("helloHowAreYouToday", StringCases.camelCase("Hello, how789 !a8re 0y_ou? t=o+d56ay??")));
    }

    @Test
    @DisplayName("Test pascalCase")
    void pascalCase() {
        assertAll(
                () -> assertEquals("HelloWorld", StringCases.pascalCase("Hello World")),
                () -> assertEquals("HelloWorld", StringCases.pascalCase("HELLO WoRLd!.")),
                () -> assertEquals("HelloNewWorld", StringCases.pascalCase("Hello 43 .4new. World")),
                () -> assertEquals("Helloworld", StringCases.pascalCase("HelloWorld 78 .!")),
                () -> assertEquals("HelloHowAreYouToday", StringCases.pascalCase("Hello, how789 !a8re 0y_ou? t=o+d56ay??")));
    }

    @Test
    @DisplayName("Test snakeCase")
    void snakeCase() {
        assertAll(
                () -> assertEquals("hello_world", StringCases.snakeCase("Hello World")),
                () -> assertEquals("hello_world", StringCases.snakeCase("HELLO WoRLd!.")),
                () -> assertEquals("hello_new_world", StringCases.snakeCase("Hello 43 .4new. World")),
                () -> assertEquals("helloworld", StringCases.snakeCase("HelloWorld 78 .!")),
                () -> assertEquals("hello_how_are_you_today", StringCases.snakeCase("Hello, how789 !a8re 0y_ou? t=o+d56ay??")));
    }

    @Test
    @DisplayName("Test screamingSnakeCase")
    void screamingSnakeCase() {
        assertAll(
                () -> assertEquals("HELLO_WORLD", StringCases.screamingSnakeCase("Hello World")),
                () -> assertEquals("HELLO_WORLD", StringCases.screamingSnakeCase("HELLO WoRLd!.")),
                () -> assertEquals("HELLO_NEW_WORLD", StringCases.screamingSnakeCase("Hello 43 .4new. World")),
                () -> assertEquals("HELLOWORLD", StringCases.screamingSnakeCase("HelloWorld 78 .!")),
                () -> assertEquals("HELLO_HOW_ARE_YOU_TODAY", StringCases.screamingSnakeCase("Hello, how789 !a8re 0y_ou? t=o+d56ay??")));

    }

    @Test
    @DisplayName("Test alternateCase")
    void alternateCase() {
        assertAll(
                () -> assertEquals("HeLlOwOrLd", StringCases.alternateCase("Hello World")),
                () -> assertEquals("HeLlOwOrLd", StringCases.alternateCase("HELLO WoRLd!.")),
                () -> assertEquals("HeLlOnEwWoRlD", StringCases.alternateCase("Hello 43 .4new. World")),
                () -> assertEquals("HeLlOwOrLd", StringCases.alternateCase("HelloWorld 78 .!")),
                () -> assertEquals("HeLlOhOwArEyOuToDaY", StringCases.alternateCase("Hello, how789 !a8re 0y_ou? t=o+d56ay??")));
    }
}
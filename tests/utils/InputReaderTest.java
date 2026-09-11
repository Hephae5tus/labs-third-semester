package tests.utils;

import org.junit.jupiter.api.Test;
import utils.InputReader;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    @Test
    void createList_readsNumbersUntilStopWord() {
        Scanner scanner = new Scanner("5\n10\n-3\nstop\n");
        PrintStream out = new PrintStream(new ByteArrayOutputStream());

        List<Integer> result = InputReader.createList(scanner, "Enter a number", "stop", out);

        assertEquals(List.of(5, 10, -3), result);
    }

    @Test
    void createList_skipsInvalidNonNumericInputAndWarns() {
        Scanner scanner = new Scanner("abc\n7\nstop\n");
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        List<Integer> result = InputReader.createList(scanner, "Enter a number", "stop", out);

        assertEquals(List.of(7), result);
        assertTrue(outStream.toString().contains("Invalid value. Try again."));
    }

    @Test
    void createList_stopsImmediatelyOnStopWord() {
        Scanner scanner = new Scanner("stop\n");
        PrintStream out = new PrintStream(new ByteArrayOutputStream());

        List<Integer> result = InputReader.createList(scanner, "Enter a number", "stop", out);

        assertTrue(result.isEmpty());
    }

    @Test
    void createList_usesCustomStopWord() {
        Scanner scanner = new Scanner("1\n2\ndone\n");
        PrintStream out = new PrintStream(new ByteArrayOutputStream());

        List<Integer> result = InputReader.createList(scanner, "Enter", "done", out);

        assertEquals(List.of(1, 2), result);
    }

    @Test
    void readInt_returnsParsedValue() {
        Scanner scanner = new Scanner("42\n");
        PrintStream out = new PrintStream(new ByteArrayOutputStream());

        int result = InputReader.readInt(scanner, "Enter k: ", out);

        assertEquals(42, result);
    }

    @Test
    void readInt_retriesOnInvalidInputUntilValidNumber() {
        Scanner scanner = new Scanner("abc\n\n15\n");
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        int result = InputReader.readInt(scanner, "Enter: ", out);

        assertEquals(15, result);
        assertTrue(outStream.toString().contains("Invalid value. Try again."));
    }

    @Test
    void readInt_acceptsNegativeNumbers() {
        Scanner scanner = new Scanner("-8\n");
        PrintStream out = new PrintStream(new ByteArrayOutputStream());

        assertEquals(-8, InputReader.readInt(scanner, "Enter: ", out));
    }

    @Test
    void constructor_isPrivateAndThrows() throws Exception {
        Constructor<InputReader> constructor = InputReader.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(UnsupportedOperationException.class, ex.getCause());
    }
}

package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class XorTest {
    @Test
    public void testConvertToHex() {
        String input = "Hello World!";
        String expectedOutput = "48 65 6c 6c 6f 20 57 6f 72 6c 64 21";

        assertEquals(expectedOutput, Xor.convertToHex(input));
    }

    @Test
    public void testConvertToHexArray() {
        String input = "Hello World!";
        List<String> expectedOutput = Arrays.asList("48", "65", "6c", "6c", "6f", "20", "57", "6f", "72", "6c", "64", "21");

        assertEquals(expectedOutput, Xor.convertToHexArray(input));
    }

    @Test
    public void testXorEncrypt() {
        String input = "Geheimnachricht";
        String key = "secret";
        List<String> expectedOutput = List.of("34", "0", "b", "17", "c", "19", "1d", "4", "0", "1a", "17", "1d", "10", "d", "17");

        assertEquals(expectedOutput, Xor.xorEncrypt(input, key));
    }

    @Test
    public void testXorDecrypt() {
        List<String> input = List.of("34", "0", "b", "17", "c", "19", "1d", "4", "0", "1a", "17", "1d", "10", "d", "17");
        String key = "secret";
        String expectedOutput = "Geheimnachricht";

        assertEquals(expectedOutput, Xor.xorDecrypt(input, key));
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class XorTest {
    @Test
    void TestConvertToHex(){
        assertEquals(Xor.convertToHex("10"), "48 65 6C 6C 6F 20 57 6F 72 6C 64");
    }

    void TestConvertToHexArray(){
        assertEquals(Xor.convertToHexArray("Hello World"), List.of("48" ,"65" ,"6C", "6C", "6F", "20", "57" ,"6F" ,"72", "6C", "64"));
   }

    @Test
    void TestXorEncript(){
        assertEquals(Xor.xorEncrypt("Hello World", "A8") , List.of(String.valueOf(0xe3),String.valueOf(0xce),String.valueOf(0xc7),String.valueOf(0xc7),String.valueOf(0xc4),String.valueOf(0x8b),String.valueOf(0xfc),String.valueOf(0xc4),String.valueOf(0xd9),String.valueOf(0xc7),String.valueOf(0xcf)));
    }



    @Test
    void TestXorDecript(){
        assertEquals(Xor.xorDecrypt(List.of("0", "0", "0", "0"), "AB"), "ABAB");
        assertEquals(Xor.xorDecrypt(List.of("A", "B", "A", "B"), "00"), "ABAB");
        assertEquals(Xor.xorDecrypt(List.of("0", "1", "0", "1"), "A0"), "ABAB");
    }

    @Test
    void TestCreateKey(){
        assertEquals(Xor.createKey(List.of("0", "0", "0", "0"), List.of("A","B")), List.of("A", "B","A","B") );
    }
}
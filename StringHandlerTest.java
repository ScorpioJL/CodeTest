package com.jasonli;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringHandlerTest {
    @Test
    public void isAlphabetTest(){
        StringHandler sh = new StringHandler();

        // 1. All numbers
        sh.setTargetStr("111222333");
        assertFalse(sh.isAlphabet());

        // 2. Contains numbers and alphabet
        sh.setTargetStr("111aaa333");
        assertFalse(sh.isAlphabet());

        // 3. All lower alphabets
        sh.setTargetStr("aaabbbccc");
        assertTrue(sh.isAlphabet());

        // 4. All others characters
        sh.setTargetStr("!@#$%^&*()");
        assertFalse(sh.isAlphabet());

        // 5. Contains others characters and alphabet
        sh.setTargetStr("!@#aaa$%^");
        assertFalse(sh.isAlphabet());

        // 6. Contains others characters, numbers and alphabets
        sh.setTargetStr("123aaa$%^");
        assertFalse(sh.isAlphabet());

        // 7. All alphabets but contains upper case.
        sh.setTargetStr("AaaBbbCcc");
        assertFalse(sh.isAlphabet());

        // 8. String is empty.
        sh.setTargetStr("");
        assertFalse(sh.isAlphabet());
    }

    @Test
    public void isValidStrTest(){
        StringHandler sh = new StringHandler();

        // 1. Only 1 alphabet, 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaabbccde");
        assertTrue(sh.isValidStr());

        // 2. Only 1 alphabet, 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbccde");
        assertTrue(sh.isValidStr());

        // 3. Only 1 alphabet, 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccdeee");
        assertTrue(sh.isValidStr());

        // 4. Only 1 alphabet, More than 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaaaabbccde");
        assertTrue(sh.isValidStr());

        // 5. Only 1 alphabet, More than 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbbbccde");
        assertTrue(sh.isValidStr());

        // 6. Only 1 alphabet, More than 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccdeeeee");
        assertTrue(sh.isValidStr());

        // 7. More than 1 alphabets, More than 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaaabbbbccde");
        assertTrue(sh.isValidStr());

        // 8. More than 1 alphabets, More than 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbbccccde");
        assertTrue(sh.isValidStr());

        // 9. More than 1 alphabets, More than 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccddddeeee");
        assertTrue(sh.isValidStr());

        // 10. No alphabets got 3 consecutive characters appear.
        sh.setTargetStr("aabbccddee");
        assertFalse(sh.isValidStr());
    }

    @Test
    public void handleStrBasicTest(){
        StringHandler sh = new StringHandler();

        // 1. Only 1 alphabet, 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaabbccde");
        sh.handleStrBasic();
        assertEquals("bbccde", sh.getTargetStr());

        // 2. Only 1 alphabet, 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbccde");
        sh.handleStrBasic();
        assertEquals("aaccde", sh.getTargetStr());

        // 3. Only 1 alphabet, 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccdeee");
        sh.handleStrBasic();
        assertEquals("aabbccd", sh.getTargetStr());

        // 4. Only 1 alphabet, More than 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaaaabbccde");
        sh.handleStrBasic();
        assertEquals("bbccde", sh.getTargetStr());

        // 5. Only 1 alphabet, More than 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbbbccde");
        sh.handleStrBasic();
        assertEquals("aaccde", sh.getTargetStr());

        // 6. Only 1 alphabet, More than 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccdeeeee");
        sh.handleStrBasic();
        assertEquals("aabbccd", sh.getTargetStr());

        // 7. More than 1 alphabets, More than 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaaabbbbccde");
        sh.handleStrBasic();
        assertEquals("bbbbccde", sh.getTargetStr());

        // 8. More than 1 alphabets, More than 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbbccccde");
        sh.handleStrBasic();
        assertEquals("aaccccde", sh.getTargetStr());

        // 9. More than 1 alphabets, More than 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccddddeeee");
        sh.handleStrBasic();
        assertEquals("aabbcceeee", sh.getTargetStr());

        // 10. No alphabets got 3 consecutive characters appear.
        sh.setTargetStr("aabbccddee");
        sh.handleStrBasic();
        assertEquals("aabbccddee", sh.getTargetStr());
    }

    @Test
    public void handleStrAdvanceTest(){
        StringHandler sh = new StringHandler();

        // 1. Only 1 alphabet, 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaabbccde");
        sh.handleStrAdvance();
        assertEquals("bbccde", sh.getTargetStr());

        // 2. Only 1 alphabet, 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbccde");
        sh.handleStrAdvance();
        assertEquals("aaaccde", sh.getTargetStr());

        // 3. Only 1 alphabet, 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccdeee");
        sh.handleStrAdvance();
        assertEquals("aabbccdd", sh.getTargetStr());

        // 4. Only 1 alphabet, More than 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaaaabbccde");
        sh.handleStrAdvance();
        assertEquals("bbccde", sh.getTargetStr());

        // 5. Only 1 alphabet, More than 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbbbccde");
        sh.handleStrAdvance();
        assertEquals("aaaccde", sh.getTargetStr());

        // 6. Only 1 alphabet, More than 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccdeeeee");
        sh.handleStrAdvance();
        assertEquals("aabbccdd", sh.getTargetStr());

        // 7. More than 1 alphabets, More than 3 consecutive characters appear in the beginning.
        sh.setTargetStr("aaaabbbbccde");
        sh.handleStrAdvance();
        assertEquals("bbbbccde", sh.getTargetStr());

        // 8. More than 1 alphabets, More than 3 consecutive characters appear in the middle.
        sh.setTargetStr("aabbbbccccde");
        sh.handleStrAdvance();
        assertEquals("aaaccccde", sh.getTargetStr());

        // 9. More than 1 alphabets, More than 3 consecutive characters appear in the end.
        sh.setTargetStr("aabbccddddeeee");
        sh.handleStrAdvance();
        assertEquals("aabbccceeee", sh.getTargetStr());

        // 10. No alphabets got 3 consecutive characters appear.
        sh.setTargetStr("aabbccddee");
        sh.handleStrAdvance();
        assertEquals("aabbccddee", sh.getTargetStr());
    }
}

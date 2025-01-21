package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest {
    /**
     * Test the constructor with a valid binary value
     */
    @Test
    public void normalConstructor() {
        Binary binary = new Binary("1001001");
        assertTrue(binary.getValue().equals("1001001"));
    }

    /**
     * Test the constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits() {
        Binary binary = new Binary("1001001211");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars() {
        Binary binary = new Binary("1001001A");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign() {
        Binary binary = new Binary("-1001001");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the constructor with a zero leading valid binary value
     */
    @Test
    public void constructorWithZeroTailing() {
        Binary binary = new Binary("00001001");
        assertTrue(binary.getValue().equals("1001"));
    }

    /**
     * Test the constructor with an empty string
     */
    @Test
    public void constructorEmptyString() {
        Binary binary = new Binary("");
        assertTrue(binary.getValue().equals("0"));
    }

    /**
     * Test the add function with two binary numbers of the same length
     */
    @Test
    public void add() {
        Binary binary1 = new Binary("1000");
        Binary binary2 = new Binary("1111");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("10111"));
    }

    /**
     * Test the add function where the first argument is shorter
     */
    @Test
    public void add2() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("11");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test the add function where the second argument is shorter
     */
    @Test
    public void add3() {
        Binary binary1 = new Binary("11");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1101"));
    }

    /**
     * Test the add function with zero
     */
    @Test
    public void add4() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("1010");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("1010"));
    }

    /**
     * Test the add function with two zeros
     */
    @Test
    public void add5() {
        Binary binary1 = new Binary("0");
        Binary binary2 = new Binary("0");
        Binary binary3 = Binary.add(binary1, binary2);
        assertTrue(binary3.getValue().equals("0"));
    }

    // -----------------------------------------------------------
    // New Tests for OR, AND, and Multiply
    // -----------------------------------------------------------

    /**
     * Test the bitwise OR function
     */
    @Test
    public void orTest() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        // 1010 OR 1100 = 1110
        Binary result = Binary.or(binary1, binary2);
        assertTrue(result.getValue().equals("1110"));
    }

    /**
     * Test the bitwise AND function
     */
    @Test
    public void andTest() {
        Binary binary1 = new Binary("1010");
        Binary binary2 = new Binary("1100");
        // 1010 AND 1100 = 1000
        Binary result = Binary.and(binary1, binary2);
        assertTrue(result.getValue().equals("1000"));
    }

    /**
     * Test the multiply function
     */
    @Test
    public void multiplyTest() {
        Binary binary1 = new Binary("101");
        Binary binary2 = new Binary("11");
        // decimal 5 * decimal 3 = decimal 15, which is 1111 in binary
        Binary result = Binary.multiply(binary1, binary2);
        assertTrue(result.getValue().equals("1111"));
    }
}

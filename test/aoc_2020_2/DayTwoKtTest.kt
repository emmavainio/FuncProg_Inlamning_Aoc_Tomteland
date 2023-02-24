package aoc_2020_2

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class DayTwoKtTest {

    @Test
    fun testGetInput() {
        val file = "test/aoc_2020_2/puzzleInput.txt"
        val input = getInput(file)
        assertTrue(input.size == 3)
        assertFalse(input.size == 4)
        assertTrue(input[2] == "2-9 c: ccccccccc")
    }

    @Test
    fun testTransformStringToPassword(){
        val string = "1-3 a: abcde"
        val expectedPassword = Password(1..3, 'a', "abcde")
        val notExpectedPassword = Password(1..4, 'b', "abcdef")
        val res = transformStringToPassword(string)
        assertTrue(expectedPassword == res)
        assertFalse(notExpectedPassword == res)
        assertTrue(expectedPassword.password == "abcde")
    }

    @Test
    fun testIsValidPasswordPart1() {
        val validPassport1 = Password(1..3, 'a', "abcde")
        val invalidPassport = Password(1..3, 'b', "cdefg")
        val validPassport2 = Password(2..9, 'c', "ccccccccc")

        assertTrue(validPassport1.isValidPasswordPart1())
        assertTrue(validPassport2.isValidPasswordPart1())
        assertFalse(invalidPassport.isValidPasswordPart1())
    }

    @Test
    fun testIsValidPasswordPart2() {
        val password1 = Password(1..3, 'a', "abcde")
        val password2 = Password(1..3, 'b', "cdefg")
        val password3 = Password(2..9, 'c', "ccccccccc")

        assertTrue(password1.isValidPasswordPart2())
        assertFalse(password2.isValidPasswordPart2())
        assertFalse(password3.isValidPasswordPart2())
    }
}
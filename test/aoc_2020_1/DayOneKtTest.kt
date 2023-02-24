package aoc_2020_1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayOneKtTest {

    @Test
    fun getInputTest() {
        val file = "test/aoc_2020_1/puzzleInput.txt"
        val input = getInput(file)
        assertTrue(input.size == 6)
        assertFalse(input.size == 7)
        assertTrue(input[5] == 1456)
        assertFalse(input[4] == 1456)
    }

    @Test
    fun getSum2020FromTwoNumbersMultipliedTest() {
        val list = listOf(1721, 979, 366, 299, 675, 1456)
        val expected = 514579
        val notExpected = 514556
        val res = getSum2020FromTwoNumbersMultiplied(list)
        assertTrue(res == expected)
        assertFalse(res == notExpected)
    }

    @Test
    fun getSum2020FromThreeNumbersMultipliedTest() {
        val list = listOf(1721, 979, 366, 299, 675, 1456)
        val expected = 241861950
        val notExpected = 241861967
        val res = getSum2020FromThreeNumbersMultiplied(list)
        assertTrue(res == expected)
        assertFalse(res == notExpected)

    }
}
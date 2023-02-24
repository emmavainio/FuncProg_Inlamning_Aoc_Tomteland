package aoc_2021_1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DayOneKtTest {

    @Test
    fun getInputTest() {
        val file = "test/aoc_2021_1/puzzleInput.txt"
        val input = getInput(file)

        assertTrue(input.size == 10)
        assertFalse(input.size == 11)
    }

    @Test
    fun getIncreaseCountPart1Test() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val res = getIncreaseCountPart1(input)
        val expected = 7
        val notExpected = 8

        assertTrue(res == expected)
        assertFalse(res == notExpected)
    }

    @Test
    fun getIncreaseCountPart2Test() {
        val input = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val res = getIncreaseCountPart2(input)
        val expected = 5
        val notExpected = 7

        assertTrue(res == expected)
        assertFalse(res == notExpected)
    }
}
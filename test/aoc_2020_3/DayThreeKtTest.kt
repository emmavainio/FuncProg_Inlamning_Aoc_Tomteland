package aoc_2020_3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayThreeKtTest {

    @Test
    fun getInputTest() {
        val file = "test/aoc_2020_3/puzzleInput.txt"
        val input = getInput(file)
        assertTrue(input.size == 11)
        assertFalse(input.size == 12)
        assertTrue(input[2] == ".#....#..#.")
        assertFalse(input[2] == "..#.#...#.#")
    }

    @Test
    fun getTreeCountTest() {
        val file = "test/aoc_2020_3/puzzleInput.txt"
        val input = getInput(file)

        val resRight1down1 = getTreeCount(input, 1, 1)
        val resRight3down1 = getTreeCount(input, 3, 1)
        val resRight5down1 = getTreeCount(input, 5, 1)
        val expectedRight1down1 = 2L
        val notExpectedRight1down1 = 3L
        val expectedRight3down1 = 7L
        val expectedRight5down1 = 3L

        assertTrue(resRight1down1 == expectedRight1down1)
        assertTrue(resRight3down1 == expectedRight3down1)
        assertTrue(resRight5down1 == expectedRight5down1)

        assertFalse(resRight1down1 == notExpectedRight1down1)

    }
}
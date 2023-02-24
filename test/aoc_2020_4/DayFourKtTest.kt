package aoc_2020_4

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DayFourKtTest {

    @Test
    fun getInputTest() {
        val file = "test/aoc_2020_4/puzzleInput.txt"
        val input = getInput(file)
        assertTrue(input.size == 13)
        assertFalse(input.size == 14)
        assertTrue(input[1] == "byr:1937 iyr:2017 cid:147 hgt:183cm")
        assertFalse(input[1] == "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd")
    }

    @Test
    fun getPassportMapTest() {
        val file = "test/aoc_2020_4/puzzleInput.txt"
        val input = getInput(file)
        val res = getPassportMap(input)
        val expected = listOf(mapOf("ecl" to "gry", "pid" to "860033327", "eyr" to "2020",
        "hcl" to "#fffffd", "byr" to "1937", "iyr" to "2017", "cid" to "147", "hgt" to "183cm"),
            mapOf("iyr" to "2013", "ecl" to "amb", "cid" to "350", "eyr" to "2023", "pid" to "028048884",
                "hcl" to "#cfa07d", "byr" to "1929"))

        assertTrue(res[0] == expected[0])
        assertTrue(res[1] == expected[1])
        assertFalse(res[0] == expected[1])
    }

    @Test
    fun isValidPassportInfoTest() {
        val correctMap = mapOf("ecl" to "gry", "pid" to "860033327", "eyr" to "2020",
            "hcl" to "#fffffd", "byr" to "1937", "iyr" to "2017", "cid" to "147", "hgt" to "183cm")
        val incorrectMap = mapOf("iyr" to "2013", "ecl" to "amb", "cid" to "350", "eyr"
                to "2023", "pid" to "028048884", "hcl" to "#cfa07z", "byr" to "1929")

        assertTrue(correctMap.all { isValidPassportInfo(it.key,it.value) })
        assertTrue(isValidPassportInfo("cid", "147"))
        assertFalse(incorrectMap.all { isValidPassportInfo(it.key,it.value) })
    }

    @Test
    fun getValidPassportCountPart1Test() {
        val file = "test/aoc_2020_4/puzzleInput.txt"
        val input = getInput(file)
        val passports = getPassportMap(input)
        val res = getValidPassportCountPart1(passports)
        val expected = 2
        val notExpected = 3

        assertTrue(res == expected)
        assertFalse(res == notExpected)
    }

    @Test
    fun getValidPassportCountPart2Test() {
        val file = "test/aoc_2020_4/puzzleInput.txt"
        val input = getInput(file)
        val passports = getPassportMap(input)
        val res = getValidPassportCountPart2(passports)
        val expected = 2
        val notExpected = 3

        assertTrue(res == expected)
        assertFalse(res == notExpected)
    }

}
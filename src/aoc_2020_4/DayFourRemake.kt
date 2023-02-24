package aoc_2020_4

import java.io.File

//https://github.com/kotlin-hands-on/advent-of-code-2020/blob/master/src/day04/day4.kt

class Passport(private val map: Map<String, String>) {

    private val requiredFields = setOf("byr", "iyr", "eyr", "ecl", "pid", "hcl", "hgt")

    fun hasAllRequiredFields() = map.keys.containsAll(requiredFields)

    fun isValidPassportInfo2() :Boolean =
        map.all { (key, value) ->
        when (key) {
            "cid" -> true
            "byr" -> value.toIntOrNull()!! in 1920..2002
            "iyr" -> value.toIntOrNull()!! in 2010..2020
            "eyr" -> value.toIntOrNull()!! in 2020..2030
            "ecl" -> value in setOf("amb","blu", "brn","gry", "grn", "hzl", "oth")
            "pid" -> value.length == 9 && value.all { it.isDigit() }
            "hcl" -> value matches """#[a-f0-9]{6}""".toRegex()
            "hgt" -> when(value.takeLast(2)) {
                "cm" -> value.removeSuffix("cm").toIntOrNull() in 150..193
                "in" -> value.removeSuffix("in").toIntOrNull() in 59..76
                else -> false
            }
            else -> false
        }
    }

    companion object {
        fun createPassportFromString(s: String): Passport {
            val fieldsAndValues = s.split(" ", "\n", "\r\n")
            val map = fieldsAndValues.associate {
                val (key, value) = it.split(":")
                key to value
            }
            return Passport(map)
        }
    }
}

fun getValidPassportCountPart1Ver2(passports:List<Passport>) =
    passports.count { it.hasAllRequiredFields() }

fun getValidPassportCountPart2Ver2(passports:List<Passport>) =
    passports.count { it.hasAllRequiredFields() && it.isValidPassportInfo2()}

fun main() {

    val passports = File("src/aoc_2020_4/puzzleInput.txt")
        .readText()
        .trim()
        .split("\n\n", "\r\n\r\n") // Ny rad: "\n\n" linux/ios "\r\n\r\n" windows
        .map { Passport.createPassportFromString(it) }

    println(getValidPassportCountPart1Ver2(passports))
    println(getValidPassportCountPart2Ver2(passports))
}
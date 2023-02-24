package aoc_2020_4

import java.io.File

//https://adventofcode.com/2020/day/4

fun getInput(file: String) = File(file).readLines()

fun getPassportMap(list:List<String>): List<Map<String, String>> {
    val passports = mutableListOf<Map<String, String>>()
    var currentPassport = mutableMapOf<String, String>()
    for (line in list) {
        if (line.trim().isEmpty()) {
            passports.add(currentPassport)
            currentPassport = mutableMapOf()
        } else {
            val keyValuePairs = line.split(" ")
            for (pair in keyValuePairs) {
                val (key, value) = pair.split(":")
                currentPassport[key] = value
            }
        }
    }
    passports.add(currentPassport)
    return passports.toList()
}
fun getValidPassportCountPart1(passportMap:List<Map<String,String>>) =
    passportMap.count { it.size == 8 || (it.size == 7 && !it.containsKey("cid"))}

fun isValidPassportInfo(key:String, value:String) :Boolean {
    when (key) {
        "cid" -> return true
        "byr" -> return value.toIntOrNull()!! in 1920..2002
        "iyr" -> return value.toIntOrNull()!! in 2010..2020
        "eyr" -> return value.toIntOrNull()!! in 2020..2030
        "hcl" -> return value matches "^#[a-f0-9]{6}$".toRegex()
        "ecl" -> return value in setOf("amb","blu", "brn","gry", "grn", "hzl", "oth")
        "pid" -> return value.length == 9 && value.all { it.isDigit() }
        "hgt" -> return when(value.takeLast(2)) {
            "cm" -> value.substring(0,value.length-2).toIntOrNull() in 150..193
            "in" -> value.substring(0,value.length-2).toIntOrNull() in 59..76
            else -> false
        }
    }
    return false
}

fun getValidPassportCountPart2(passportMap:List<Map<String,String>>):Int {
    val filteredMap = passportMap.filter { it.size == 8 || (it.size == 7 && !it.containsKey("cid"))}
    return filteredMap.count { it.all { isValidPassportInfo(it.key,it.value) }}
}

fun main() {
    val file = "src/aoc_2020_4/puzzleInput.txt"
    val input = getInput(file)
    val passports = getPassportMap(input)

    println(getValidPassportCountPart1(passports))
    println(getValidPassportCountPart2(passports))
}
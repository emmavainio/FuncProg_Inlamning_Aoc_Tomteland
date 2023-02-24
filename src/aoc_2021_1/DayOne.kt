package aoc_2021_1

import java.io.File

fun getInput(file: String) = File(file).readLines().map { it.toInt() }

fun getIncreaseCountPart1(list: List<Int>) = list.zipWithNext().count { it.first < it.second }

//dropLast(2) begränsar antalet iterationer i lambdan till längden av listan minus 2
fun getIncreaseCountPart2(list: List<Int>) = list.dropLast(2).
mapIndexed { index, _ -> list[index] + list[index+1] + list[index+2] }.zipWithNext().count{it.first < it.second}

fun main() {
    val file = "src/aoc_2021_1/puzzleInput.txt"
    val input = getInput(file)

    println(getIncreaseCountPart1(input))
    println(getIncreaseCountPart2(input))

}
package aoc_2021_1

import java.io.File

//https://github.com/tginsberg/advent-2021-kotlin/blob/master/src/main/kotlin/com/ginsberg/advent2021/Day01.kt

fun part1(list: List<Int>) = list.zipWithNext().count { it.first < it.second }

fun part2(input:List<Int>): Int =
    input.windowed(3, 1) { it.sum() }.zipWithNext().count { it.first < it.second }

fun main() {
    val file = "src/aoc_2021_1/puzzleInput.txt"
    val input = File(file).readLines().map { it.toInt() }

    println(part1(input))
    println(part2(input))

}
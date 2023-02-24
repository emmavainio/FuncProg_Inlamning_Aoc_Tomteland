package aoc_2020_1

import java.io.File

//https://adventofcode.com/2020/day/1
//https://adventofcode.com/2020/day/1/input

//Ta reda på vilka två och tre siffror som blir 2020 tsm och multiplicera dessa med varandra
fun getInput(file: String) = File(file).readLines().map(String::toInt)

fun getSum2020FromTwoNumbersMultiplied(list: List<Int>): Int {
    for (n in list) {
        if (list.contains(2020 - n))
            return n * (2020 - n)
    }
    return -1
}
fun getSum2020FromThreeNumbersMultiplied(list: List<Int>): Int {
    val set = list.toSet()

    for (i in list.indices)
        for (j in i + 1 until list.size)
            if (set.contains(2020 - list[i] - list[j]))
                return (2020 - list[i] - list[j]) * list[i] * list[j]
    return -1
}

fun main() {

    val file = "src/aoc_2020_1/puzzleInput.txt"
    val input = getInput(file)

    //del 1
    println(getSum2020FromTwoNumbersMultiplied(input))

    //del 2
    println(getSum2020FromThreeNumbersMultiplied(input))
}

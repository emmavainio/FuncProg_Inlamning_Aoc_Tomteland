package aoc_2020_3

import java.io.File

//https://adventofcode.com/2020/day/3
fun getInput(file: String) = File(file).readLines()

fun getTreeCount(list: List<String>, right:Int, down:Int) : Long{
    val width = list.first().length
    var trees = 0L
    for (i in 1 until list.size) {
        if (i*down >= list.size)
            break
        if (list[i*down][(i*right) % width] == '#')
            trees++
    }
    return trees
}

fun main() {

    val file = "src/aoc_2020_3/puzzleInput.txt"
    val input = getInput(file)

    //Part 1
    println(getTreeCount(input, 3, 1))

    //Part 2
    val right1down1 = getTreeCount(input, 1, 1)
    val right3down1 = getTreeCount(input, 3, 1)
    val right5down1 = getTreeCount(input, 5, 1)
    val right7down1 = getTreeCount(input, 7, 1)
    val right1down2 = getTreeCount(input, 1, 2)

    println(right1down1*right3down1*right5down1*right7down1*right1down2)
}
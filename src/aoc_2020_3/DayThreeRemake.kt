package aoc_2020_3

/*
    https://kotlinlang.org/docs/advent-of-code.html#day-3-toboggan-trajectory
 */
fun countTreesOnSlope(input: List<String>, vector:Pair<Int, Int>): Int {
    val (right,down) = vector
    val width = input.first().length

    return input.indices.count{ i -> i % down == 0 && input[i][i / down * right % width] == '#'}
}
fun main() {

    val file = "src/aoc_2020_3/puzzleInput.txt"
    val input = getInput(file)
    //Part 1
    println(countTreesOnSlope(input, 3 to 1))
    //Part 2
    val vectors = listOf(1 to 1, 3 to 1, 5 to 1, 7 to 1, 1 to 2)
    println(vectors.map { countTreesOnSlope(input, it).toLong() }.reduce { a, b -> a * b })
}
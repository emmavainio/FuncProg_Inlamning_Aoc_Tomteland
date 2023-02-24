package aoc_2020_1

import java.io.File

//https://www.reddit.com/r/adventofcode/comments/k4e4lm/comment/gexfshn/?utm_source=share&utm_medium=web2x&context=3

fun getInput(file:File) = file.readLines().map(String::toInt).toHashSet()
fun addUpTo(sum:Int, numbers:HashSet<Int>) = numbers.filter { numbers.contains(sum - it) }
//filtrerar bort de siffror där (summan - elementet) finns i setet och returnerar lista med de två element vars summa är sum
fun threeAddUpTo(total:Int, numbers:HashSet<Int>) = numbers.filter { addUpTo(total - it, numbers).isNotEmpty() }
//använder addUpTo men skickar in 2020-sig själv för att få ut dom 3 siffror som blir 2020 tillsammans
fun main() {

    val file = File("src/aoc_2020_1/puzzleInput.txt")
    val input = getInput(file)

    // part 1
    println(addUpTo(2020, input).let { it[0] * it[1] })
    // part2
    println(threeAddUpTo(2020, input).let { it[0] * it[1] * it[2] })

    // let tillåter mig att utföra en operation på objekten direkt och returnera resultatet av operationen.
}
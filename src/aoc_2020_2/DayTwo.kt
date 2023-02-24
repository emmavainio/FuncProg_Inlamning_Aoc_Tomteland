package aoc_2020_2

import java.io.File

//https://adventofcode.com/2020/day/2
//https://adventofcode.com/2020/day/2/input
//räkna ut hur många lösenord i input som är godkända
//Part 1: räkna antal av spec bokstav och se om antal är inom range
//Part 2: säkerställ om bokstaven är på första eller sista platsen i rangen men inte båda

data class Password(val range: IntRange, val letterInPw: Char, val password: String)

fun Password.isValidPasswordPart1() = password.count { it == letterInPw } in range

fun Password.isValidPasswordPart2() =
    (password[range.first - 1] == letterInPw) xor (password[range.last - 1] == letterInPw)

fun getInput(file: String) = File(file).readLines()

fun transformStringToPassword(string: String): Password {
    val stringList = string.split(" ")
    val range = stringList[0].split("-")
    return Password(
        range[0].toInt()..range[1].toInt(),
        stringList[1][0],
        stringList[2])
}
fun main() {

    val file = "src/aoc_2020_2/puzzleInput.txt"
    val passwordList = getInput(file).map { transformStringToPassword(it) }

    println(passwordList.count { it.isValidPasswordPart1() })

    println(passwordList.count { it.isValidPasswordPart2() })
}

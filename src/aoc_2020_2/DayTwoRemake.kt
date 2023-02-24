package aoc_2020_2

import java.io.File
/*
    https://todd.ginsberg.com/post/advent-of-code/2020/day2/
    https://github.com/tginsberg/advent-2020-kotlin/blob/main/src/main/kotlin/com/ginsberg/advent2020/Day02.kt

 */
data class Password2(val range: IntRange, val letterInPw: Char, val password: String) {

    val validPart1 = password.count { it == letterInPw } in range

    val validPart2 = (password[range.first-1] == letterInPw) xor (password[range.last-1] == letterInPw)

    companion object {
    // companion object gör så att jag kommer åt objektet och dess metod genom Password-klassen och behöver inte skapa
    // en egen instans av den
        private val pattern = """^(\d+)-(\d+) ([a-z]): (.+)$""".toRegex()

        // (\d+) - En eller flera siffror, ([a-z]) - En bokstav mellan a-z, (.+) - En eller flera tecken.

        fun of(input: String): Password2 {
            val (min, max, letter, password) = pattern.matchEntire(input)!!.destructured
            return Password2(min.toInt() .. max.toInt(), letter.first(), password)
        }
        //matchEntire()!! för att se att strängen matchar regex och inte är null.
        // .destructed tilldelar min, max, letter, password sina värden
    }
}
fun main() {

    val file = "src/aoc_2020_2/puzzleInput.txt"
    val passwordList = File(file).readLines().map { Password2.of(it) }

    println(passwordList.count { it.validPart1 })
    println(passwordList.count { it.validPart2 })
}
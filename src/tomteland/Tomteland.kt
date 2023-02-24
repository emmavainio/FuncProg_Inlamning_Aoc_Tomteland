package tomteland

class Tomteland {

    private val tomtar = mapOf("Tomten" to mutableListOf("Glader", "Butter"),
                    "Glader" to mutableListOf("Tröger", "Trötter", "Blyger"),
                    "Butter" to mutableListOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
                    "Trötter" to mutableListOf("Skumtomten"),
                    "Skumtomten" to mutableListOf("Dammråttan"),
                    "Räven" to mutableListOf("Gråsuggan", "Myran"),
                    "Myran" to mutableListOf("Bladlusen"))

    // current namn är den tomte vars underlydande ni vill ta fram
    //res är listan som håller alla underlydande
    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        if(tomtar.containsKey(currentName)) {
            tomtar[currentName]!!.forEach { res.add(it) }
            tomtar[currentName]!!.forEach { getUnderlings(it, res) }
        }
        return res
    }
}

fun main() {

    var list: MutableList<String> = mutableListOf()
    val tomteland = Tomteland()
    println(tomteland.getUnderlings("Tomten", list))
    list = mutableListOf()
    println(tomteland.getUnderlings("Trötter", list))

}
fun main() {
    val color = readln().lowercase()
    println(Rainbow.isRainbow(color))
}
enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet"),
    NULL("");

    companion object {
        fun isRainbow(color: String): Boolean {
            for (enum in Rainbow.values()){
                if (color == enum.color) return true
            }
            return false
        }
    }
}
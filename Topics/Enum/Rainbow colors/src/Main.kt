fun main() {
    // put your code here
    val color = readLine()!!
    println(Rainbow.isRainbowColor(color))
}

enum class Rainbow(val color: String) {
    RED("red"),
    ORANGE("orange"),
    YELLOW("yellow"),
    GREEN("green"),
    BLUE("blue"),
    INDIGO("indigo"),
    VIOLET("violet");

    companion object {

        fun isRainbowColor(color: String): Boolean {
            for (mColor in values()) {
                if (color.contentEquals(mColor.color)) return true
            }
            return false
        }
    }
}
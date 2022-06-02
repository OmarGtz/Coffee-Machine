fun main() {
    // change the code below

    for (i in 2..10) {
        val thirteen = 13L
        var result = thirteen
        for (i in 2..i) {
            result *= thirteen
        }
        println(result)
    }
}
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    val result: Double = when (readLine()) {
        "triangle" -> {

            val a = readLine()?.toDouble()!!
            val b = readLine()?.toDouble()!!
            val c = readLine()?.toDouble()!!
            Math.sqrt((a + b + c) / 2 * ((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c))
        }
        "rectangle" -> {
            val a = readLine()?.toDouble()!!
            val b = readLine()?.toDouble()!!
            a * b
        }
        "circle" -> {
            val r = readLine()?.toDouble()!!
            3.14 * r.pow(2)
        }
        else -> {
            0.0
        }
    }
    println(result)
}